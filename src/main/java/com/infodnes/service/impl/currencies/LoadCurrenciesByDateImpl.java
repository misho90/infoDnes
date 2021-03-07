package com.infodnes.service.impl.currencies;

import com.infodnes.model.CurrencyRates;
import com.infodnes.repository.currency.CurrencyRatesRepository;
import com.infodnes.service.currencies.LoadCurrenciesByDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LoadCurrenciesByDateImpl implements LoadCurrenciesByDateService {

  private final CurrencyRatesRepository currencyRatesRepository;

  @Override
  public List<CurrencyRates> getCurrencyRates(String date) {
    return currencyRatesRepository.findByDate(date);
  }
}
