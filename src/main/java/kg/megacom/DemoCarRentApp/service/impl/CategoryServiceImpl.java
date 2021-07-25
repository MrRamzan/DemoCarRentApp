package kg.megacom.DemoCarRentApp.service.impl;

import kg.megacom.DemoCarRentApp.dao.CategoryRepository;
import kg.megacom.DemoCarRentApp.exceptions.GeneralException;
import kg.megacom.DemoCarRentApp.mappers.CategoryMapper;
import kg.megacom.DemoCarRentApp.model.Category;
import kg.megacom.DemoCarRentApp.model.dto.CategoryDto;
import kg.megacom.DemoCarRentApp.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> findAllCateg() {
        List<Category> categoryList = categoryRepository.findAll();
        return CategoryMapper.INSTANCE.toCategoryDtoList(categoryList);
    }

    @Override
    public CategoryDto findById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            return CategoryMapper.INSTANCE.toCategoryDto(category);
        }
        throw new GeneralException(" Category not found");
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        Category category = CategoryMapper.INSTANCE.toCategory(categoryDto);
        category = categoryRepository.save(category);
        return CategoryMapper.INSTANCE.toCategoryDto(category);
    }

    @Override
    public int delete(Long id) {
        if (categoryRepository.existsById(id)) {
            Category category = categoryRepository.getById(id);
            categoryRepository.delete(category);
            return 1;
        }
        return 0;
    }

    @Override
    public CategoryDto update(Long id, CategoryDto categoryDto) {
        if (categoryRepository.existsById(id)) {
            Category category = categoryRepository.getById(id);
            category.setCategory(categoryDto.getCategory());
            category = categoryRepository.save(category);
            return CategoryMapper.INSTANCE.toCategoryDto(category);
        }
        throw new GeneralException("The category has not been updated");
    }
}
