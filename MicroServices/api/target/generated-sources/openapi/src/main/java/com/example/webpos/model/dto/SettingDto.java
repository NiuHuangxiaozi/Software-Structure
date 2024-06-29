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
 * SettingDto
 */

@JsonTypeName("Setting")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-09T20:48:43.408008400+08:00[Asia/Shanghai]", comments = "Generator version: 7.5.0")
public class SettingDto {

  private String symbol;

  private Boolean chargeTax;

  private Integer percentage;

  private String img;

  private String store;

  private String addressOne;

  private String addressTwo;

  private String contact;

  private String footer;

  public SettingDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SettingDto(String symbol) {
    this.symbol = symbol;
  }

  public SettingDto symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  /**
   * Get symbol
   * @return symbol
  */
  @NotNull 
  @Schema(name = "symbol", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("symbol")
  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public SettingDto chargeTax(Boolean chargeTax) {
    this.chargeTax = chargeTax;
    return this;
  }

  /**
   * Get chargeTax
   * @return chargeTax
  */
  
  @Schema(name = "charge_tax", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("charge_tax")
  public Boolean getChargeTax() {
    return chargeTax;
  }

  public void setChargeTax(Boolean chargeTax) {
    this.chargeTax = chargeTax;
  }

  public SettingDto percentage(Integer percentage) {
    this.percentage = percentage;
    return this;
  }

  /**
   * Get percentage
   * @return percentage
  */
  
  @Schema(name = "percentage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("percentage")
  public Integer getPercentage() {
    return percentage;
  }

  public void setPercentage(Integer percentage) {
    this.percentage = percentage;
  }

  public SettingDto img(String img) {
    this.img = img;
    return this;
  }

  /**
   * Get img
   * @return img
  */
  
  @Schema(name = "img", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("img")
  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public SettingDto store(String store) {
    this.store = store;
    return this;
  }

  /**
   * Get store
   * @return store
  */
  
  @Schema(name = "store", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("store")
  public String getStore() {
    return store;
  }

  public void setStore(String store) {
    this.store = store;
  }

  public SettingDto addressOne(String addressOne) {
    this.addressOne = addressOne;
    return this;
  }

  /**
   * Get addressOne
   * @return addressOne
  */
  
  @Schema(name = "address_one", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("address_one")
  public String getAddressOne() {
    return addressOne;
  }

  public void setAddressOne(String addressOne) {
    this.addressOne = addressOne;
  }

  public SettingDto addressTwo(String addressTwo) {
    this.addressTwo = addressTwo;
    return this;
  }

  /**
   * Get addressTwo
   * @return addressTwo
  */
  
  @Schema(name = "address_two", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("address_two")
  public String getAddressTwo() {
    return addressTwo;
  }

  public void setAddressTwo(String addressTwo) {
    this.addressTwo = addressTwo;
  }

  public SettingDto contact(String contact) {
    this.contact = contact;
    return this;
  }

  /**
   * Get contact
   * @return contact
  */
  
  @Schema(name = "contact", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("contact")
  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public SettingDto footer(String footer) {
    this.footer = footer;
    return this;
  }

  /**
   * Get footer
   * @return footer
  */
  
  @Schema(name = "footer", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("footer")
  public String getFooter() {
    return footer;
  }

  public void setFooter(String footer) {
    this.footer = footer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SettingDto setting = (SettingDto) o;
    return Objects.equals(this.symbol, setting.symbol) &&
        Objects.equals(this.chargeTax, setting.chargeTax) &&
        Objects.equals(this.percentage, setting.percentage) &&
        Objects.equals(this.img, setting.img) &&
        Objects.equals(this.store, setting.store) &&
        Objects.equals(this.addressOne, setting.addressOne) &&
        Objects.equals(this.addressTwo, setting.addressTwo) &&
        Objects.equals(this.contact, setting.contact) &&
        Objects.equals(this.footer, setting.footer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(symbol, chargeTax, percentage, img, store, addressOne, addressTwo, contact, footer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SettingDto {\n");
    sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
    sb.append("    chargeTax: ").append(toIndentedString(chargeTax)).append("\n");
    sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
    sb.append("    img: ").append(toIndentedString(img)).append("\n");
    sb.append("    store: ").append(toIndentedString(store)).append("\n");
    sb.append("    addressOne: ").append(toIndentedString(addressOne)).append("\n");
    sb.append("    addressTwo: ").append(toIndentedString(addressTwo)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
    sb.append("    footer: ").append(toIndentedString(footer)).append("\n");
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

