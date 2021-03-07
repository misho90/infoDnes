package com.infodnes.repository.currency;

import com.infodnes.model.CurrencyRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CurrencyRatesRepository extends JpaRepository<CurrencyRates, Long> {

  List<CurrencyRates> findByDate(String date);
}
