package com.infodnes.service.impl.rss;

import com.infodnes.model.dto.RssFeedItemDto;
import com.infodnes.repository.RssFeedItemRepository;
import com.infodnes.service.rss.SearchNewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchNewsServiceImpl implements SearchNewsService {

  public final RssFeedItemRepository rssFeedItemRepository;

  @Override
  public List<RssFeedItemDto> search(String word) {
    return rssFeedItemRepository.findByTitleIsContaining(word).stream().map(
        (rssFeed) -> new RssFeedItemDto(rssFeed.getTitle(), rssFeed.getLink(), rssFeed.getDate(), rssFeed.getGuid(),
            rssFeed.getFeedSource().getName(), rssFeed.getDescription())).collect(Collectors.toList());
  }
}
