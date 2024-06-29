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
 * ReviewDto
 */

@JsonTypeName("Review")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-21T19:42:45.140585600+08:00[Asia/Shanghai]", comments = "Generator version: 7.5.0")
public class ReviewDto {

  private Integer id;

  private Double rating = null;

  private String title;

  private String text;

  private String image;

  private String asin;

  private String parentasin;

  private String userid;

  public ReviewDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ReviewDto(Integer id) {
    this.id = id;
  }

  public ReviewDto id(Integer id) {
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
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ReviewDto rating(Double rating) {
    this.rating = rating;
    return this;
  }

  /**
   * Get rating
   * @return rating
  */
  
  @Schema(name = "rating", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("rating")
  public Double getRating() {
    return rating;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }

  public ReviewDto title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  */
  
  @Schema(name = "title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ReviewDto text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Get text
   * @return text
  */
  
  @Schema(name = "text", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("text")
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public ReviewDto image(String image) {
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

  public ReviewDto asin(String asin) {
    this.asin = asin;
    return this;
  }

  /**
   * Get asin
   * @return asin
  */
  
  @Schema(name = "asin", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("asin")
  public String getAsin() {
    return asin;
  }

  public void setAsin(String asin) {
    this.asin = asin;
  }

  public ReviewDto parentasin(String parentasin) {
    this.parentasin = parentasin;
    return this;
  }

  /**
   * Get parentasin
   * @return parentasin
  */
  
  @Schema(name = "parentasin", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parentasin")
  public String getParentasin() {
    return parentasin;
  }

  public void setParentasin(String parentasin) {
    this.parentasin = parentasin;
  }

  public ReviewDto userid(String userid) {
    this.userid = userid;
    return this;
  }

  /**
   * Get userid
   * @return userid
  */
  
  @Schema(name = "userid", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userid")
  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReviewDto review = (ReviewDto) o;
    return Objects.equals(this.id, review.id) &&
        Objects.equals(this.rating, review.rating) &&
        Objects.equals(this.title, review.title) &&
        Objects.equals(this.text, review.text) &&
        Objects.equals(this.image, review.image) &&
        Objects.equals(this.asin, review.asin) &&
        Objects.equals(this.parentasin, review.parentasin) &&
        Objects.equals(this.userid, review.userid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, rating, title, text, image, asin, parentasin, userid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReviewDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    asin: ").append(toIndentedString(asin)).append("\n");
    sb.append("    parentasin: ").append(toIndentedString(parentasin)).append("\n");
    sb.append("    userid: ").append(toIndentedString(userid)).append("\n");
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

