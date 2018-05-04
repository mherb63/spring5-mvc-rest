package guru.springfamework.service;

import guru.springfamework.Exception.ResourceNotFoundException;
import guru.springfamework.domain.Category;
import guru.springfamework.dto.CategoryDTO;
import guru.springfamework.dto.CategoryListDTO;
import guru.springfamework.mapper.CategoryMapper;
import guru.springfamework.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryListDTO getAllCategories() {
        List<CategoryDTO> cdtoList =  categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());

        return new CategoryListDTO(cdtoList);
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        Category category = categoryRepository.findByName(name);
        if (category == null) {
            throw new ResourceNotFoundException("No category found with name: " + name);
        }
        return categoryMapper.categoryToCategoryDTO(category);
    }
}
