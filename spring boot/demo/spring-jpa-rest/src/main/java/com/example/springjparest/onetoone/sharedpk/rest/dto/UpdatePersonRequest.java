package com.example.springjparest.onetoone.sharedpk.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePersonRequest {

    @Schema(example = "Trump 2")
    private String name;
}