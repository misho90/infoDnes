package com.infodnes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CurrencyRates")
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRates implements Serializable {

  private static final long serialversionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Getter
  @Setter
  private String code;

  @Getter
  @Setter
  @Column(name="value", columnDefinition="Decimal(10,5)")
  private BigDecimal value;

  @Getter
  @Setter
  private String date;
}