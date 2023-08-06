package br.com.estudos.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudos.crud.DAOs.IProfissionalRepository;

@RestController
@RequestMapping("/api/profissionais")
public class ProfissionaisApiController {
    @Autowired
    private IProfissionalRepository repo;    

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable int id){                   

        if(!repo.existsById(id)){            
            return ResponseEntity.status(404).body("Profissonal não Encontrado");
        }        
        repo.deleteById(id);

        return ResponseEntity.status(204).body("");
    }  
}
