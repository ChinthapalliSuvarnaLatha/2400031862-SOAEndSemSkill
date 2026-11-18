
package com.example.bankingservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class BankController {

    @GetMapping("/account/{id}")
    public String getAccount(@PathVariable int id) {
        return "Bank Account ID: " + id;
    }

    @GetMapping("/balance/{id}")
    public String getBalance(@PathVariable int id) {
        return "Account Balance: 50000";
    }
}
