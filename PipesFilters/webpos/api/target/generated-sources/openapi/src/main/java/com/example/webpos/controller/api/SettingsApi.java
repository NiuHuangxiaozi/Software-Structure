/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.webpos.controller.api;

import com.example.webpos.model.dto.ErrorDto;
import com.example.webpos.model.dto.SettingDto;
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
@Tag(name = "Settings", description = "the Settings API")
public interface SettingsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /settings : Get settings of the shop
     * know about details of the shop
     *
     * @return expect details information of shop (status code 200)
     *         or unexpected error (status code 200)
     */
    @Operation(
        operationId = "getSettings",
        summary = "Get settings of the shop",
        description = "know about details of the shop",
        tags = { "Settings" },
        responses = {
            @ApiResponse(responseCode = "200", description = "expect details information of shop", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SettingDto.class)))
            }),
            @ApiResponse(responseCode = "default", description = "unexpected error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/settings",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<SettingDto>> getSettings(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"symbol\" : \"symbol\", \"img\" : \"img\", \"footer\" : \"footer\", \"address_one\" : \"address_one\", \"percentage\" : 0, \"contact\" : \"contact\", \"charge_tax\" : true, \"store\" : \"store\", \"address_two\" : \"address_two\" }, { \"symbol\" : \"symbol\", \"img\" : \"img\", \"footer\" : \"footer\", \"address_one\" : \"address_one\", \"percentage\" : 0, \"contact\" : \"contact\", \"charge_tax\" : true, \"store\" : \"store\", \"address_two\" : \"address_two\" } ]";
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