package br.edu.infnet.pedido.model.entidade;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

	private Long numero;
	
	private LocalDate data;
	
	private Cliente cliente;
	
	private List<Produto> produtos;
	
	
}
