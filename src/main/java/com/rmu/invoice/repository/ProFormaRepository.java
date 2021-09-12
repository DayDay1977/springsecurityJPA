package com.rmu.invoice.repository;

import com.rmu.invoice.model.ProForma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProFormaRepository extends JpaRepository<ProForma, Long> {
}
