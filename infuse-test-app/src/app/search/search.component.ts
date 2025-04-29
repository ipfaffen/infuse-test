import { Component } from '@angular/core';
import { SearchListService } from '../services/search-list.service';
import { SearchGetService } from '../services/search-get.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class SearchComponent {
  searchQueryNfse: string = '';
  searchQueryNumeroCredito: string = '';
  searchQuery: string = '';
  searchResults: any[] = [];
  isLoading: boolean = false;
  isNfse: boolean = false;
  private searchSubject = new Subject<string>();

  constructor(private searchListService: SearchListService, private searchGetService: SearchGetService) {
    this.searchSubject.pipe(
      debounceTime(800),
      distinctUntilChanged()
    ).subscribe(query => {
      this.performSearch(query);
    });
  }

  onInputChange(nfse: boolean): void {
    this.isNfse = nfse;
    this.searchQuery = (nfse ? this.searchQueryNfse : this.searchQueryNumeroCredito);
    if(nfse) this.searchQueryNumeroCredito = '';
    else this.searchQueryNfse = '';
    this.searchSubject.next(this.searchQuery);
  }

  performSearch(query: string): void {
    this.isLoading = true;
    let service;
    if(this.isNfse) service = this.searchListService;
    else service = this.searchGetService;
    service.search(query).subscribe({
      next: (results) => {
        if(!Array.isArray(results)) results = [results];
        this.searchResults = results;
        this.isLoading = false;
      },
      error: (error) => {
        console.error('Error fetching search results', error);
        this.isLoading = false;
      }
    });
  }
}
