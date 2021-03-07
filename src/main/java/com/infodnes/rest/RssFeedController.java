package com.infodnes.rest;

import com.infodnes.model.dto.RssFeedItemDto;
import com.infodnes.service.rss.RSSFeedReaderService;
import com.infodnes.service.rss.SearchNewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/rss")
public class RssFeedController {

  private final RSSFeedReaderService rssFeedReaderService;

  private final SearchNewsService searchNewsService;

  @GetMapping("/printRSS")
  public ResponseEntity<List<RssFeedItemDto>> printRSS() {
    return ResponseEntity.status(HttpStatus.OK).body(rssFeedReaderService.retrieveNewest20());
  }

  @GetMapping("/search/{word}")
  public ResponseEntity<List<RssFeedItemDto>> search(@PathVariable String word) {
    return ResponseEntity.status(HttpStatus.OK).body(searchNewsService.search(word));
  }
}