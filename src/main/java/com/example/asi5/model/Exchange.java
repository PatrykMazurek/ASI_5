package com.example.asi5.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Exchange {
    
    private String table;
    private String no;
    private String tradingDate;
    private String effectiveDate;
    private Rate[] rates;

}
