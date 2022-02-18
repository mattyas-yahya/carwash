package com.example.repo;

import com.example.model.OnHandStok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface repo_OnHandStok extends JpaRepository<OnHandStok,String>
{
  String Q4="SELECT id_on_hand_stok,id_asset,asset_code,asset_name,begin_balance,transfer,consume,adjustment,((begin_balance+transfer)-(consume+adjustment))as end_balance FROM on_hand_stok;";
  @Query(value =Q4 ,nativeQuery = true)
  List<OnHandStok> ListOnHandStok();

}
