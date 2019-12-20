package uk.danangelus.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.danangelus.address.model.Address;
import uk.danangelus.address.repository.AddressRepository;

import java.util.List;

/**
 * @author Dan Bennett (dbennett)
 * @since Fri, 20 December 2019
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired private AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        // ToDo: Extract user details
        return null;
    }

    @Override
    public Address get(String id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(Address address) {
        // ToDo :: Check if address should be attached to a session first
        addressRepository.save(address);
        return true;
    }

    @Override
    public void delete(String id) {
        var address = get(id);
        if (address != null) {
            addressRepository.delete(address);
        }
    }
}
