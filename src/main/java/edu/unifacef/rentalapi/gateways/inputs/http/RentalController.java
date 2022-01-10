package edu.unifacef.rentalapi.gateways.inputs.http;

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

import edu.unifacef.rentalapi.domains.Rental;
import edu.unifacef.rentalapi.gateways.inputs.http.requests.CreateRentalRequest;
import edu.unifacef.rentalapi.gateways.inputs.http.requests.UpdateRentalRequest;
import edu.unifacef.rentalapi.gateways.inputs.http.responses.ListResponse;
import edu.unifacef.rentalapi.gateways.inputs.http.responses.RentalResponse;
import edu.unifacef.rentalapi.usecases.CreateRental;
import edu.unifacef.rentalapi.usecases.FindByRentalId;
import edu.unifacef.rentalapi.usecases.FindRentals;
import edu.unifacef.rentalapi.usecases.UpdateRental;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/rentals/")
public class RentalController {

	private final CreateRental addRental;
	private final UpdateRental updateRental;
//  private final FindRentalByCarBoard findBycarBoard;
//  private final FindByCostumerId findByCostumerId;
	private final FindByRentalId findByRentalId;
	private final FindRentals findRentals;

	@PostMapping(path = "/")
	public void addRental(@RequestBody final CreateRentalRequest rental) {
		System.out.println(rental.toDomain().getId());
		addRental.execute(rental.toDomain());
	}

	@PutMapping(path = "/{rentalId}")
	public RentalResponse update(@PathVariable final String rentalId,
			@RequestBody @Validated final UpdateRentalRequest request) {
		Rental rental = updateRental.execute(rentalId, request.toDomain(rentalId));
		return new RentalResponse(rental);
	}

	@GetMapping(path = "/{rentalId}")
	public RentalResponse findById(@PathVariable final String rentalId) {
		Rental rental = findByRentalId.execute(rentalId);
		return new RentalResponse(rental);
	}

//  @GetMapping(path = "/{carBoard}")
//  public RentalResponse findByCarBoard(@PathVariable final String carBoard) {
//    Rental rental = findBycarBoard.execute(carBoard);
//    return new RentalCarResponse(rentalCar);
//  }
//
//  @GetMapping(path = "/{costumerId}")
//  public RentalCostumerResponse findByCostumer(@PathVariable final String costumerId) {
//    RentalCostumer rentalCostumer = findByCostumerId.execute(costumerId);
//    return new RentalCostumerResponse(rentalCostumer);
//  }

	@GetMapping
	public ListResponse<RentalResponse> findByPage(@RequestParam(defaultValue = "0") final Integer page,
			@RequestParam(defaultValue = "20") final Integer size) {
		Page<RentalResponse> carPage = findRentals.execute(PageRequest.of(page, size)).map(RentalResponse::new);
		return new ListResponse<>(carPage);
	}
}
