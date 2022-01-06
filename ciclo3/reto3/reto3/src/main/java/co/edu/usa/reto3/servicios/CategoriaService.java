/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.servicios;

import co.edu.usa.reto3.modelo.Categoria;
import co.edu.usa.reto3.repositorios.repositorios.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andresruedalibre
 */
@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public List<Categoria> getAll(){
    return categoriaRepository.getAll();
    }
    
    public Categoria save(Categoria categoria){
        if ((categoria.getName().length()>45) || (categoria.getDescription().length()>250)){
            return categoria;
        }else{
        return categoriaRepository.save(categoria);
        }
    }
    
    public Categoria getById(int id){
    Optional<Categoria> categoria = categoriaRepository.getById(id);
    return categoria.orElse(new Categoria());
    }
}
