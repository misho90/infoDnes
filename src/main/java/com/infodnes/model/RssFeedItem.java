package com.infodnes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "rssFeedItem")
@NoArgsConstructor
@AllArgsConstructor
public class RssFeedItem implements Serializable {

  private static final long serialversionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Getter
  @Setter
  private String title;

  @Lob
  @Getter
  @Setter
  @Column(length = 1000)
  private String description;

  @Getter
  @Setter
  private String link;

  @Getter
  @Setter
  private Date date;

  @Getter
  @Setter
  private long guid;

  @Getter
  @Setter
  @ManyToOne
  @JoinColumn(name = "feedSource_id", nullable = false)
  private RssFeedSource feedSource;
}
