package br.com.estudos.crud.DTOs;

import br.com.estudos.crud.interfaces.IObjectDTO;

public class ProfissionalDTO implements IObjectDTO{
    private String nome;
    private String Observacao;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacao() {
        return Observacao;
    }
    public void setObservacao(String observacao) {
        Observacao = observacao;
    }
    
}
