package repository;

import model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends PagingAndSortingRepository<Account, Integer> {
    Page<Account> findAllByUsernameContaining(String username, Pageable pageable);
}
