package br.com.estudos.crud.DTOs;

import br.com.estudos.crud.interfaces.IObjectDTO;

public class ProfissionalMinimoDTO implements IObjectDTO{
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
}
