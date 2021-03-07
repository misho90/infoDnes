package com.infodnes.service.impl.currencies;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infodnes.model.CurrencyRates;
import com.infodnes.repository.currency.CurrencyRatesRepository;
import com.infodnes.utils.exchangerate.ExchangerateResponse;
import com.infodnes.utils.exchangerate.Rates;
import lombok.*;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


@Component
@Transactional
@AllArgsConstructor
public class StoreCurrencyRatesIntoTheDatabaseServiceImpl {

  private final CurrencyRatesRepository currencyRatesRepository;

  @Scheduled(fixedRate = 600000)
  public void sheduledStoreIntoTheDatabase() {

    List<CurrencyRates> ratesList = new ArrayList<>();
    Rates rates = retrieveCurrencies();

    String date = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH)
                                   .format(LocalDateTime.now());
    ratesList.add(new CurrencyRates(null, "EUR", BigDecimal.valueOf(1/rates.getEUR()), date));
    ratesList.add(new CurrencyRates(null, "USD", BigDecimal.valueOf(1/rates.getUSD()), date));
    ratesList.add(new CurrencyRates(null, "CHF", BigDecimal.valueOf(1/rates.getCHF()), date));
    ratesList.add(new CurrencyRates(null, "CAD", BigDecimal.valueOf(1/rates.getCAD()), date));
    ratesList.add(new CurrencyRates(null, "GBP", BigDecimal.valueOf(1/rates.getGBP()), date));
    ratesList.add(new CurrencyRates(null, "CZK", BigDecimal.valueOf(1/rates.getCZK()), date));
    ratesList.add(new CurrencyRates(null, "DKK", BigDecimal.valueOf(1/rates.getDKK()), date));
    ratesList.add(new CurrencyRates(null, "HUF", BigDecimal.valueOf(1/rates.getHUF()), date));
    ratesList.add(new CurrencyRates(null, "JPY", BigDecimal.valueOf(1/rates.getJPY()), date));
    ratesList.add(new CurrencyRates(null, "NZD", BigDecimal.valueOf(1/rates.getNZD()), date));
    if(currencyRatesRepository.findByDate(date).isEmpty() ){
      currencyRatesRepository.saveAll(ratesList);
    };
  }

  private Rates retrieveCurrencies() {
    final String uri = "https://api.exchangerate.host/latest?base=BGN";

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity = new HttpEntity<String>(headers);

    ResponseEntity<ExchangerateResponse> responseEntity =
        restTemplate.getForEntity(uri, ExchangerateResponse.class);
    return responseEntity.getBody().rates;

  }
}