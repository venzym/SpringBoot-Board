package com.prgrms.board.domain.post;

import com.prgrms.board.common.BaseEntity;
import com.prgrms.board.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "post")
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private String title;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    protected Post() {
    }

    @Builder
    public Post(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
}