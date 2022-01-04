package com.unifacef.rentalapi.gateways.outputs.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacef.rentalapi.domain.Cliente;
import com.unifacef.rentalapi.gateways.outputs.mongodb.repositories.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new RuntimeException("Não encontramos nenhum cliente com o ID informado. " +
                "ID: " + id + "Tipo: " + Cliente.class.getName()));
    }

    public Cliente insert(Cliente cliente) {
        cliente.setId(null);
        return clienteRepository.save(cliente);
    }


}
