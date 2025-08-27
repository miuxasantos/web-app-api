/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.unipar.service;

/**
 *
 * @author miuxa
 */
@Service
public class CategoriaService {
    
    private final CategoriaRepository categoriaRepository;
    
    CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }
    
    public Categoria salvarCat(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    
    public <List>Categoria listarCat(){
        return categoriaRepository.findAll();
    }
    
    public Categoria buscarPorIdCat(Long id){
        return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Id incorreto."));
    }
    
    public void deletarCat(Long id){
        categoriaRepository.deleteById(id);
    }
    
    public Categoria atualizarCat(Long id, Categoria categoria){
        Categoria categoriaSalva = buscarPorIdCat(id);
        BeanUtils.copyProperties(categoria, categoriaSalva, "id");
        return categoriaRepository.save(categoriaSalva);
    }
}
