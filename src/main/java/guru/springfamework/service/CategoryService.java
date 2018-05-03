package guru.springfamework.service;

import guru.springfamework.dto.CategoryDTO;
import guru.springfamework.dto.CategoryListDTO;

public interface CategoryService {

    CategoryListDTO getAllCategories();

    CategoryDTO getCategoryByName(String name);
}
