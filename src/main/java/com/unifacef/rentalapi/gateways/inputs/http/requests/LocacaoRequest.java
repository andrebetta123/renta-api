package com.unifacef.rentalapi.gateways.inputs.http.requests;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.unifacef.rentalapi.domain.Carro;
import com.unifacef.rentalapi.domain.Cliente;
import com.unifacef.rentalapi.domain.Kilometros;
import com.unifacef.rentalapi.domain.Preco;
import com.unifacef.rentalapi.domain.StatusTanque;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public abstract class LocacaoRequest implements Serializable {	
	
	private static final long serialVersionUID = 1L;	
	
    @ApiModelProperty(position = 1)
//    @NotNull(message = "{required.field}")
	private Long id;
    
    @ApiModelProperty(position = 2, dataType = "java.util.Date")
//    @NotNull(message = "{required.field}")
	private LocalDateTime dataEntrega;
	
    @ApiModelProperty(position = 3, dataType = "java.util.Date")
//	@NotNull(message = "{required.field}")
	private LocalDateTime dataLocacao;
	
    @ApiModelProperty(position = 4)
    private Carro carro;	
	
    @ApiModelProperty(position = 5)
    private Cliente cliente;
	
    @ApiModelProperty(position = 6)
    private Preco preco;
	
    @ApiModelProperty(position = 7)
    private Kilometros kilometros;
	
    @ApiModelProperty(position = 8)
    private StatusTanque statusTanque;
	
    @ApiModelProperty(position = 9)
    private Boolean ativo;	
	
    @ApiModelProperty(position = 10)
//    , dataType = "java.util.Date")
	private LocalDateTime dataInclusao;
	
    @ApiModelProperty(position = 11)
//    , dataType = "java.util.Date")
	private LocalDateTime dataModificacao;

}
