package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public Bootstrap(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

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

        log.info("Categories loaded, count: " + categoryRepository.count());


    }
}
