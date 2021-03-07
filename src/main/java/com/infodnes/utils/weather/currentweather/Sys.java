package com.infodnes.utils.weather.currentweather;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Sys{
    public int type;
    public int id;
    public String country;
    public int sunrise;
    public int sunset;
}