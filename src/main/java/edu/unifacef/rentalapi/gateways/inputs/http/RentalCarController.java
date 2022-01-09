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

import edu.unifacef.rentalapi.domains.RentalCar;
import edu.unifacef.rentalapi.gateways.inputs.http.requests.CarRequest;
import edu.unifacef.rentalapi.gateways.inputs.http.requests.PriceRequest;
import edu.unifacef.rentalapi.gateways.inputs.http.responses.ListResponse;
import edu.unifacef.rentalapi.gateways.inputs.http.responses.RentalCarResponse;
import edu.unifacef.rentalapi.usecases.AddCar;
import edu.unifacef.rentalapi.usecases.AddPrice;
import edu.unifacef.rentalapi.usecases.FindByCarBoard;
import edu.unifacef.rentalapi.usecases.FindRentalCars;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/cars/")
public class RentalCarController {

	private final AddCar addCar;
	private final AddPrice addPrice;
	private final FindByCarBoard findBycarBoard;
	private final FindRentalCars findRentalCars;

	@PostMapping(path = "/{carBoard}")
	public void addCar(@PathVariable final String carBoard, @RequestBody final CarRequest request) {
		addCar.execute(carBoard, request.toDomain());
	}

	@PostMapping(path = "/{carBoard}/prices")
	public void addPrice(@PathVariable final String carBoard, @RequestBody final PriceRequest request) {
		addPrice.execute(carBoard, request.toDomain());
	}

	@GetMapping(path = "/{carBoard}")
	public RentalCarResponse find(@PathVariable final String carBoard) {
		RentalCar rentalCar = findBycarBoard.execute(carBoard);
		return new RentalCarResponse(rentalCar);
	}

	@GetMapping
	public ListResponse<RentalCarResponse> findByPage(@RequestParam(defaultValue = "0") final Integer page,
			@RequestParam(defaultValue = "20") final Integer size) {
		Page<RentalCarResponse> carPage = findRentalCars.execute(PageRequest.of(page, size))
				.map(RentalCarResponse::new);
		return new ListResponse<>(carPage);
	}
}
