package com.example.webpos.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.webpos.model.Category;
import com.example.webpos.model.dto.CategoryDto;



@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryDto categoryDto);

    CategoryDto toCategoryDto(Category category);


    List<Category> toCategoryList(List<CategoryDto> categoryDtos);

    List<CategoryDto> toCategoryDtoList(List<Category> category);
    
}
