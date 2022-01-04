package com.unifacef.rentalapi.gateways.inputs.http.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import com.unifacef.rentalapi.domain.Carro;
import com.unifacef.rentalapi.domain.Endereco;

import java.io.Serializable;

@Data
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String nome;
    private String telefone;
    private String cnh;
    private Boolean ativo;
    private Endereco endereco;
    private Carro carro;
}
