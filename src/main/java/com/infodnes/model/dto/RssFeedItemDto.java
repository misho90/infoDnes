package com.infodnes.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
public class RssFeedItemDto {
  @Getter
  @Setter
  private String title;

  @Getter
  @Setter
  private String link;

  @Getter
  @Setter
  private Date date;

  @Getter
  @Setter
  private Long guid;

  @Getter
  @Setter
  private String sourceName;

  @Getter
  @Setter
  private String description;
}
