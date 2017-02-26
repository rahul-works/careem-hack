package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.SubscriptionDao;
import com.app.entity.common.SubscriptionPlans;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	SubscriptionDao subscriptionDao;

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW, readOnly = false, value = "db1SessionFactory")
	public SubscriptionPlans addPlan(SubscriptionPlans addPlan) {
		return subscriptionDao.addPlan(addPlan);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW, readOnly = false, value = "db1SessionFactory")
	public SubscriptionPlans getPlan(Long planId) {
		return subscriptionDao.getPlan(planId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW, readOnly = false, value = "db1SessionFactory")
	public SubscriptionPlans updatePlan(SubscriptionPlans updatePlan) {
		return subscriptionDao.updatePlan(updatePlan);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW, readOnly = false, value = "db2SessionFactory")
	public SubscriptionPlans addPlan2(SubscriptionPlans addPlan) {
		return subscriptionDao.addPlan2(addPlan);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW, readOnly = false, value = "db2SessionFactory")
	public SubscriptionPlans getPlan2(Long planId) {
		return subscriptionDao.getPlan2(planId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW, readOnly = false, value = "db2SessionFactory")
	public SubscriptionPlans updatePlan2(SubscriptionPlans updatePlan) {
		return subscriptionDao.updatePlan2(updatePlan);
	}

}
