package edu.unifacef.rentalapi.gateways.inputs.http;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unifacef.rentalapi.domains.RentalCostumer;
import edu.unifacef.rentalapi.gateways.inputs.http.requests.UpdateCostumerRequest;
import edu.unifacef.rentalapi.gateways.inputs.http.responses.RentalCostumerResponse;
import edu.unifacef.rentalapi.usecases.AddCostumer;
import edu.unifacef.rentalapi.usecases.FindByCostumerId;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/costumers/")
public class RentalCostumerController {

  private final AddCostumer addCostumer;
  private final FindByCostumerId findByCostumerId;
//  private final FindRentalCars findRentalCars;

//  @PostMapping(path = "/{carBoard}")
//  public void addCar(@PathVariable final String carBoard,
//                         @RequestBody final CarRequest request) {
//    addCar.execute(carBoard, request.toDomain());
//  }
//
//  @PostMapping(path = "/{carBoard}/prices")
//  public void addPrice(@PathVariable final String carBoard,
//                       @RequestBody final PriceRequest request) {
//    addPrice.execute(carBoard, request.toDomain());
//  }

//  @PostMapping(path = "/{id}")
//  public void addCarCostumer( @PathVariable final String id,
//                           @RequestBody final CreateCostumerRequest request) {
//    addCostumer.execute(id, request.toDomain());
//  }
  
  @PostMapping(path = "/{id}")
  public void addCarCostumer( @PathVariable final String id,
                           @RequestBody final UpdateCostumerRequest request) {
    addCostumer.execute(id, request.toDomain(id));
  }

//  @PostMapping(path = "/costumers/{id}")
//  public void addCostumer(@PathVariable final String id, @RequestBody final CostumerRequest request) {
//	System.out.println(id);
//    addCostumer.execute(request.toDomain());
//  }

  @GetMapping(path = "/{id}")
  public RentalCostumerResponse find(@PathVariable final String id) {
    RentalCostumer rentalCostumer = findByCostumerId.execute(id);
    return new RentalCostumerResponse(rentalCostumer);
  }

//  @GetMapping
//  public ListResponse<RentalCarResponse> findByPage(@RequestParam(defaultValue = "0") final Integer page,
//                                                  @RequestParam(defaultValue = "20") final Integer size) {
//    Page<RentalCarResponse> carPage =
//        findRentalCars.execute(PageRequest.of(page, size)).map(RentalCarResponse::new);
//    return new ListResponse<>(carPage);
//  }
}
