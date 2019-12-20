package uk.danangelus.address.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author Dan Bennett (dbennett)
 * @since Fri, 20 December 2019
 */
@Data
@Builder(access = AccessLevel.PUBLIC)
public class Address {

    @Id
    public String id;

    public String addressLine1;
    public String addressLine2;
    public String addressLine3;
    public String town;
    public String county;
    public String postcode;
    public String country;
}
