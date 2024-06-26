package com.example.springjparest.onetoone.sharedpk.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePersonDetailRequest {

    @Schema(example = "More information about the person")
    @NotBlank
    private String description;
}
