package com.example.webpos.mapper;

import com.example.webpos.model.Category;
import com.example.webpos.model.dto.CategoryDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-22T08:37:39+0800",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240325-1403, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        int id = 0;
        String name = null;

        if ( categoryDto.getId() != null ) {
            id = categoryDto.getId();
        }
        name = categoryDto.getName();

        Category category = new Category( id, name );

        return category;
    }

    @Override
    public CategoryDto toCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( category.getId() );
        categoryDto.setName( category.getName() );

        return categoryDto;
    }

    @Override
    public List<Category> toCategoryList(List<CategoryDto> categoryDtos) {
        if ( categoryDtos == null ) {
            return null;
        }

        List<Category> list = new ArrayList<Category>( categoryDtos.size() );
        for ( CategoryDto categoryDto : categoryDtos ) {
            list.add( toCategory( categoryDto ) );
        }

        return list;
    }

    @Override
    public List<CategoryDto> toCategoryDtoList(List<Category> category) {
        if ( category == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( category.size() );
        for ( Category category1 : category ) {
            list.add( toCategoryDto( category1 ) );
        }

        return list;
    }
}
