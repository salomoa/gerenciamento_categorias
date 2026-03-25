package com.bn.demo.services;

import com.bn.demo.models.CategoriaModel;
import com.bn.demo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaModel> buscarTodasCategorias(){
        return  categoriaRepository.findAll();
    }

    public CategoriaModel criarCategoria(CategoriaModel categoriaModel){
        return  categoriaRepository.save(categoriaModel);
    }

    public Optional<CategoriaModel> buscarCategoriaId(Long id){
        return  categoriaRepository.findById(id);
    }

    public CategoriaModel atualizarCategoria(Long id, CategoriaModel categoriaModel){
        CategoriaModel model = categoriaRepository.findById(id).get();
        model.setNome(categoriaModel.getNome());
        model.setDescricao(categoriaModel.getDescricao());
        return categoriaRepository.save(model);
    }

    public void deletarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }

}
