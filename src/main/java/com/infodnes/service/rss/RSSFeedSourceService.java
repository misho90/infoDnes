package com.infodnes.service.rss;

import com.infodnes.model.RssFeedSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RSSFeedSourceService {

  public RssFeedSource save(RssFeedSource source);

  public void delete(long id);

  public List<RssFeedSource> findAll();
}
