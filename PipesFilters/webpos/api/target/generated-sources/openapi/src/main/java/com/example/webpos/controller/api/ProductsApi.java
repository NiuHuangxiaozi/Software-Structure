/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.webpos.controller.api;

import com.example.webpos.model.dto.ErrorDto;
import com.example.webpos.model.dto.ProductDto;
import com.example.webpos.model.dto.ReviewDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-21T19:42:45.140585600+08:00[Asia/Shanghai]", comments = "Generator version: 7.5.0")
@Validated
@Tag(name = "product", description = "the product API")
public interface ProductsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PATCH /products/{productId} : assign the  quantity of product
     *
     * @param productId The id of the product to retrieve (required)
     * @param body the reduce number of the product (required)
     * @return 商品数量修改成功 (status code 200)
     *         or 商品数量修改失败 (status code 400)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "assignNumberOfProduct",
        summary = "assign the  quantity of product",
        tags = { "product" },
        responses = {
            @ApiResponse(responseCode = "200", description = "商品数量修改成功"),
            @ApiResponse(responseCode = "400", description = "商品数量修改失败"),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/products/{productId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> assignNumberOfProduct(
        @Parameter(name = "productId", description = "The id of the product to retrieve", required = true, in = ParameterIn.PATH) @PathVariable("productId") String productId,
        @Parameter(name = "body", description = "the reduce number of the product", required = true) @Valid @RequestBody String body
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 5, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /products/{productId} : change the number of product
     *
     * @param productId The id of the product to product (required)
     * @param body the reduce number of the product (required)
     * @return 商品数量修改成功 (status code 200)
     *         or 商品数量修改失败 (status code 400)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "changeNumberofProduct",
        summary = "change the number of product",
        tags = { "product" },
        responses = {
            @ApiResponse(responseCode = "200", description = "商品数量修改成功"),
            @ApiResponse(responseCode = "400", description = "商品数量修改失败"),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/products/{productId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> changeNumberofProduct(
        @Parameter(name = "productId", description = "The id of the product to product", required = true, in = ParameterIn.PATH) @PathVariable("productId") String productId,
        @Parameter(name = "body", description = "the reduce number of the product", required = true) @Valid @RequestBody String body
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 5, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /products : List all products
     *
     * @return A paged array of products (status code 200)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "listProducts",
        summary = "List all products",
        tags = { "products" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A paged array of products", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))
            }),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/products",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<ProductDto>> listProducts(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"image\" : \"image\", \"features\" : \"features\", \"averagerating\" : \"\", \"quantity\" : 6, \"maincategory\" : \"maincategory\", \"price\" : \"\", \"name\" : \"name\", \"id\" : \"id\", \"store\" : \"store\", \"stock\" : 0, \"ratingnumber\" : 1 }, { \"image\" : \"image\", \"features\" : \"features\", \"averagerating\" : \"\", \"quantity\" : 6, \"maincategory\" : \"maincategory\", \"price\" : \"\", \"name\" : \"name\", \"id\" : \"id\", \"store\" : \"store\", \"stock\" : 0, \"ratingnumber\" : 1 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 5, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /products/reviews : List all reviews
     *
     * @return A paged array of reviews (status code 200)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "listReviews",
        summary = "List all reviews",
        tags = { "products" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A paged array of reviews", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ReviewDto.class)))
            }),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/products/reviews",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<ReviewDto>> listReviews(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"image\" : \"image\", \"parentasin\" : \"parentasin\", \"rating\" : \"\", \"asin\" : \"asin\", \"id\" : 0, \"text\" : \"text\", \"title\" : \"title\", \"userid\" : \"userid\" }, { \"image\" : \"image\", \"parentasin\" : \"parentasin\", \"rating\" : \"\", \"asin\" : \"asin\", \"id\" : 0, \"text\" : \"text\", \"title\" : \"title\", \"userid\" : \"userid\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 5, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /products/{productId} : Info for a specific product
     *
     * @param productId The id of the product to retrieve (required)
     * @return Expected response to a valid request (status code 200)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "showProductById",
        summary = "Info for a specific product",
        tags = { "product" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Expected response to a valid request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class))
            }),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/products/{productId}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<ProductDto> showProductById(
        @Parameter(name = "productId", description = "The id of the product to retrieve", required = true, in = ParameterIn.PATH) @PathVariable("productId") String productId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"image\" : \"image\", \"features\" : \"features\", \"averagerating\" : \"\", \"quantity\" : 6, \"maincategory\" : \"maincategory\", \"price\" : \"\", \"name\" : \"name\", \"id\" : \"id\", \"store\" : \"store\", \"stock\" : 0, \"ratingnumber\" : 1 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 5, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /products/reviews/{productId} : Info for specific views
     *
     * @param productId The id of the product to retrieve (required)
     * @return Expected response to a valid request (status code 200)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "showReviewsById",
        summary = "Info for specific views",
        tags = { "product" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Expected response to a valid request", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ReviewDto.class)))
            }),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/products/reviews/{productId}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<ReviewDto>> showReviewsById(
        @Parameter(name = "productId", description = "The id of the product to retrieve", required = true, in = ParameterIn.PATH) @PathVariable("productId") String productId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"image\" : \"image\", \"parentasin\" : \"parentasin\", \"rating\" : \"\", \"asin\" : \"asin\", \"id\" : 0, \"text\" : \"text\", \"title\" : \"title\", \"userid\" : \"userid\" }, { \"image\" : \"image\", \"parentasin\" : \"parentasin\", \"rating\" : \"\", \"asin\" : \"asin\", \"id\" : 0, \"text\" : \"text\", \"title\" : \"title\", \"userid\" : \"userid\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 5, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
