package kg.megacom.DemoCarRentApp.service;

import kg.megacom.DemoCarRentApp.model.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAllCateg();

    CategoryDto findById(Long id);

    CategoryDto save(CategoryDto categoryDto);

    int delete(Long id);

    CategoryDto update(Long id, CategoryDto categoryDto);
}
