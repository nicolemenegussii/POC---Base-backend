package br.com.cwi.FinAI.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(name = "technical_description", nullable = false, columnDefinition = "TEXT")
    private String technicalDescription;

    @Column(name = "humanized_description", nullable = false, columnDefinition = "TEXT")
    private String humanizedDescription;

    @Column(name = "target_profile", nullable = false, columnDefinition = "TEXT")
    private String targetProfile;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String rules;

    @Column(columnDefinition = "TEXT")
    private String rates;

    @Column(nullable = false)
    @Builder.Default
    private Boolean active = true;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}