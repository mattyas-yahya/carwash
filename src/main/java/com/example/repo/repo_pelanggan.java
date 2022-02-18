package com.example.repo;

import com.example.model.pelanggan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface repo_pelanggan extends JpaRepository<pelanggan,String>
{

  
}
