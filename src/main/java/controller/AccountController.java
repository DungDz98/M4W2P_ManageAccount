package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.IAccountService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping("/")
    public ModelAndView showHome(@RequestParam Optional<String> search, @PageableDefault(value = 3) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("show");
        Page<Account> accountList;
        if (search.isPresent()) {
            accountList = accountService.findByName(search.get(), pageable);
        } else {
            accountList = accountService.findAll(pageable);
        }
        modelAndView.addObject("accountList", accountList);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate() {
        return new ModelAndView("create", "account", new Account());
    }
    @GetMapping("/edit")
    public ModelAndView showEdit(@RequestParam("id") Account account) {
        return new ModelAndView("edit", "account", account);
    }
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("id") int id) {
        accountService.delete(id);
        return new ModelAndView("redirect:/");
    }
    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute Account account, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("redirect:/create");
        }
        accountService.save(account);
        return new ModelAndView("redirect:/");
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute Account account) {
        accountService.save(account);
        return new ModelAndView("redirect:/");
    }



}
