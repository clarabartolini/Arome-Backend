package org.example.arome.repositories;

import org.example.arome.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNome(String nome); // Caso o nome seja único
    List<Produto> findAll();
    void deleteByNome(String nome); // Retorna o número de registros deletados
}

