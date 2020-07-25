package org.sksl.spbamingos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Person {
    private final String id;

    @NotBlank
    private final String name;

    public Person(@JsonProperty("id") String id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
