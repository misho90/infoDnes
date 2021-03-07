package com.infodnes.service.impl.rss;


import com.infodnes.model.dto.RssFeedItemDto;
import com.infodnes.repository.RssFeedItemRepository;
import com.infodnes.service.rss.RSSFeedReaderService;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RSSFeedReaderServiceImpl implements RSSFeedReaderService {

  private final RssFeedItemRepository rssFeedItemRepository;

  public List<RssFeedItemDto> getFeed(final String url, final String sourceName) {
    Optional<SyndFeed> feed = Optional.empty();
    try {
      URL feedSource = RSSFeedUtils.create(url);
      SyndFeedInput input = new SyndFeedInput();
      feed = Optional.ofNullable(input.build(new XmlReader(feedSource)));
    } catch (IllegalArgumentException | FeedException | IOException e) {
      e.printStackTrace();
    }
    return RSSFeedUtils.fetchFeedItemsFromRssFeed(feed, sourceName);
  }

  @Override
  public List<RssFeedItemDto> retrieveNewest20() {
    return rssFeedItemRepository.findFirst20ByOrderByDateDesc().stream().map(
        (rssFeed) -> new RssFeedItemDto(rssFeed.getTitle(), rssFeed.getLink(), rssFeed.getDate(), rssFeed.getGuid(),
            rssFeed.getFeedSource().getName(), rssFeed.getDescription())).collect(Collectors.toList());
  }
}
