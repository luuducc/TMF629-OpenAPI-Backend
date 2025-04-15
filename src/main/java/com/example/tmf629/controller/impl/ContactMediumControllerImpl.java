package com.example.tmf629.controller.impl;

import com.example.tmf629.controller.ContactMediumController;
import com.example.tmf629.model.contactmedium.ContactMedium;
import com.example.tmf629.model.contactmedium.GeographicAddressContactMedium;
import com.example.tmf629.model.contactmedium.PhoneContactMedium;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactMediumControllerImpl implements ContactMediumController {
    @Override
    @PostMapping("/contact-mediums")
    public List<ContactMedium> getContactMediums(@RequestBody List<ContactMedium> contactMediums) {
//        PhoneContactMedium phone = new PhoneContactMedium();
//        phone.setId("ph1");
//        phone.setContactType("phone");
//        phone.setPreferred(true);
//        phone.setPhoneNumber("0899281499");
//        phone.setType("Phonehihi"); // must match @JsonTypeName
//        phone.setBaseType("ContactMedium");
//
//        GeographicAddressContactMedium address = new GeographicAddressContactMedium();
//        address.setId("addr1");
//        address.setContactType("address");
//        address.setPreferred(false);
//        address.setStreet1("123 Main St");
//        address.setCity("Hanoi");
//        address.setCountry("Vietnam");
//        address.setPostCode("10000");
//        address.setType("Geographic");
//        address.setBaseType("ContactMedium");

        return contactMediums;
    }
}
