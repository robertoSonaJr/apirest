package com.produtos.apirest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.produtos.apirest.model.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value="API Rest Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource{

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    @ApiOperation(value="Retorna uma lista de produtos.")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    @ApiOperation(value="Retorna um produto único.")
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/produto")
    @ApiOperation(value="Salva um produto.")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produto")
    @ApiOperation(value="Deleta um produto")
    public void deletaProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }

    @PutMapping("/produto")
    @ApiOperation(value="Atualiza um produto.")
    public Produto atualizaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
}