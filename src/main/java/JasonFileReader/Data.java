package JasonFileReader;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Data {

    @JsonProperty("firstname")
    String firstname;

    @JsonProperty("lastname")
    String lastname;

    @JsonProperty("dob")
    String DOB;

    @JsonProperty("email")
    String email;

    @JsonProperty("address")
    String address;

    @JsonProperty("cc")
    CC cc;

    @JsonProperty("product")
    Product product;

    static class CC {
        @JsonProperty("number")
        String number;

        @JsonProperty("billing")
        String billingAddress;
    }

    static class Product {
        @JsonProperty("searchCriteria")
        String criteria;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getBillingAddress() {
        return cc.billingAddress;
    }

    public static Data get(String filename) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), Data.class);
    }

}
