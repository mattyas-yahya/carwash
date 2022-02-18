package com.example.repo;

import com.example.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repo_account extends JpaRepository<Account,String> {
}
