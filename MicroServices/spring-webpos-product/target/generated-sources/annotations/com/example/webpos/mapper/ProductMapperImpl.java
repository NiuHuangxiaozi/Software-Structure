package com.example.webpos.mapper;

import com.example.webpos.model.Product;
import com.example.webpos.model.dto.ProductDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-10T19:18:52+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.10 (Microsoft)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setPrice( product.getPrice() );
        productDto.setImage( product.getImage() );
        productDto.setStock( product.getStock() );
        productDto.setQuantity( product.getQuantity() );

        return productDto;
    }

    @Override
    public Product toProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDto.getId() );
        product.setName( productDto.getName() );
        if ( productDto.getPrice() != null ) {
            product.setPrice( productDto.getPrice() );
        }
        product.setImage( productDto.getImage() );
        if ( productDto.getStock() != null ) {
            product.setStock( productDto.getStock() );
        }
        if ( productDto.getQuantity() != null ) {
            product.setQuantity( productDto.getQuantity() );
        }

        return product;
    }

    @Override
    public List<ProductDto> toProductDtoList(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( products.size() );
        for ( Product product : products ) {
            list.add( toProductDto( product ) );
        }

        return list;
    }

    @Override
    public List<Product> toProductList(List<ProductDto> products) {
        if ( products == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( products.size() );
        for ( ProductDto productDto : products ) {
            list.add( toProduct( productDto ) );
        }

        return list;
    }
}
