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
        public ResponseEntity<List<CategoriaModel> > findAll(){
          List<CategoriaModel> requeste = categoriaService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity <CategoriaModel> criarPessoa(@RequestBody CategoriaModel categoriaModel){
        CategoriaModel requeste = categoriaService.criarPessoa(categoriaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(categoriaModel.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (@PathVariable Long id){
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Optional<CategoriaModel> buscarId(@PathVariable Long id){
        return  categoriaService.buscarid(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity <CategoriaModel> atualizar(@PathVariable Long id, @RequestBody CategoriaModel CategoriaModel){
        CategoriaModel requeste = categoriaService.atualizar(id, CategoriaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(CategoriaModel.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(requeste);

    }








}
