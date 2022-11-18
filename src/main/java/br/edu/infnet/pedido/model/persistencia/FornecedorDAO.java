package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.Cliente;
import br.edu.infnet.pedido.model.entidade.Fornecedor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO extends JdbcDAO<Fornecedor> {

    public FornecedorDAO(){

    }

    @Override
    public Boolean salvar(Fornecedor fornecedor) {
        String sql = "insert into fornecedor(descricao, codigo, telefone) values (?,?, ?)";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, fornecedor.getDescricao());
            pstm.setLong(2, fornecedor.getCodigo());
            pstm.setString(3, fornecedor.getTelefone());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public Boolean atualizar(Fornecedor fornecedor) {
        String sql = "update fornecedor set descricao = ?, telefone = ? where codigo = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, fornecedor.getDescricao());
            pstm.setString(2, fornecedor.getTelefone());
            pstm.setLong(3, fornecedor.getCodigo());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deletar(Fornecedor fornecedor) {
        String sql = "delete from fornecedor where codigo = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setLong(1, fornecedor.getCodigo());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Fornecedor obter(Long codigo){
        String sql = "select * from fornecedor where codigo = ?";
        Fornecedor fornecedor = new Fornecedor();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setLong(1, codigo);
            rs = pstm.executeQuery();
            if(rs.next()) {
                String descricao = rs.getString("descricao");
                Long codigoDB = rs.getLong("codigo");
                String telefone = rs.getString("telefone");
                fornecedor = new Fornecedor(codigoDB, descricao, telefone);
            }
            return fornecedor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Fornecedor> listarTodos() {
        String sql = "select * from fornecedor";
        List<Fornecedor> fornecedores = new ArrayList<>();
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()) {
                String descricao = rs.getString("descricao");
                Long codigo = rs.getLong("codigo");
                String telefone = rs.getString("telefone");
                Fornecedor fornecedor = new Fornecedor(codigo, descricao, telefone);
                fornecedores.add(fornecedor);
            }
            return fornecedores;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


//    @Override
//    public List<Cliente> listarTodos(){
//        String sql = "select * from cliente";
//        List<Cliente> clientes = new ArrayList<>();
//        try {
//            stm = con.createStatement();
//            rs = stm.executeQuery(sql);
//            while(rs.next()) {
//                String nome = rs.getString("nome");
//                Long codigo = rs.getLong("codigo");
//                Cliente cliente = new Cliente(nome, codigo);
//                clientes.add(cliente);
//            }
//            return clientes;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
