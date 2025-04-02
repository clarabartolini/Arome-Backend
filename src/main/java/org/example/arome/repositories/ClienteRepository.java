package org.example.arome.repositories;

import org.example.arome.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByEmail(String email);  // Buscar cliente pelo email
    Cliente findByCpf(String cpf);      // Buscar cliente pelo CPF
}

