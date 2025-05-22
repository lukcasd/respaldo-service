package com.perfulandia.respaldo_service.repository;

import com.perfulandia.respaldo_service.model.Respaldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespaldoRepository extends JpaRepository<Respaldo, Integer> {
}
