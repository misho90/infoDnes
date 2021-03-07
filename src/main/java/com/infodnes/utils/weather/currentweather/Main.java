package com.infodnes.utils.weather.currentweather;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Main{
    public double temp;
    public double feels_like;
    public int temp_min;
    public double temp_max;
    public int pressure;
    public int humidity;
}