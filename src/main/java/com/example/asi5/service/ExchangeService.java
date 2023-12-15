package com.example.asi5.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.asi5.model.Exchange;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ExchangeService {
    
    private Exchange[] getExchangeData(){
        // link do udostępnionego RestAPI
        String url = "https://api.nbp.pl/api/exchangerates/tables/c/?format=json";
        // Pobieranie informacji z API w postaci strinaga 
        RestTemplate rest = new RestTemplate();
        String result = rest.getForObject(url, String.class);
        // tworzenie obiektu do tworzenia JSON-a z obiektów i konwersi ze stringa do JSON-a
        ObjectMapper mapper = new ObjectMapper();
        Exchange[] tempData = null;
        try {
            // konwersja stringa na konkretny obiekt 
            tempData = mapper.readValue(result, Exchange[].class);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tempData;
    }

    public Exchange getDatExchanges(){
        return getExchangeData()[0];
    }
}
