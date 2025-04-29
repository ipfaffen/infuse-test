import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SearchGetService {
  private endpointUrl = 'http://localhost:8080/creditos/credito';
  private minSearchLength = 4;

  constructor(private http: HttpClient) {}

  search(query: string): Observable<any[]> {
    if(!query || query.length < this.minSearchLength) return of([]);
    const url = `${this.endpointUrl}/${query}`;
    return this.http
      .get<any[]>(url)
      .pipe(
        catchError(error => {
          console.error('Error in search service:', error);
          return of([]);
        })
      );
  }
}