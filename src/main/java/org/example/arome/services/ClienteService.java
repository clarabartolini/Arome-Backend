package org.example.arome.services;

import org.example.arome.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.arome.repositories.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public String registerCliente(Cliente cliente) {
        // Verifica se o e-mail ou CPF já existem
        if ((clienteRepository.findByEmail(cliente.getEmail()) != null) || (clienteRepository.findByCpf(cliente.getCpf()) != null)) {
            return "Cliente já cadastrado";
        }
        clienteRepository.save(cliente);
        // Criptografa a senha do cliente


        // Salva o novo cliente no banco de dados


        return "Cliente cadastrado com sucesso";
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente updateCliente(Integer id, Cliente clienteAtualizado) {
        Cliente clienteExistente = getClienteById(id); // Verifica se o cliente existe

        // Atualiza os dados do cliente existente
        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setEmail(clienteAtualizado.getEmail());
        clienteExistente.setCpf(clienteAtualizado.getCpf());
        clienteExistente.setSenha(clienteAtualizado.getSenha());
        clienteExistente.setData_nascimento(clienteAtualizado.getData_nascimento());

        return clienteRepository.save(clienteExistente); // Salva no banco
    }

    public Cliente getClienteById(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    }
    public void deleteCliente(Integer id) {
        clienteRepository.deleteById(id);
    }

}
