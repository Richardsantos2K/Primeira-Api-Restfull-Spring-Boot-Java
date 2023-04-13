package com.teste.primeiroexemplo.repository;

import com.teste.primeiroexemplo.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProdutoRepositoryNew extends JpaRepository<Produto, Integer> {

}

