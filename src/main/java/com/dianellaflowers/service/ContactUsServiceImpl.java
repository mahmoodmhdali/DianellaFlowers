/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.service;

import com.dianellaflowers.dao.ContactUsDao;
import com.dianellaflowers.model.ContactUs;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("contactUsService")
public class ContactUsServiceImpl implements ContactUsService {

    @Autowired
    ContactUsDao contactUsDao;

    @Override
    public ContactUs findByEmail(String email) {
        return contactUsDao.findByEmail(email);
    }

    @Override
    public List<ContactUs> findAll() {
        return contactUsDao.findAll();
    }

    @Override
    public void addSubscription(ContactUs contactUs) throws Exception {
        contactUsDao.addSubscription(contactUs);
    }

}
