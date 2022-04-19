package net.codejava.repository;

import net.codejava.entity.ServiceCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SCRepository extends JpaRepository<ServiceCenter, Long> {
}

