package com.whitecloak.digitalbank.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserFullNameResponse {

    private String fullName;

    public UserFullNameResponse() { }

    public UserFullNameResponse(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}