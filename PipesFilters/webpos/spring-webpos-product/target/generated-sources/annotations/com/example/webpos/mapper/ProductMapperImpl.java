package com.example.webpos.mapper;

import com.example.webpos.model.Product;
import com.example.webpos.model.dto.ProductDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-21T19:50:44+0800",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setAveragerating( product.getAveragerating() );
        productDto.setFeatures( product.getFeatures() );
        productDto.setId( product.getId() );
        productDto.setImage( product.getImage() );
        productDto.setMaincategory( product.getMaincategory() );
        productDto.setName( product.getName() );
        productDto.setPrice( product.getPrice() );
        productDto.setQuantity( product.getQuantity() );
        productDto.setRatingnumber( product.getRatingnumber() );
        productDto.stock( product.getStock() );
        productDto.store( product.getStore() );

        return productDto;
    }

    @Override
    public Product toProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setAveragerating( productDto.getAveragerating() );
        product.setFeatures( productDto.getFeatures() );
        product.setId( productDto.getId() );
        product.setImage( productDto.getImage() );
        product.setMaincategory( productDto.getMaincategory() );
        product.setName( productDto.getName() );
        if ( productDto.getPrice() != null ) {
            product.setPrice( productDto.getPrice() );
        }
        if ( productDto.getQuantity() != null ) {
            product.setQuantity( productDto.getQuantity() );
        }
        if ( productDto.getRatingnumber() != null ) {
            product.setRatingnumber( productDto.getRatingnumber() );
        }
        if ( productDto.getStock() != null ) {
            product.setStock( productDto.getStock() );
        }
        product.setStore( productDto.getStore() );

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
