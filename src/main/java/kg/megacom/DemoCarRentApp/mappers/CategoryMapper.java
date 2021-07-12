package kg.megacom.DemoCarRentApp.mappers;

import kg.megacom.DemoCarRentApp.model.Category;
import kg.megacom.DemoCarRentApp.model.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toCategoryDto(Category category);

    CategoryDto toCategory(CategoryDto categoryDto);

    List<Category> toCategoryDtoList(List<Category> categoryList);

    List<CategoryDto> toCategoryList(List<CategoryDto> categoryDtoList);
}
