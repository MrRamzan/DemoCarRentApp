package kg.megacom.DemoCarRentApp.controller;

import kg.megacom.DemoCarRentApp.model.dto.CategoryDto;
import kg.megacom.DemoCarRentApp.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAll")
    public List<CategoryDto> findAllCategory() {
        return categoryService.findAllCateg();
    }

    @GetMapping("/getById/{id}")
    public CategoryDto findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping("/save")
    public CategoryDto saveNewCateg(@RequestBody CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteCateg(@PathVariable Long id) {
        return categoryService.delete(id);
    }

    @PutMapping("/update/{id}")
    public CategoryDto updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto){
        return categoryService.update(id, categoryDto);
    }

}
