package com.example.l5_20180805.repository;


import com.example.l5_20180805.entity.Lugares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LugaresRepository extends JpaRepository<Lugares, Integer> {

}