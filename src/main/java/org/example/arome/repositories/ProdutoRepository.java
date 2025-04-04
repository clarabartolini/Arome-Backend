package org.example.arome.repositories;

import org.example.arome.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Optional<Produto> findByNome(String nome); // Caso o nome seja único
}

