package com.example.springjparest.manytomany.simplepkextracolumn.service;

import com.example.springjparest.manytomany.simplepkextracolumn.exception.ReviewerNotFoundException;
import com.example.springjparest.manytomany.simplepkextracolumn.model.Reviewer;
import com.example.springjparest.manytomany.simplepkextracolumn.repository.ReviewerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewerServiceImpl implements ReviewerService {

    private final ReviewerRepository reviewerRepository;

    @Override
    public Reviewer validateAndGetReviewer(String id) {
        return reviewerRepository.findById(id).orElseThrow(() -> new ReviewerNotFoundException(id));
    }

    @Override
    public Reviewer saveReviewer(Reviewer reviewer) {
        return reviewerRepository.save(reviewer);
    }

    @Override
    public void deleteReviewer(Reviewer reviewer) {
        reviewerRepository.delete(reviewer);
    }
}
