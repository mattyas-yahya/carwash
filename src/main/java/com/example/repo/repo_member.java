package com.example.repo;

import com.example.model.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface repo_member extends JpaRepository<member,String> {
}
