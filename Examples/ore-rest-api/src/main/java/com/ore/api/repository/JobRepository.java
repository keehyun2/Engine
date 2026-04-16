package com.ore.api.repository;

import com.ore.api.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * JPA Repository for Job entity.
 */
@Repository
public interface JobRepository extends JpaRepository<Job, String> {
    Optional<Job> findByStatus(String status);
}
