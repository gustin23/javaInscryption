package com.example.javainscryption.Repositories;

import com.example.javainscryption.Entities.Acto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActoRepository extends JpaRepository<Acto, Long> {
}
