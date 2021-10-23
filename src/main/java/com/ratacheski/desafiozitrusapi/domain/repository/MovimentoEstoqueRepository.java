package com.ratacheski.desafiozitrusapi.domain.repository;

import com.ratacheski.desafiozitrusapi.domain.model.MovimentoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovimentoEstoqueRepository extends JpaRepository<MovimentoEstoque, UUID> {
}
