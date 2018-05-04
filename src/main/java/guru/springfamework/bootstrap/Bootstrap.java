package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import guru.springfamework.repositories.VendorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
        loadVendors();
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");
        categoryRepository.save(fruits);

        Category dried = new Category();
        dried.setName("Dried");
        categoryRepository.save(dried);

        Category fresh = new Category();
        fresh.setName("Fresh");
        categoryRepository.save(fresh);

        Category exotic = new Category();
        exotic.setName("Exotic");
        categoryRepository.save(exotic);

        Category nuts = new Category();
        nuts.setName("Nuts");
        categoryRepository.save(nuts);
    }

    private void loadCustomers() {
        customerRepository.save(new Customer(1L, "Joe", "Newman"));
        customerRepository.save(new Customer(2L, "Michael", "Lachappele"));
        customerRepository.save(new Customer(3L, "David", "Winter"));
        customerRepository.save(new Customer(4L, "Anne", "Hine"));
    }

    private void loadVendors() {
        vendorRepository.save(new Vendor(1L,"Western Tasty Fruits Ltd."));
        vendorRepository.save(new Vendor(2L,"Exotic Fruits Company"));
        vendorRepository.save(new Vendor(3L,"Home Fruits"));
        vendorRepository.save(new Vendor(4L,"Fun Fresh Fruits Ltd."));
        vendorRepository.save(new Vendor(5L,"Nuts for Nuts Company"));
    }
}
