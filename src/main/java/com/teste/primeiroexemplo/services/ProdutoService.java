package com.teste.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.repository.ProdutoRepositoryOld;


@Service
public class ProdutoService {
    
    @Autowired //invertendo controle, quem toma conta sou eu, ele devolvera uma instancia pronta para usar
    private ProdutoRepositoryOld produtoRepository;

    /**
     * Metodo para retornar uma lista de produtos
     * @return Lista de produtos
     */
    public List<Produto> obterTodos(){
        return produtoRepository.obterTodos();
    }



        /**
     * Metodo que retorna o produto encontrado pelo Id.
     * @param id do produto que será localizado
     * @return Retorna o Produto caso seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtoRepository.obterPorId(id);
    }

        /**
     * Metodo para adicionar produto na lista.
     * @param produto produto que sera adicionado
     * @return retorna o produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto){
        //poderia ter alguma regra de negocio para validar o produto.
        return produtoRepository.adicionar(produto);//Devolvendo produto
        
    }


     /**
     * Metodo para deletar o produto por id
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        //aqui poderia ter alguma logica de validação
        produtoRepository.deletar(id);
    }



     /**
     * Metodo para atualizar o produto na lista
     * @param produto que sera atualizado
     * @param id do produto
     * @return Retorna o produto após atualizar a lista
     */
    public Produto atualizar(Integer id, Produto produto){
        // ter alguima validação no ID.
        produto.setId(id);

        return produtoRepository.atualizar(produto);
        
    }

}

