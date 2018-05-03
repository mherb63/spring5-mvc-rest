package guru.springfamework.service;

import guru.springfamework.dto.CustomerDTO;
import guru.springfamework.dto.CustomerListDTO;
import guru.springfamework.mapper.CustomerMapper;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerListDTO getAllCustomers() {
        List<CustomerDTO> cdtoList =  customerRepository.findAll()
                .stream()
                .map(customer -> {
                  CustomerDTO customerDTO =  customerMapper.customerToCustomerDTO(customer);
                    customerDTO.setCustomer_url("/customer/" + customer.getId());
                  return customerDTO;
                })
                .collect(Collectors.toList());

        return new CustomerListDTO(cdtoList);
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                    customerDTO.setCustomer_url("/customer/" + customer.getId());
                    return customerDTO;
                })
                .orElseThrow(() -> new RuntimeException("No customer found with id: " + id));
    }
}
