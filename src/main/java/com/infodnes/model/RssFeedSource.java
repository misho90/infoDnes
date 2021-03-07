package com.infodnes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "rssFeedSource")
@NoArgsConstructor
public class RssFeedSource implements Serializable {

  private static final long serialversionUID = 1L;

  @Id
  @Getter
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Getter
  @Setter
  private String name;

  @Getter
  @Setter
  private String link;

  @OneToMany(mappedBy = "feedSource", cascade = CascadeType.REMOVE, orphanRemoval = true)
  private List<RssFeedItem> rssFeedItem;
}
