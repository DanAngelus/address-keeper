package uk.danangelus.address;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.danangelus.address.model.Address;
import uk.danangelus.address.model.RestResponse;

import java.util.List;

/**
 * REST controller mapped to: /address
 *
 * @author Dan Bennett (dbennett)
 * @since Fri, 20 December 2019
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    private static final Logger LOG = LoggerFactory.getLogger(AddressController.class);

    @Autowired private AddressService addressService;

    @GetMapping
    public List<Address> getAllAddresses() {
        LOG.debug("[getAllAddresses] Returning all addresses for user...");
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable String id) {
        LOG.debug("[getAddress] Returning address matching ID {} for user...", id);
        return addressService.get(id);
    }

    @PostMapping("/save")
    public Boolean saveAddress(@RequestBody Address address) {
        LOG.debug("[saveAddress] Saving address for user: {}", address);
        return addressService.save(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable String id) {
        LOG.debug("[deleteAddress] Deleting address {}...", id);
        addressService.delete(id);
    }
}
