package com.example.springjparest.manytomany.compositepkextracolumn.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStudentRequest {

    @Schema(example = "Steve Jobs")
    private String name;
}
