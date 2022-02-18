package com.example.repo;

import com.example.model.suku_cadang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo_suku_cadang extends JpaRepository<suku_cadang,String>
{



}
