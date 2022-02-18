package com.example.repo;

import com.example.model.header_moveout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface repo_header_moveout extends JpaRepository<header_moveout,String>
{
    String Q3="update header_moveout set stat_transaction='Close' where id_header_moveout =?";
    @Modifying
    @Transactional
    @Query(value =Q3 ,nativeQuery = true)
    int ChangeStat(String id_spare_part);

    String Qx="SELECT * FROM cmms.header_moveout where stat_transaction = 'Close' ";
    @Query(value = Qx,nativeQuery = true)
    List<header_moveout> FindClose();

    String Q="SELECT * FROM cmms.header_moveout where stat_transaction = 'Open' ";
    @Query(value = Q,nativeQuery = true)
    List<header_moveout> FindOpen();
}
