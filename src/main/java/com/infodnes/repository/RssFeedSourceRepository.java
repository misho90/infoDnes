package com.infodnes.repository;

import com.infodnes.model.RssFeedSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RssFeedSourceRepository extends JpaRepository<RssFeedSource, Long> {

  public RssFeedSource save(RssFeedSource source);

  RssFeedSource getByName(String name);

  List<RssFeedSource> findAll();
}
