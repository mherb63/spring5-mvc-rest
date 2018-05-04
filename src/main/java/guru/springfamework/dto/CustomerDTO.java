package guru.springfamework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class CustomerDTO {
    @ApiModelProperty(value="required, first name of customer", required = true)
    private String firstname;

    @ApiModelProperty(value="not required, last name of customer", required = false)
    private String lastname;

    @JsonProperty("customer_url")
    private String customerUrl;
}
