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
 * ProductDto
 */

@JsonTypeName("Product")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-21T19:42:45.140585600+08:00[Asia/Shanghai]", comments = "Generator version: 7.5.0")
public class ProductDto {

  private String id;

  private String name;

  private Double price = null;

  private String image;

  private Integer stock;

  private Integer quantity;

  private String maincategory;

  private Double averagerating = null;

  private Integer ratingnumber;

  private String features;

  private String store;

  public ProductDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ProductDto(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public ProductDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductDto price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  
  @Schema(name = "price", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public ProductDto image(String image) {
    this.image = image;
    return this;
  }

  /**
   * Get image
   * @return image
  */
  
  @Schema(name = "image", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("image")
  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public ProductDto stock(Integer stock) {
    this.stock = stock;
    return this;
  }

  /**
   * Get stock
   * @return stock
  */
  
  @Schema(name = "stock", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("stock")
  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public ProductDto quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  */
  
  @Schema(name = "quantity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public ProductDto maincategory(String maincategory) {
    this.maincategory = maincategory;
    return this;
  }

  /**
   * Get maincategory
   * @return maincategory
  */
  
  @Schema(name = "maincategory", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maincategory")
  public String getMaincategory() {
    return maincategory;
  }

  public void setMaincategory(String maincategory) {
    this.maincategory = maincategory;
  }

  public ProductDto averagerating(Double averagerating) {
    this.averagerating = averagerating;
    return this;
  }

  /**
   * Get averagerating
   * @return averagerating
  */
  
  @Schema(name = "averagerating", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("averagerating")
  public Double getAveragerating() {
    return averagerating;
  }

  public void setAveragerating(Double averagerating) {
    this.averagerating = averagerating;
  }

  public ProductDto ratingnumber(Integer ratingnumber) {
    this.ratingnumber = ratingnumber;
    return this;
  }

  /**
   * Get ratingnumber
   * @return ratingnumber
  */
  
  @Schema(name = "ratingnumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ratingnumber")
  public Integer getRatingnumber() {
    return ratingnumber;
  }

  public void setRatingnumber(Integer ratingnumber) {
    this.ratingnumber = ratingnumber;
  }

  public ProductDto features(String features) {
    this.features = features;
    return this;
  }

  /**
   * Get features
   * @return features
  */
  
  @Schema(name = "features", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("features")
  public String getFeatures() {
    return features;
  }

  public void setFeatures(String features) {
    this.features = features;
  }

  public ProductDto store(String store) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductDto product = (ProductDto) o;
    return Objects.equals(this.id, product.id) &&
        Objects.equals(this.name, product.name) &&
        Objects.equals(this.price, product.price) &&
        Objects.equals(this.image, product.image) &&
        Objects.equals(this.stock, product.stock) &&
        Objects.equals(this.quantity, product.quantity) &&
        Objects.equals(this.maincategory, product.maincategory) &&
        Objects.equals(this.averagerating, product.averagerating) &&
        Objects.equals(this.ratingnumber, product.ratingnumber) &&
        Objects.equals(this.features, product.features) &&
        Objects.equals(this.store, product.store);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, price, image, stock, quantity, maincategory, averagerating, ratingnumber, features, store);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    stock: ").append(toIndentedString(stock)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    maincategory: ").append(toIndentedString(maincategory)).append("\n");
    sb.append("    averagerating: ").append(toIndentedString(averagerating)).append("\n");
    sb.append("    ratingnumber: ").append(toIndentedString(ratingnumber)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
    sb.append("    store: ").append(toIndentedString(store)).append("\n");
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

