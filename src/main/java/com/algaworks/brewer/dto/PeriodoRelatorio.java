package com.algaworks.brewer.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class PeriodoRelatorio {

	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate dataInicio;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate dataFim;

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

}