package com.dianellaflowers.service;

import com.dianellaflowers.model.Subscription;
import java.util.List;

public interface SubscriptionService {

    List<Subscription> findAll();

    Subscription findByEmail(String email);
    
    void addSubscription(Subscription subscription) throws Exception;

}
