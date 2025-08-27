/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.unipar.controller;

/**
 *
 * @author miuxa
 */
@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {
    
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    
    @GetMapping("/listar-tudo")
    public List<Categoria> listarCat(){
        return categoriaService.listarCat();
    }
    
    @PostMapping("/cadastrar-cat")
    public Categoria cadastrarCat(@RequestBody Categoria categoria){
        return categoriaService.salvarCat(categoria);
    }
    
    @DeleteMapping("/deletar-cat/{id}")
    public void deletarCat(@PathVariable Long id){
        categoriaService.deletarCat(id);
    }
    
    @PutMapping("/atualizar-cat/{id}")
    public Categoria atualizarCat(@PathVariable Long id, @RequestBody Categoria categoria){
        return categoriaService.atualizarCat(id, categoria);
    }
}
