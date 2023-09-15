package com.example.l5_20180805.repository;


import com.example.l5_20180805.entity.Viajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViajesRepository extends JpaRepository<Viajes, Integer> {

}
