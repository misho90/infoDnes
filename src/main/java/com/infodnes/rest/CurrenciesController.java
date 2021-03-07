package com.infodnes.rest;

import com.infodnes.model.CurrencyRates;
import com.infodnes.model.dto.RssFeedItemDto;
import com.infodnes.service.currencies.LoadCurrenciesByDateService;
import com.infodnes.service.rss.RSSFeedReaderService;
import com.infodnes.service.rss.SearchNewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/currencies")
public class CurrenciesController {

  private final LoadCurrenciesByDateService loadCurrenciesByDateService;

  @GetMapping("/today")
  public ResponseEntity< List<CurrencyRates>> currencies() {
    String date = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH)
                                   .format(LocalDateTime.now());

    return ResponseEntity.status(HttpStatus.OK)
                         .body(loadCurrenciesByDateService.getCurrencyRates(date));
  }
}
