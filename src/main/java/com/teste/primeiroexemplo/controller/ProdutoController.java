package com.teste.primeiroexemplo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.services.ProdutoService;

@RestController//estamos dizendo que isto é um controlador
@RequestMapping(value = "/api/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {
    @Autowired //PARA INJETAR O VALOR
    private ProdutoService produtoService;

    @GetMapping//PARA OBTER O PRODUTO
    public List<Produto> obterTodos(){
        return produtoService.obterTodos();
    }

    @GetMapping("/{id}")// PARA OBTER POR ID
    public Optional<Produto> obterPorId(@PathVariable Integer id){ //Path é caminho Variable é variavel
        return produtoService.obterPorId(id);
    }


    @PostMapping//PARA ADICIONAR
    public Produto adicionar(@RequestBody Produto produto){
        return produtoService.adicionar(produto);
    }

    @DeleteMapping("/{id}")//PARA DELETAR
    public String deletar(@PathVariable Integer id){
        produtoService.deletar(id);
            return "Produto com id " + id + " foi deletado com sucesso!";
    }

    @PutMapping("/{id}")//PARA ATUALIZAR
    public Produto atualizar(@RequestBody Produto produto, @PathVariable Integer id){
        return produtoService.atualizar(id, produto);

    }

}
