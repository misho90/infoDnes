package com.infodnes.service.currencies;

import com.infodnes.model.CurrencyRates;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoadCurrenciesByDateService {
  public List<CurrencyRates> getCurrencyRates(String date);
}