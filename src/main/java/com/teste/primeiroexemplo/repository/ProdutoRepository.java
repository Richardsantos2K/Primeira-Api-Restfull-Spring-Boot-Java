package com.teste.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.model.exception.ResourceNotFoundException;

import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository {
    
    //Simulando banco de dados
    private ArrayList<Produto> produtos = new ArrayList<>();
    private Integer ultimoId = 0;



    /**
     * Metodo para retorna uma lista de produtos
     * @return lista de produtos
     */
    public List<Produto> obterTodos(){
        return produtos;
    }



    /**
     * Metodo que retorna o produto encontrado pelo Id.
     * @param id do produto que será localizado
     * @return Retorna o Produto caso seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos
        .stream()//Stream define várias operações que podem ser reunidas em duas categorias
        .filter(produto -> Objects.equals(produto.getId(), id))//filter() é um recurso que permite fazer a filtragem de elementos com apenas poucas linhas de comandos.
        .findFirst();// findFirst(), que permite retornar o primeiro elemento de uma Stream através de uma instância Optional.

    }



    /**
     * Metodo para adicionar produto na lista.
     * @param produto produto que sera adicionado
     * @return retorna o produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto){
        
        ultimoId++;//incrementa o Id

        produto.setId(ultimoId);//Passar o Id pro produto
        produtos.add(produto);//Adiciona o produto na lista simulandoi um Banco de dados
        
        return produto;//Devolvendo produto
    }


    /**
     * Metodo para deletar o produto por id
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> Objects.equals(produto.getId(), id));//removeIf remove todos os elementos do conjunto que satisfaçam a condição dada.
        //neste metodo ele verificara se o id do produto sera igual o id caso não seja ele passara para o proximo produto sucessivamente até chegar no id, se o id for verdadeiro ele deretara o id(Produto)
    }



    /**
     * Metodo para atualizar o produto na lista
     * @param produto que sera atualizado
     * @return Retorna o produto após atualizar a lista
     */
    public Produto atualizar(Produto produto){
        
        //Encontra o produto na lista
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if (produtoEncontrado.isEmpty()){
            throw new ResourceNotFoundException("Produto não encontrado");
        }

        //Eu tenho que remover o produto antigo da lista. 
        deletar(produto.getId());//Reaproveitando metodos
        
        //Depois adicionar o produto atualizado na lista.
        produtos.add(produto);

        return produto;
        
    }

}
