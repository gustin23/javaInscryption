package com.example.javainscryption.Repositories;

import com.example.javainscryption.Entities.Tribu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TribuRepository extends JpaRepository<Tribu, Long> {
}
