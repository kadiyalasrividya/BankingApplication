package com.example.banking.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "transaction")
@IdClass(CompositeKey.class)
public class Transaction implements Serializable {

  @Id
  @Column(name = "TRANSACTION_ID")
  private Long transactionId;

  @Column(name = "DESCRIPTION")
  private String description;

  @Column(name = "TYPE")
  private String type;

  @Column(name = "AMOUNT")
  private BigDecimal amount;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "TIME")
  private Date time;

  @Id
  @Column(name = "ACCOUNT_ID")
  private String accountId;

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public Long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(Long transactionId) {
    this.transactionId = transactionId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public Transaction() {
  }

  public Transaction(Long transactionId, String type, BigDecimal amount,
      Date time, String accountId) {
    this.transactionId = transactionId;
    this.type = type;
    this.amount = amount;
    this.time = time;
    this.accountId = accountId;
  }

  @Override
  public String toString() {
    return "Transaction{" +
        "transactionId=" + transactionId +
        ", description='" + description + '\'' +
        ", type='" + type + '\'' +
        ", amount=" + amount +
        ", time=" + time +
        ", accountId='" + accountId + '\'' +
        '}';
  }
}
