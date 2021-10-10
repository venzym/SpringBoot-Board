package com.prgrms.board.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@EntityListeners(EnableJpaAuditing.class)
@MappedSuperclass
public class BaseEntity {
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    @CreatedDate
    private LocalDateTime createdAt;

    public void addCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
