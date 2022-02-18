package com.example.repo;

import com.example.model.journal_transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repo_journal_transaction extends JpaRepository<journal_transaction,String> {
}
