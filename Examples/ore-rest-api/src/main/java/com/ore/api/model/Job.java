package com.ore.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * JPA Entity representing an ORE job.
 */
@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    private String id;

    @Column(nullable = false)
    private String jobType;

    @Column(nullable = false)
    private String template;

    @Column(nullable = false, length = 20)
    private String status = "queued";  // queued, running, completed, failed, cancelled

    @Column(nullable = false)
    private int progress = 0;

    @Lob
    @Column(nullable = false)
    private String requestJson;

    @Lob
    private String resultJson;

    @Lob
    private String errorMessage;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
