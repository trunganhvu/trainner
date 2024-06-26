package com.example.springjparest.onetoone.simplepk.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTeamAllFieldsRequest {

    @Schema(example = "Team White")
    @NotBlank
    private String name;

    @Schema(example = "This team is awesome")
    @NotBlank
    private String description;
}
