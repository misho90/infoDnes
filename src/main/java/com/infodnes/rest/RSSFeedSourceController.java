package com.infodnes.rest;

import com.infodnes.model.RssFeedSource;
import com.infodnes.service.rss.RSSFeedSourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/rssSource")
@RequiredArgsConstructor
public class RSSFeedSourceController {

  private final RSSFeedSourceService rssFeedSourceService;

  @PostMapping("/source")
  public ResponseEntity<Void> createNewSource(@RequestBody RssFeedSource source) {
    RssFeedSource createdSource = rssFeedSourceService.save(source);
    return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdSource.getId()).toUri())
        .build();
  }

  @PutMapping("/source")
  public ResponseEntity<Void> updateNewSource(@RequestBody RssFeedSource source) {
    RssFeedSource createdSource = rssFeedSourceService.save(source);
    return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdSource.getId()).toUri())
        .build();
  }

  @DeleteMapping("/source/{id}")
  public ResponseEntity<Void> deleteNewSource(@PathVariable long id) {
    rssFeedSourceService.delete(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/all")
  public ResponseEntity<List<RssFeedSource>> getAllSources() {
    return ResponseEntity.status(HttpStatus.OK).body(rssFeedSourceService.findAll());
  }
}
