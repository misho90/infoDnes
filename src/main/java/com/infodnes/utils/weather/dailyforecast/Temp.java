package com.infodnes.utils.weather.dailyforecast;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Temp{
    public double day;
    public double min;
    public double max;
    public double night;
    public double eve;
    public double morn;
}