package guru.springfamework.service;

import guru.springfamework.dto.CustomerDTO;
import guru.springfamework.dto.CustomerListDTO;

public interface CustomerService {
    CustomerListDTO getAllCustomers();

    CustomerDTO getCustomerById(Long id);

    CustomerDTO createCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(CustomerDTO customerDTO, Long id);
}
