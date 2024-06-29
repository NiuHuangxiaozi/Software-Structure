/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.webpos.controller.api;

import com.example.webpos.model.dto.ErrorDto;
import com.example.webpos.model.dto.MyOrderDto;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-18T09:49:54.432483700+08:00[Asia/Shanghai]", comments = "Generator version: 7.5.0")
@Validated
@Tag(name = "orders", description = "the orders API")
public interface OrdersApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /orders/{orderId} : add a new order tinto orders
     *
     * @param orderId The id of the order (required)
     * @param body the new order (required)
     * @return 订单添加成功 (status code 200)
     *         or 订单添加失败 (status code 400)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "addOrder",
        summary = "add a new order tinto orders",
        tags = { "orders" },
        responses = {
            @ApiResponse(responseCode = "200", description = "订单添加成功"),
            @ApiResponse(responseCode = "400", description = "订单添加失败"),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/orders/{orderId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> addOrder(
        @Parameter(name = "orderId", description = "The id of the order", required = true, in = ParameterIn.PATH) @PathVariable("orderId") String orderId,
        @Parameter(name = "body", description = "the new order", required = true) @Valid @RequestBody String body
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 1, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /orders/{orderId} : change the state of order
     *
     * @param orderId The id of the order (required)
     * @param body the new state of order (required)
     * @return 订单状态修改成功 (status code 200)
     *         or 订单状态修改失败 (status code 400)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "changeStateOfOrder",
        summary = "change the state of order",
        tags = { "orders" },
        responses = {
            @ApiResponse(responseCode = "200", description = "订单状态修改成功"),
            @ApiResponse(responseCode = "400", description = "订单状态修改失败"),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/orders/{orderId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Void> changeStateOfOrder(
        @Parameter(name = "orderId", description = "The id of the order", required = true, in = ParameterIn.PATH) @PathVariable("orderId") String orderId,
        @Parameter(name = "body", description = "the new state of order", required = true) @Valid @RequestBody String body
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 1, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /orders : List all orders
     *
     * @return A paged array of orders (status code 200)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "listOrders",
        summary = "List all orders",
        tags = { "orders" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A paged array of orders", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MyOrderDto.class)))
            }),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/orders",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<MyOrderDto>> listOrders(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"orderId\" : \"orderId\", \"pay\" : \"\", \"goods\" : [ 0, 0 ], \"describe\" : \"describe\", \"state\" : \"state\" }, { \"orderId\" : \"orderId\", \"pay\" : \"\", \"goods\" : [ 0, 0 ], \"describe\" : \"describe\", \"state\" : \"state\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 1, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /orders/{orderId} : remove an ordeer from the orders
     *
     * @param orderId The id of the order (required)
     * @return 订单删除成功 (status code 200)
     *         or 订单删除失败 (status code 400)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "remomoveOrder",
        summary = "remove an ordeer from the orders",
        tags = { "orders" },
        responses = {
            @ApiResponse(responseCode = "200", description = "订单删除成功"),
            @ApiResponse(responseCode = "400", description = "订单删除失败"),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/orders/{orderId}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Void> remomoveOrder(
        @Parameter(name = "orderId", description = "The id of the order", required = true, in = ParameterIn.PATH) @PathVariable("orderId") String orderId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 1, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}