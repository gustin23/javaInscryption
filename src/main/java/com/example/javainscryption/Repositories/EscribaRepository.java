package com.example.javainscryption.Repositories;

import com.example.javainscryption.Entities.Escriba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscribaRepository extends JpaRepository<Escriba, Long> {
}
