package br.edu.infnet.pedido.model.entidade;

public class Fornecedor {

    Long codigo;
    String descricao;
    String telefone;

    public Fornecedor() {
    }

    public Fornecedor(Long codigo, String descricao, String telefone) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.telefone = telefone;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
