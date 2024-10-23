package com.example.javainscryption.Repositories;

import com.example.javainscryption.Entities.Sello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface SelloRepository extends JpaRepository<Sello, Long> {
}
