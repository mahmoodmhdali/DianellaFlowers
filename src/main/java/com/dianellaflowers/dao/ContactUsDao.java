package com.dianellaflowers.dao;

import com.dianellaflowers.model.ContactUs;
import java.util.List;

public interface ContactUsDao {

    void addSubscription(ContactUs contactUs) throws Exception;

    List<ContactUs> findAll();

    ContactUs findByEmail(String email);

}
