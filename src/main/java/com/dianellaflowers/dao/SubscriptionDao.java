package com.dianellaflowers.dao;

import com.dianellaflowers.model.Subscription;
import java.util.List;

public interface SubscriptionDao {

    void addSubscription(Subscription subscription) throws Exception;

    List<Subscription> findAll();

    Subscription findByEmail(String email);

}
