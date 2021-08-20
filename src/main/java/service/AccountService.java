package service;

import model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.IAccountRepository;

import java.util.Optional;

public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    @Override
    public Optional<Account> findById(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void delete(int id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Page<Account> findByName(String name, Pageable pageable) {
        return accountRepository.findAllByUsernameContaining(name, pageable);
    }
}
