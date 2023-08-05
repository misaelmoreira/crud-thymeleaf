package br.com.estudos.crud.DAOs;

import org.springframework.data.repository.CrudRepository;

import br.com.estudos.crud.models.Profissional;

public interface IProfissionalRepository extends CrudRepository<Profissional, Integer>{
    
}
