package com.produtos.apirest.controller;

import com.produtos.apirest.repository.ProdutoRepository;

import java.util.List;

import com.produtos.apirest.models.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping(value = "/api")
@Api(value = "API Rest Produtos - Spring")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping(value="/produtos")
    @ApiOperation(value = "Retorna uma lista de produtos")
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }
    
    
    @GetMapping(value="/produto/{id}")
    @ApiOperation(value = "Retorna um produto unico")
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
        return produtoRepository.findById(id);
    }
    
    @PostMapping(value="/produto")
    @ApiOperation(value = "Salva um produto")
    public Produto salvaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
    @DeleteMapping(value = "/produto")
    @ApiOperation(value = "Delata um produto")
    public void deletaProduto(@RequestBody Produto produto) {
        produtoRepository.delete(produto);
        // produtoRepository.deleteById(id);
    }
    
    @PutMapping(value="/produto")
    @ApiOperation(value = "Atualiza um produto")
    public Produto atualizaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
    
}