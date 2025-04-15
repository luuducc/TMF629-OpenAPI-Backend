package com.example.tmf629.model.contactmedium;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonTypeName("PhoneContactMedium")
public class PhoneContactMedium extends ContactMedium {
    private String phoneNumber;
}
