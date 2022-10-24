package br.edu.infnet.pedido.model.persistencia;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.infnet.pedido.model.entidade.Cliente;

public class ClienteDAOTest {

	@Test
	public void test() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente("Jose das Couves"); 
		boolean validacao = clienteDAO.salvar(cliente);
		Assert.assertTrue(validacao);
	}
	
	@Test
	public void testListaClientes() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> lista = clienteDAO.listarTodos();
		Assert.assertTrue(lista.size() > 0);
	}
	

}
