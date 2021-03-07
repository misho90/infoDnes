package com.infodnes.utils.exchangerate;

import com.infodnes.service.impl.currencies.StoreCurrencyRatesIntoTheDatabaseServiceImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ExchangerateResponse{
  public Motd motd;
  public boolean success;
  public String base;
  public String date;
  public Rates rates;
}
