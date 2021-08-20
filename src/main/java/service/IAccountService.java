package service;

import model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IAccountService {
    Page<Account> findAll(Pageable pageable);
    Optional<Account> findById(int id);
    void save(Account account);
    void delete(int id);
    Page<Account> findByName(String name, Pageable pageable);
}
