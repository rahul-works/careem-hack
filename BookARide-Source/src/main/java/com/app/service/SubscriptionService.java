package com.app.service;

import com.app.entity.common.SubscriptionPlans;

public interface SubscriptionService {

	SubscriptionPlans addPlan(SubscriptionPlans addPlan);

	SubscriptionPlans getPlan(Long planId);

	SubscriptionPlans updatePlan(SubscriptionPlans updatePlan);

	SubscriptionPlans addPlan2(SubscriptionPlans addPlan);

	SubscriptionPlans getPlan2(Long planId);

	SubscriptionPlans updatePlan2(SubscriptionPlans updatePlan);
}
