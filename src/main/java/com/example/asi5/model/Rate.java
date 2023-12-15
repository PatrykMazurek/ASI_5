package com.example.asi5.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rate {
    
    private String currency;
    private String code;
    private double bid;
    private double ask;

}
