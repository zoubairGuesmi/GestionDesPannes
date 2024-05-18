package com.pannes.gestiondespannes.repositories;

import com.pannes.gestiondespannes.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByNom(String username);

    Page<User> findByNomContains(String kw, Pageable pageable);
}
