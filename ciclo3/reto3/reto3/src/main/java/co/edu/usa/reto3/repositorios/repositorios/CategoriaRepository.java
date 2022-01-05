/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.repositorios.repositorios;

import co.edu.usa.reto3.modelo.Categoria;
import co.edu.usa.reto3.repositorios.crud.CategoriaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author andresruedalibre
 */
@Repository
public class CategoriaRepository {
    @Autowired
    private CategoriaCrudRepository repoCategoria;
    
    public List<Categoria> getAll(){
        return (List<Categoria>)repoCategoria.findAll();
    }
    
    public Optional<Categoria> getById(int id) {
        return repoCategoria.findById(id);
    }
    
    public Categoria save(Categoria categoria){
        return repoCategoria.save(categoria);
    }
}
