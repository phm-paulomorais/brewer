package com.algaworks.brewer.service.event.venda;

import com.algaworks.brewer.model.StatusVenda;
import com.algaworks.brewer.model.Venda;


public class VendaEvent {
	
	private Venda venda;

	public VendaEvent(Venda venda) {
		this.venda = venda;
	}
	
	
	public Venda getVenda() {
		return venda;
	}
	
	public boolean isVendaEmitida() {
		return this.venda.getStatus() == StatusVenda.EMITIDA;
	}
	
	public boolean isVendaCancelada() {
		return this.venda.getStatus() == StatusVenda.CANCELADA;
	}
	
}
