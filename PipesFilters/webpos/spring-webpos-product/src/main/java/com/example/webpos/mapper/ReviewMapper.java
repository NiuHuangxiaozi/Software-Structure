package com.example.webpos.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.webpos.model.Review;
import com.example.webpos.model.dto.ReviewDto;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewDto toReviewDto(Review review);

    Review toReview(ReviewDto reviewDto);

    List<ReviewDto> toReviewDtoList(List<Review> reviews);

    List<Review> toReviewList(List<ReviewDto> reviewDtos);
}
