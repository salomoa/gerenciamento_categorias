package com.bn.demo.repositories;

import com.bn.demo.models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
}
