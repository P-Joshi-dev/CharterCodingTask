package com.CharterCodingTask.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "TRANSACTION")
public class Transaction {
 @Id
 @GeneratedValue( strategy = GenerationType.IDENTITY)
 @Column(name = "TRANSACTION_ID")
 private Long transactionId;

 @Column(name="CUSTOMER_ID")
 private Long customerId;

 @Column(name = "TRANSACTION_DATE")
 private Timestamp transactionDate;

 @Column(name = "AMOUNT")
 private double transactionAmount;

}
