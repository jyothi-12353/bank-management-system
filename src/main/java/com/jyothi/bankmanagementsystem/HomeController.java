package com.jyothi.bankmanagementsystem;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public HomeController(
        AccountRepository accountRepository,
        TransactionRepository transactionRepository) {

    this.accountRepository = accountRepository;
    this.transactionRepository = transactionRepository;
    }
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/register")
    public String createAccount(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam double deposit) {

        String accountNumber = String.valueOf(System.currentTimeMillis());

        Account account = new Account(
                accountNumber,
                name,
                email,
                phone,
                password,
                deposit,
                "SAVINGS"
        );

        accountRepository.save(account);

        return "redirect:/login";
    }

    @PostMapping("/login")
    public String loginUser(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session) {

        Account account = accountRepository.findAll()
                .stream()
                .filter(a -> a.getEmail().equals(email)
                        && a.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (account != null) {

            session.setAttribute("account", account);

            return "redirect:/dashboard";
        }

        return "redirect:/login?error=true";
    }

    @GetMapping("/dashboard")
public String dashboard(
        HttpSession session,
        Model model) {

    Account account = (Account) session.getAttribute("account");

    if (account == null) {
        return "redirect:/login";
    }

    model.addAttribute("account", account);

    var transactions =
            transactionRepository
                    .findByAccountNumberOrderByTransactionDateDesc(
                            account.getAccountNumber()
                    );

    model.addAttribute("transactions", transactions);

    return "dashboard";
    }
    @PostMapping("/deposit")
public String deposit(
        @RequestParam double amount,
        HttpSession session) {

    Account account = (Account) session.getAttribute("account");

    if (account == null) {
        return "redirect:/login";
    }

    if (amount > 0) {

        account.setBalance(account.getBalance() + amount);

        accountRepository.save(account);

        Transaction transaction = new Transaction(
                account.getAccountNumber(),
                "DEPOSIT",
                amount
        );

        transactionRepository.save(transaction);

        session.setAttribute("account", account);
    }

    return "redirect:/dashboard";
    }
    @PostMapping("/withdraw")
public String withdraw(
        @RequestParam double amount,
        HttpSession session) {

    Account account = (Account) session.getAttribute("account");

    if (account == null) {
        return "redirect:/login";
    }

    if (amount > 0 && amount <= account.getBalance()) {

        account.setBalance(account.getBalance() - amount);

        accountRepository.save(account);

        Transaction transaction = new Transaction(
                account.getAccountNumber(),
                "WITHDRAW",
                amount
        );

        transactionRepository.save(transaction);

        session.setAttribute("account", account);
    }

    return "redirect:/dashboard";
}
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }
}