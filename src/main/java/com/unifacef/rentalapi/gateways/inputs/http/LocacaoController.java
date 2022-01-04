package com.unifacef.rentalapi.gateways.inputs.http;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unifacef.rentalapi.domain.Locacao;
import com.unifacef.rentalapi.gateways.inputs.http.requests.CreateLocacaoResquest;
import com.unifacef.rentalapi.gateways.inputs.http.requests.UpdateLocacaoResquest;
import com.unifacef.rentalapi.gateways.inputs.http.response.ListResponse;
import com.unifacef.rentalapi.gateways.inputs.http.response.LocacaoResponse;
import com.unifacef.rentalapi.usecases.CreateLocacao;
import com.unifacef.rentalapi.usecases.FindLocacoes;
import com.unifacef.rentalapi.usecases.UpdateLocacao;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/aluguel-api/locacoes")
public class LocacaoController {

	private final FindLocacoes findLocacoes;
	private final CreateLocacao createLocacao;
	private final UpdateLocacao updateLocacao;


	@GetMapping
	public ListResponse<LocacaoResponse> findByPage(@RequestParam(defaultValue = "0") final Integer page,
			@RequestParam(defaultValue = "20") final Integer size) {
		Page<LocacaoResponse> locacaoPage = findLocacoes.execute(PageRequest.of(page, size)).map(LocacaoResponse::new);
		return new ListResponse<>(locacaoPage);
	}

	@PostMapping
	public LocacaoResponse create(@RequestBody @Validated final CreateLocacaoResquest request) {
		Locacao locacao = createLocacao.execute(request.toDomain());
		return new LocacaoResponse(locacao);
	}

	@PutMapping(path = "/{code}")
	public LocacaoResponse update(@PathVariable final Long code,
            @RequestBody @Validated final UpdateLocacaoResquest request) {
		Locacao locacao = updateLocacao.execute(request.toDomain(code));
		return new LocacaoResponse(locacao);
	}
}
