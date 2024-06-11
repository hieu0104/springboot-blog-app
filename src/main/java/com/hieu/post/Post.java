package com.hieu.post;


import com.hieu.common.BaseEntity;
import com.hieu.like.Like;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Post  extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ElementCollection
    private Set<String> tags = new HashSet<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private Set<Like> likes = new HashSet<>();
}