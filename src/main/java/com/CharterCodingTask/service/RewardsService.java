package com.CharterCodingTask.service;

import com.CharterCodingTask.model.Rewards;

import org.springframework.stereotype.Service;

@Service
public interface RewardsService {
    public Rewards getRewardsByCustomerId(Long customerId);
}
