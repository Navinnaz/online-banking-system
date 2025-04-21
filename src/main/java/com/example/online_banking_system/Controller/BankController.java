package com.example.online_banking_system.Controller;

import com.example.online_banking_system.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BankController {

    private Account account = new Account();

    public BankController() {
        account.setId(1L);
        account.setName("John Doe");
        account.setBalance(1000.0);
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("account", account);
        return "home";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam double amount) {
        account.setBalance(account.getBalance() + amount);
        return "redirect:/";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam double amount) {
        account.setBalance(account.getBalance() - amount);
        return "redirect:/";
    }
}
