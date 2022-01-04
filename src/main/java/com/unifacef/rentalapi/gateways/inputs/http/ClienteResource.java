package com.unifacef.rentalapi.gateways.inputs.http;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unifacef.rentalapi.domain.Cliente;
import com.unifacef.rentalapi.gateways.outputs.mongodb.ClienteService;

import java.net.URI;

@RestController
@RequestMapping(value="/v1/aluguel-api/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value="id/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok().body(cliente);
    }

    public ResponseEntity<Void> insert(@RequestBody Cliente cliente) {
        cliente = clienteService.insert(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
