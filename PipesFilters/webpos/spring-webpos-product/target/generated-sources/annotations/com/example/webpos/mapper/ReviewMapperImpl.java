package com.example.webpos.mapper;

import com.example.webpos.model.Review;
import com.example.webpos.model.dto.ReviewDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-21T20:01:13+0800",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240417-1011, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public ReviewDto toReviewDto(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewDto reviewDto = new ReviewDto();

        reviewDto.setAsin( review.getAsin() );
        reviewDto.setId( review.getId() );
        reviewDto.setImage( review.getImage() );
        reviewDto.setParentasin( review.getParentasin() );
        reviewDto.setRating( review.getRating() );
        reviewDto.text( review.getText() );
        reviewDto.title( review.getTitle() );
        reviewDto.userid( review.getUserid() );

        return reviewDto;
    }

    @Override
    public Review toReview(ReviewDto reviewDto) {
        if ( reviewDto == null ) {
            return null;
        }

        Review review = new Review();

        review.setAsin( reviewDto.getAsin() );
        if ( reviewDto.getId() != null ) {
            review.setId( reviewDto.getId() );
        }
        review.setImage( reviewDto.getImage() );
        review.setParentasin( reviewDto.getParentasin() );
        review.setRating( reviewDto.getRating() );
        review.setText( reviewDto.getText() );
        review.setTitle( reviewDto.getTitle() );
        review.setUserid( reviewDto.getUserid() );

        return review;
    }

    @Override
    public List<ReviewDto> toReviewDtoList(List<Review> reviews) {
        if ( reviews == null ) {
            return null;
        }

        List<ReviewDto> list = new ArrayList<ReviewDto>( reviews.size() );
        for ( Review review : reviews ) {
            list.add( toReviewDto( review ) );
        }

        return list;
    }

    @Override
    public List<Review> toReviewList(List<ReviewDto> reviewDtos) {
        if ( reviewDtos == null ) {
            return null;
        }

        List<Review> list = new ArrayList<Review>( reviewDtos.size() );
        for ( ReviewDto reviewDto : reviewDtos ) {
            list.add( toReview( reviewDto ) );
        }

        return list;
    }
}
