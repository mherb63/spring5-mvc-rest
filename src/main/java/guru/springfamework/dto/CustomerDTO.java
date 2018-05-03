package guru.springfamework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomerDTO {
    String firstname;
    String lastname;

    @JsonProperty("customer_url")
    String customerUrl;
}
