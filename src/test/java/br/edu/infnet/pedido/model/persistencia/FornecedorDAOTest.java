package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.Cliente;
import br.edu.infnet.pedido.model.entidade.Fornecedor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FornecedorDAOTest {

//    @Before
//    public void inicializar() {
//        IDAO fornecedorDAO = new FornecedorDAO();
//        Fornecedor fornecedor = new Fornecedor(1l, "Fornecedor 01", "6111112222");
//        fornecedorDAO.salvar(fornecedor);
//    }

    @Test
    public void test(){
        IDAO fornecedorDAO = new FornecedorDAO();
        Fornecedor fornecedor = new Fornecedor(1l, "Fornecedor 02", "6111112222");
        boolean validacao = fornecedorDAO.salvar(fornecedor);
        Assert.assertTrue(validacao);

    }

    @Test
    public void testUpdate() {
        IDAO fornecedorDAO = new FornecedorDAO();
        List<Fornecedor> lista = fornecedorDAO.listarTodos();
        Fornecedor fornecedor = new Fornecedor(lista.get(0).getCodigo(), "Fornecedor alterado", "55555555");
        boolean validacao = fornecedorDAO.atualizar(fornecedor);
        Assert.assertTrue(validacao);
    }

    @Test
    public void testDelete() {
        IDAO fornecedorDAO = new FornecedorDAO();
        List<Fornecedor> lista = fornecedorDAO.listarTodos();
        Fornecedor fornecedor = new Fornecedor(lista.get(lista.size()-1).getCodigo(), "Fornecedor alterado", "55555555");
        boolean validacao = fornecedorDAO.deletar(fornecedor);
        Assert.assertTrue(validacao);
    }

    @Test
    public void testListaFornecedores() {
        IDAO fornecedorDAO = new FornecedorDAO();
        List<Fornecedor> lista = fornecedorDAO.listarTodos();
        Assert.assertTrue(lista.size() > 0);
    }

    @Test
    public void testObterFornecedor() {
        IDAO fornecedorDAO = new FornecedorDAO();
        List<Fornecedor> lista = fornecedorDAO.listarTodos();
        Object fornecedor = fornecedorDAO.obter(lista.get(0).getCodigo());
        Assert.assertNotNull(fornecedor);;
    }
}
