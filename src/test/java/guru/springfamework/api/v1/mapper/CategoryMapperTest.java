package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryMapperTest {
    public static final String CATEGORY_NAME = "Mike";
    public static final long CATEGORY_ID = 1;

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() {

        //given
        Category category = new Category();
        category.setName(CATEGORY_NAME);
        category.setId(CATEGORY_ID);

        //when
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
        assertEquals(Long.valueOf(CATEGORY_ID), categoryDTO.getId());
        assertEquals(CATEGORY_NAME, categoryDTO.getName());
    }
}