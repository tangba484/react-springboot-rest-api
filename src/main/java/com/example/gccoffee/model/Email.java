package com.example.gccoffee.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Builder
@Setter
public class Email {

    @javax.validation.constraints.Email
    @Size(min = 4, message = "이메일 주소는 적어도 4자 이상이어야 합니다.")
    private String address;

    @JsonCreator
    public Email(@JsonProperty("address") String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        return address != null ? address.equals(email.address) : email.address == null;
    }

}
