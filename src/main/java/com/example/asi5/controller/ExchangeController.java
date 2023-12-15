package com.example.asi5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.asi5.service.ExchangeService;

@Controller
@RequestMapping("/exchange")
public class ExchangeController {
    
    @Autowired
    ExchangeService exchangeService;

    @GetMapping("/")
    public String showExchangeData(Model model){
        // wyświetlenie danych pobranych z RestAPI w pliku html
        model.addAttribute("exchanges",exchangeService.getDatExchanges());
        return "list_exchanges";
    }
}
