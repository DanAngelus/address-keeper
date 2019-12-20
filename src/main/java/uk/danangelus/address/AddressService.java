package uk.danangelus.address;

import uk.danangelus.address.model.Address;

import java.util.List;

/**
 * @author Dan Bennett (dbennett)
 * @since Fri, 20 December 2019
 */
public interface AddressService {

    List<Address> findAll();

    Address get(String id);

    boolean save(Address address);

    void delete(String id);
}
