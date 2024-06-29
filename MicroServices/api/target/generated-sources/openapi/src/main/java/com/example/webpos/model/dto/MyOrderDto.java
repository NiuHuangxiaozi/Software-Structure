package com.example.webpos.model.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * MyOrderDto
 */

@JsonTypeName("myOrder")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-09T20:48:43.408008400+08:00[Asia/Shanghai]", comments = "Generator version: 7.5.0")
public class MyOrderDto {

  private String orderId;

  private Double pay = null;

  @Valid
  private List<Integer> goods = new ArrayList<>();

  private String describe;

  private String state;

  public MyOrderDto orderId(String orderId) {
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

  public MyOrderDto pay(Double pay) {
    this.pay = pay;
    return this;
  }

  /**
   * Get pay
   * @return pay
  */
  
  @Schema(name = "pay", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pay")
  public Double getPay() {
    return pay;
  }

  public void setPay(Double pay) {
    this.pay = pay;
  }

  public MyOrderDto goods(List<Integer> goods) {
    this.goods = goods;
    return this;
  }

  public MyOrderDto addGoodsItem(Integer goodsItem) {
    if (this.goods == null) {
      this.goods = new ArrayList<>();
    }
    this.goods.add(goodsItem);
    return this;
  }

  /**
   * Get goods
   * @return goods
  */
  
  @Schema(name = "goods", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("goods")
  public List<Integer> getGoods() {
    return goods;
  }

  public void setGoods(List<Integer> goods) {
    this.goods = goods;
  }

  public MyOrderDto describe(String describe) {
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

  public MyOrderDto state(String state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  */
  
  @Schema(name = "state", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("state")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MyOrderDto myOrder = (MyOrderDto) o;
    return Objects.equals(this.orderId, myOrder.orderId) &&
        Objects.equals(this.pay, myOrder.pay) &&
        Objects.equals(this.goods, myOrder.goods) &&
        Objects.equals(this.describe, myOrder.describe) &&
        Objects.equals(this.state, myOrder.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, pay, goods, describe, state);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MyOrderDto {\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    pay: ").append(toIndentedString(pay)).append("\n");
    sb.append("    goods: ").append(toIndentedString(goods)).append("\n");
    sb.append("    describe: ").append(toIndentedString(describe)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
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

