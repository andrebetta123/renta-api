package edu.unifacef.rentalapi.gateways.inputs.http;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.unifacef.rentalapi.domains.RentalCostumer;
import edu.unifacef.rentalapi.gateways.inputs.http.requests.UpdateCostumerRequest;
import edu.unifacef.rentalapi.gateways.inputs.http.responses.ListResponse;
import edu.unifacef.rentalapi.gateways.inputs.http.responses.RentalCostumerResponse;
import edu.unifacef.rentalapi.usecases.AddCostumer;
import edu.unifacef.rentalapi.usecases.FindByCostumerId;
import edu.unifacef.rentalapi.usecases.FindRentalCostumers;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/costumers/")
public class RentalCostumerController {

	private final AddCostumer addCostumer;
	private final FindByCostumerId findByCostumerId;
	private final FindRentalCostumers findRentalCostumers;

	@PostMapping(path = "/{id}")
	public void addCostumer(@PathVariable final String id, @RequestBody final UpdateCostumerRequest request) {
		addCostumer.execute(id, request.toDomain(id));
	}

	@GetMapping(path = "/{id}")
	public RentalCostumerResponse find(@PathVariable final String id) {
		RentalCostumer rentalCostumer = findByCostumerId.execute(id);
		return new RentalCostumerResponse(rentalCostumer);
	}

	@GetMapping
	public ListResponse<RentalCostumerResponse> findByPage(@RequestParam(defaultValue = "0") final Integer page,
			@RequestParam(defaultValue = "20") final Integer size) {
		Page<RentalCostumerResponse> carPage = findRentalCostumers.execute(PageRequest.of(page, size))
				.map(RentalCostumerResponse::new);
		return new ListResponse<>(carPage);
	}

}
