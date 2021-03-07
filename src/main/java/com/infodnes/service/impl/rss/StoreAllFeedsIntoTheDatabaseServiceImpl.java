package com.infodnes.service.impl.rss;


import com.infodnes.model.RssFeedItem;
import com.infodnes.model.RssFeedSource;
import com.infodnes.model.dto.RssFeedItemDto;
import com.infodnes.repository.RssFeedItemRepository;
import com.infodnes.repository.RssFeedSourceRepository;
import com.infodnes.service.rss.RSSFeedReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Transactional
public class StoreAllFeedsIntoTheDatabaseServiceImpl {

  private final RssFeedSourceRepository rssFeedSourceRepository;

  private final RssFeedItemRepository rssFeedItemRepository;

  private final RSSFeedReaderService rssFeedReaderService;

  @Scheduled(fixedRate = 60000)
  public void sheduledStoreIntoTheDatabase() {
    List<RssFeedSource> rssFeedSources = rssFeedSourceRepository.findAll();

    rssFeedSources.stream()
        .map(x -> rssFeedReaderService.getFeed(x.getLink(), x.getName()))
        .flatMap(List::stream)
        .forEach(x -> storeRssFeedItem(x));
    }

  private void storeRssFeedItem(RssFeedItemDto feed) {
    Optional<RssFeedItem> item = this.rssFeedItemRepository.getByLink(feed.getLink());
    if (!item.isPresent()) {
      RssFeedSource feedSource = this.rssFeedSourceRepository.getByName(feed.getSourceName());
      rssFeedItemRepository.save(new RssFeedItem(null,
                                                  feed.getTitle(),
                                                  feed.getDescription(),
                                                  feed.getLink(),
                                                  feed.getDate(),
                                                  feed.getGuid(),
                                                  feedSource));
    };
  }
}