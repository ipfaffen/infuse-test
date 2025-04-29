package com.infuse.test.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Function;

import com.infuse.test.entity.Credito;

public class CreditoResponse {

	private String numeroCredito;
	private String numeroNfse;
	private LocalDate dataConstituicao;
	private BigDecimal valorIssqn;
	private String tipoCredito;
	private Boolean simplesNacional;
	private BigDecimal aliquota;
	private BigDecimal valorFaturado;
	private BigDecimal valorDeducao;
	private BigDecimal baseCalculo;

	public static Function<Credito, CreditoResponse> mapper = credito -> builder()
		.numeroCredito(credito.getNumeroCredito())
		.numeroNfse(credito.getNumeroNfse())
		.dataConstituicao(credito.getDataConstituicao())
		.valorIssqn(credito.getValorIssqn())
		.tipoCredito(credito.getTipoCredito())
		.simplesNacional(credito.getSimplesNacional())
		.aliquota(credito.getAliquota())
		.valorFaturado(credito.getValorFaturado())
		.valorDeducao(credito.getValorDeducao())
		.baseCalculo(credito.getBaseCalculo());

	public static CreditoResponse builder() {
		return new CreditoResponse();
	}

	public CreditoResponse numeroCredito(String numeroCredito) {
		this.numeroCredito = numeroCredito;
		return this;
	}

	public CreditoResponse numeroNfse(String numeroNfse) {
		this.numeroNfse = numeroNfse;
		return this;
	}

	public CreditoResponse dataConstituicao(LocalDate dataConstituicao) {
		this.dataConstituicao = dataConstituicao;
		return this;
	}

	public CreditoResponse valorIssqn(BigDecimal valorIssqn) {
		this.valorIssqn = valorIssqn;
		return this;
	}

	public CreditoResponse tipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
		return this;
	}

	public CreditoResponse simplesNacional(Boolean simplesNacional) {
		this.simplesNacional = simplesNacional;
		return this;
	}

	public CreditoResponse aliquota(BigDecimal aliquota) {
		this.aliquota = aliquota;
		return this;
	}

	public CreditoResponse valorFaturado(BigDecimal valorFaturado) {
		this.valorFaturado = valorFaturado;
		return this;
	}

	public CreditoResponse valorDeducao(BigDecimal valorDeducao) {
		this.valorDeducao = valorDeducao;
		return this;
	}

	public CreditoResponse baseCalculo(BigDecimal baseCalculo) {
		this.baseCalculo = baseCalculo;
		return this;
	}

	public String getNumeroCredito() {
		return numeroCredito;
	}

	public String getNumeroNfse() {
		return numeroNfse;
	}

	public LocalDate getDataConstituicao() {
		return dataConstituicao;
	}

	public BigDecimal getValorIssqn() {
		return valorIssqn;
	}

	public String getTipoCredito() {
		return tipoCredito;
	}

	public Boolean getSimplesNacional() {
		return simplesNacional;
	}

	public BigDecimal getAliquota() {
		return aliquota;
	}

	public BigDecimal getValorFaturado() {
		return valorFaturado;
	}

	public BigDecimal getValorDeducao() {
		return valorDeducao;
	}

	public BigDecimal getBaseCalculo() {
		return baseCalculo;
	}
}