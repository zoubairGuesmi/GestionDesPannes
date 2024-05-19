package com.pannes.gestiondespannes.repositories;

import com.pannes.gestiondespannes.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByNom(String username);

    Page<Patient> findByNomContains(String kw, Pageable pageable);
}
