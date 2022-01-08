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

import edu.unifacef.rentalapi.domains.Rental;
import edu.unifacef.rentalapi.gateways.inputs.http.requests.CreateCostumerRequest;
import edu.unifacef.rentalapi.gateways.inputs.http.requests.PriceRequest;
import edu.unifacef.rentalapi.gateways.inputs.http.responses.CreateRentalRequest;
import edu.unifacef.rentalapi.gateways.inputs.http.responses.ListResponse;
import edu.unifacef.rentalapi.gateways.inputs.http.responses.RentalCarResponse;
import edu.unifacef.rentalapi.usecases.AddCar;
import edu.unifacef.rentalapi.usecases.AddCostumer;
import edu.unifacef.rentalapi.usecases.AddPrice;
import edu.unifacef.rentalapi.usecases.AddRental;
import edu.unifacef.rentalapi.usecases.FindByCarBoard;
import edu.unifacef.rentalapi.usecases.FindRentalCars;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/rentals/")
public class RentalController {

  private final AddRental addRental;
//  private final AddCar addCar;
  private final AddPrice addPrice;
  private final AddCostumer addCostumer;
  private final FindByCarBoard findBycarBoard;
  private final FindRentalCars findRentalCars;

  @PostMapping(path = "/{id}")
  public void addRental(@PathVariable final String id,
                         @RequestBody final CreateRentalRequest rental) {
    addRental.execute(id, rental.toDomain());
  }
//
//  @PostMapping
//  public CostumerResponse create(@RequestBody @Validated final CreateCostumerRequest request) {
//      Costumer costumer = createClient.execute(request.toDomain());
//      return new CostumerResponse(costumer);
//  }
//
//  @PutMapping(path = "/{id}")
//  public CostumerResponse update(@PathVariable final String id,
//                                 @RequestBody @Validated final UpdateCostumerRequest request) {
//      Costumer costumer = updateCostumer.execute(request.toDomain(id));
//      return new CostumerResponse(costumer);
//  }
//
//  @GetMapping(path = "/{id}")
//  public CostumerResponse find(@PathVariable final String id) {
//      Costumer costumer = findByCostumerId.execute(id);
//      return new CostumerResponse(costumer);
//  }

  
//  @PostMapping(path = "/{carBoard}")
//  public void addCar(@PathVariable final String carBoard,
//                         @RequestBody final CarRequest request) {
//    addCar.execute(carBoard, request.toDomain());
//  }

  @PostMapping(path = "/{carBoard}/prices")
  public void addPrice(@PathVariable final String carBoard,
                       @RequestBody final PriceRequest request) {
    addPrice.execute(carBoard, request.toDomain());
  }

  @PostMapping(path = "/{carBoard}/costumers")
  public void addCarCostumer( @PathVariable final String carBoard,
                           @RequestBody final CreateCostumerRequest request) {
    addCostumer.execute(carBoard, request.toDomain());
  }

//  @PostMapping(path = "/costumers/{id}")
//  public void addCostumer(@PathVariable final String id, @RequestBody final CostumerRequest request) {
//	System.out.println(id);
//    addCostumer.execute(request.toDomain());
//  }

  @GetMapping(path = "/{carBoard}")
  public RentalCarResponse find(@PathVariable final String carBoard) {
    Rental rental = findBycarBoard.execute(carBoard);
    return new RentalCarResponse(rental);
  }

  @GetMapping
  public ListResponse<RentalCarResponse> findByPage(@RequestParam(defaultValue = "0") final Integer page,
                                                  @RequestParam(defaultValue = "20") final Integer size) {
    Page<RentalCarResponse> carPage =
        findRentalCars.execute(PageRequest.of(page, size)).map(RentalCarResponse::new);
    return new ListResponse<>(carPage);
  }
}
