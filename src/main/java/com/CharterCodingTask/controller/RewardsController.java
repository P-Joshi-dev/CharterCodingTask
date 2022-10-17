package com.CharterCodingTask.controller;

import com.CharterCodingTask.entity.Customer;
import com.CharterCodingTask.entity.Transaction;
import com.CharterCodingTask.model.Rewards;
import com.CharterCodingTask.repository.CustomerRepository;
import com.CharterCodingTask.repository.TransactionRepository;
import com.CharterCodingTask.service.RewardsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customers")
public class RewardsController {
    @Autowired
    RewardsService rewardsService;

    @Autowired
    CustomerRepository customerRepository;
   @Autowired
    TransactionRepository transactionRepository;

    @GetMapping(value = "/{customerId}/rewards",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rewards> getRewardsByCustomerId(@PathVariable("customerId") Long customerId){
        Customer customer = customerRepository.findByCustomerId(customerId);
        if(customer == null)
        {
            throw new RuntimeException("Invalid customer Id ");
        }
        Rewards customerRewards = rewardsService.getRewardsByCustomerId(customerId);
        return new ResponseEntity<>(customerRewards,HttpStatus.OK);
    }
}
