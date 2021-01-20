package com.example.banking.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account implements Serializable{

  @Id
  @Column(name = "ACCOUNT_NUMBER")
  private String accountNumber;
  @Column(name = "BALANCE")
  private BigDecimal balance;
  @Column(name = "LAST_UPDATED_AT")
  private Date lastUpdateAt;
  @Column(name = "CREATED_AT")
  private Date createdAt;

  public Account() {
  }

  public Account(String accountNumber, BigDecimal balance, Date lastUpdateAt) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.lastUpdateAt = lastUpdateAt;
    //this.createdAt = createdAt;
  }

  public Account(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public Date getLastUpdateAt() {
    return lastUpdateAt;
  }

  public void setLastUpdateAt(Date lastUpdateAt) {
    this.lastUpdateAt = lastUpdateAt;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "Account{" +
        "accountNumber='" + accountNumber + '\'' +
        ", balance=" + balance +
        ", lastUpdateAt=" + lastUpdateAt +
        //", createdAt=" + createdAt +
        '}';
  }
}
