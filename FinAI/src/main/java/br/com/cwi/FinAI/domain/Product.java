package br.com.cwi.FinAI.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String category;

    private String technicalDescription;

    private String humanizedDescription;

    private String targetProfile;

    private String rules;

    private String rates;

    private Boolean active;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    @PrePersist
    public void prePersist() {
        this.updatedAt = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
        this.active = true;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
