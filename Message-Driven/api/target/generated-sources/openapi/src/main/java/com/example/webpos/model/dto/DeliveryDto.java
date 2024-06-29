package com.example.webpos.model.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * DeliveryDto
 */

@JsonTypeName("delivery")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-18T09:49:54.432483700+08:00[Asia/Shanghai]", comments = "Generator version: 7.5.0")
public class DeliveryDto {

  private String deliveryId;

  private String orderId;

  private String logistics;

  private String describe;

  public DeliveryDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DeliveryDto(String deliveryId) {
    this.deliveryId = deliveryId;
  }

  public DeliveryDto deliveryId(String deliveryId) {
    this.deliveryId = deliveryId;
    return this;
  }

  /**
   * Get deliveryId
   * @return deliveryId
  */
  @NotNull 
  @Schema(name = "deliveryId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("deliveryId")
  public String getDeliveryId() {
    return deliveryId;
  }

  public void setDeliveryId(String deliveryId) {
    this.deliveryId = deliveryId;
  }

  public DeliveryDto orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Get orderId
   * @return orderId
  */
  
  @Schema(name = "orderId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("orderId")
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public DeliveryDto logistics(String logistics) {
    this.logistics = logistics;
    return this;
  }

  /**
   * Get logistics
   * @return logistics
  */
  
  @Schema(name = "logistics", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("logistics")
  public String getLogistics() {
    return logistics;
  }

  public void setLogistics(String logistics) {
    this.logistics = logistics;
  }

  public DeliveryDto describe(String describe) {
    this.describe = describe;
    return this;
  }

  /**
   * Get describe
   * @return describe
  */
  
  @Schema(name = "describe", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("describe")
  public String getDescribe() {
    return describe;
  }

  public void setDescribe(String describe) {
    this.describe = describe;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeliveryDto delivery = (DeliveryDto) o;
    return Objects.equals(this.deliveryId, delivery.deliveryId) &&
        Objects.equals(this.orderId, delivery.orderId) &&
        Objects.equals(this.logistics, delivery.logistics) &&
        Objects.equals(this.describe, delivery.describe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deliveryId, orderId, logistics, describe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeliveryDto {\n");
    sb.append("    deliveryId: ").append(toIndentedString(deliveryId)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    logistics: ").append(toIndentedString(logistics)).append("\n");
    sb.append("    describe: ").append(toIndentedString(describe)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

