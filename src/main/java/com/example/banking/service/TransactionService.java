package com.example.banking.service;


import com.example.banking.exception.InvalidRequestParameterException;
import com.example.banking.model.Transaction;
import com.example.banking.repository.TransactionRepository;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService {

  @Autowired
  private TransactionRepository transactionRepository;

  @Override
  public List<Transaction> findAll() {
    return (List<Transaction>) transactionRepository.findAll();
  }

  @Override
  public List<Transaction> getTransactionByAccountId(String id, Date startDate, Date endDate,
      String timeRange, List<String> type) {
    DateRange dateRange = calculateStartAndEndDates(startDate, endDate, timeRange);
    return transactionRepository.getTransactionByAccountId(id,
        dateRange.getStartDate(), dateRange.getEndDate(), type);
  }

  private DateRange calculateStartAndEndDates(Date startDate, Date endDate, String timeRange) {
    Date currentDay = new Date();
    if (startDate != null && endDate != null) {
      return new DateRange(startDate, endDate);
    } else if (startDate != null && endDate == null) {
      if (startDate.after(endDate)) {
        throw new InvalidRequestParameterException("Start date should be earlier than end date");
      }
      return new DateRange(startDate, currentDay);
    } else if (startDate == null && endDate != null) {
      return new DateRange(new DateTime(endDate).minusDays(365).toDate(), currentDay);
    } else {
      if (timeRange.equalsIgnoreCase("TODAY")) {
        return new DateRange(new DateTime(currentDay).minusDays(1).toDate(), currentDay);
      } else if (timeRange.equalsIgnoreCase(String.valueOf("Last7DAYS"))) {
        return new DateRange(new DateTime(currentDay).minusDays(7).toDate(), currentDay);
      } else if (timeRange.equalsIgnoreCase(String.valueOf("LastMonth"))) {
        return new DateRange(new DateTime(currentDay).minusMonths(1).toDate(), currentDay);
      } else {
        return new DateRange(new DateTime(currentDay).minusDays(1).toDate(), currentDay);
      }
    }
  }
}

