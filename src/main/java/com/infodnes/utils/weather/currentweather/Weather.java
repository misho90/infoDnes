package com.infodnes.utils.weather.currentweather;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Weather{
    public int id;
    public String main;
    public String description;
    public String icon;
}