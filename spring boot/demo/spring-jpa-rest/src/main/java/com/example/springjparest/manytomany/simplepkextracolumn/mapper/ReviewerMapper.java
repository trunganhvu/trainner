package com.example.springjparest.manytomany.simplepkextracolumn.mapper;

import com.example.springjparest.manytomany.simplepkextracolumn.model.Reviewer;
import com.example.springjparest.manytomany.simplepkextracolumn.rest.dto.CreateReviewerRequest;
import com.example.springjparest.manytomany.simplepkextracolumn.rest.dto.ReviewerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comments", ignore = true)
    Reviewer toReviewer(CreateReviewerRequest createReviewerRequest);

    ReviewerResponse toReviewerResponse(Reviewer reviewer);
}
