package com.infodnes.utils.weather.dailyforecast;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Current{
    public int dt;
    public int sunrise;
    public int sunset;
    public double temp;
    public double feels_like;
    public int pressure;
    public int humidity;
    public double dew_point;
    public int uvi;
    public int clouds;
    public int visibility;
    public double wind_speed;
    public int wind_deg;
    public List<Weather> weather;
}