package com.gt.curso.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnimePostResquesBody {

    @NotEmpty(message = "The Name cannot be empty")
    @NotNull (message = "the name cannot be null ")
    private String name;
}
