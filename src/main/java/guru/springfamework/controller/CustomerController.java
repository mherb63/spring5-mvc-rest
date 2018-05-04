package guru.springfamework.controller;

import guru.springfamework.dto.CustomerDTO;
import guru.springfamework.dto.CustomerListDTO;
import guru.springfamework.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "Perform CRUD Operations on Customer resource")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "Get a list of all Customer resources")
    @GetMapping("/customer")
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDTO getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @ApiOperation(value = "Get a single Customer resource", notes = "Provide the id of the Customer resource to retrieve")
    @GetMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @ApiOperation(value = "Create a new Customer resource")
    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createCustomer(customerDTO);
    }

    @ApiOperation(value = "Update/PUT a Customer resource")
    @PutMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable Long id) {
        return customerService.createCustomer(customerDTO);
    }

    @ApiOperation(value = "Update/PATCH a Customer resource")
    @PatchMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO patchCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable Long id) {
        return customerService.patchCustomer(customerDTO, id);
    }

    @ApiOperation(value = "Delete a Customer resource")
    @DeleteMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }

}
