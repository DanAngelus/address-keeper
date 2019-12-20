package uk.danangelus.address.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uk.danangelus.address.model.Address;

import java.util.List;

/**
 * @author Dan Bennett (dbennett)
 * @since Fri, 20 December 2019
 */
@Repository
public interface AddressRepository extends MongoRepository<Address, String> {

    List<Address> findByUser(String userId);

    List<Address> findByStreetAddress(String query);

    List<Address> findByPostcode(String query);
}
