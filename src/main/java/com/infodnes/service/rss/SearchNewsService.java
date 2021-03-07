package com.infodnes.service.rss;

import com.infodnes.model.dto.RssFeedItemDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchNewsService {
	public List<RssFeedItemDto> search(String word);
}
