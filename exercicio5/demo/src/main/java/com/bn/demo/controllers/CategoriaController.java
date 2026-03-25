package com.bn.demo.controllers;

import com.bn.demo.models.CategoriaModel;
import com.bn.demo.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = {"/categorias", "/categorias/"})
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
        public ResponseEntity<List<CategoriaModel> > buscarTodasAsCategorias(){
          List<CategoriaModel> requeste = categoriaService.buscarTodasCategorias();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity <CategoriaModel> criarCategorias(@RequestBody CategoriaModel categoriaModel){
        CategoriaModel requeste = categoriaService.criarCategoria(categoriaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(categoriaModel.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCategoria(@PathVariable Long id){
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<CategoriaModel> buscarCategoriaPorId(@PathVariable Long id){
        return  categoriaService.buscarCategoriaId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity <CategoriaModel> atualizar(@PathVariable Long id, @RequestBody CategoriaModel CategoriaModel){
        CategoriaModel requeste = categoriaService.atualizarCategoria(id, CategoriaModel);
        return  ResponseEntity.ok().body(requeste);

    }








}
