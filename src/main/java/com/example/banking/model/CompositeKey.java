package com.example.banking.model;

import java.io.Serializable;

public class CompositeKey implements Serializable {

  private Long transactionId;
  private String accountId;

  public CompositeKey() {
  }

  public CompositeKey(Long transactionId, String accountId) {
    this.transactionId = transactionId;
    this.accountId = accountId;
  }

  public Long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(Long transactionId) {
    this.transactionId = transactionId;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  @Override
  public String toString() {
    return "CompositeKey{" +
        "transactionId=" + transactionId +
        ", accountId='" + accountId + '\'' +
        '}';
  }
}
