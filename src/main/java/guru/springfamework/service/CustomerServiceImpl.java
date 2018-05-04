package guru.springfamework.service;

import guru.springfamework.domain.Customer;
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
                .map(customer -> {return getCustomerDTO(customer);})
                .collect(Collectors.toList());

        return new CustomerListDTO(cdtoList);
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customer -> {return getCustomerDTO(customer);})
                .orElseThrow(() -> new RuntimeException("No customer found with id: " + id));
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer c = customerRepository.save(customerMapper.customerDTOToCustomer(customerDTO));
        return getCustomerDTO(c);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO, Long id) {
        Customer c = customerRepository.findById(id).get();
        c.setFirstname(customerDTO.getFirstname());
        c.setLastname(customerDTO.getLastname());
        return getCustomerDTO(customerRepository.save(c));
    }

    @Override
    public CustomerDTO patchCustomer(CustomerDTO customerDTO, Long id) {
        return customerRepository.findById(id).map(customer -> {
                if (customerDTO.getFirstname() != null) {
                    customer.setFirstname(customerDTO.getFirstname());
                }
                if (customerDTO.getLastname() != null) {
                    customer.setLastname(customerDTO.getLastname());
                }
                return getCustomerDTO(customer);
                }).orElseThrow(() -> new RuntimeException("No customer found with id: " + id));
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    private CustomerDTO getCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
        customerDTO.setCustomerUrl("/customer/" + customer.getId());
        return customerDTO;
    }
}
