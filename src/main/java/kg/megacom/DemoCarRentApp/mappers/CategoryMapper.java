package kg.megacom.DemoCarRentApp.mappers;

import kg.megacom.DemoCarRentApp.model.Category;
import kg.megacom.DemoCarRentApp.model.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto toCategoryDto(Category category);

    Category toCategory(CategoryDto categoryDto);

    List<CategoryDto> toCategoryDtoList(List<Category> categoryList);

    List<Category> toCategoryList(List<CategoryDto> categoryDtoList);
}
