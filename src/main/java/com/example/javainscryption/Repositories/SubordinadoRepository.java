package com.example.javainscryption.Repositories;

import com.example.javainscryption.Entities.Subordinado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubordinadoRepository extends JpaRepository<Subordinado, Long> {
}
