package edu.unifacef.rentalapi.usecases;

import static edu.unifacef.rentalapi.exceptions.MessageKey.RENTAL_ALREADY_EXISTS;

import org.springframework.stereotype.Component;

import edu.unifacef.rentalapi.domains.Rental;
import edu.unifacef.rentalapi.gateways.outputs.RentalDataGateway;
import edu.unifacef.rentalapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateRental {

    private final RentalDataGateway rentalDataGateway;
    private final MessageUtils messageUtils;
    
    public Rental execute(final Rental rental){
        log.info("Create rental. Rental id: {}",rental.getId());
        if(rentalDataGateway.findById(rental.getId()).isPresent()){
            throw new IllegalArgumentException(
                    messageUtils.getMessage(RENTAL_ALREADY_EXISTS, rental.getId()));
        }

        Rental saved = rentalDataGateway.save(rental);
        return saved;
    }
}
