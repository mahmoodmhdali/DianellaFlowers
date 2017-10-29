package com.dianellaflowers.service;

import com.dianellaflowers.model.ContactUs;
import java.util.List;

public interface ContactUsService {

    List<ContactUs> findAll();

    ContactUs findByEmail(String email);

    void addSubscription(ContactUs contactUs) throws Exception;

}
