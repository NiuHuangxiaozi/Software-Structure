package com.example.webpos.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import com.example.webpos.model.Product;
import com.example.webpos.model.dto.ProductDto;





@Mapper(componentModel = "spring")
public interface ProductMapper{


    ProductDto toProductDto(Product product);

    Product toProduct(ProductDto productDto);

    List<ProductDto> toProductDtoList(List<Product> products);

    List<Product> toProductList(List<ProductDto> products);

}