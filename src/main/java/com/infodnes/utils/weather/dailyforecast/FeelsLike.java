package com.infodnes.utils.weather.dailyforecast;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class FeelsLike{
    public double day;
    public double night;
    public double eve;
    public double morn;
}