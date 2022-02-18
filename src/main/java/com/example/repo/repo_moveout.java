package com.example.repo;

import com.example.model.moveout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo_moveout extends JpaRepository<moveout,String>
{
    String Move="select  tgl_moveout as tanngal, sum(total) from moveout group by  month(tgl_moveout), QUARTER(tgl_moveout)  order by tgl_moveout asc";
    @Modifying
    @Query(value =Move ,nativeQuery = true)
    List findMove();
}
