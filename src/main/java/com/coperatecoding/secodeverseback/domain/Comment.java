package com.coperatecoding.secodeverseback.domain;

import com.coperatecoding.secodeverseback.domain.board.Board;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_pk", referencedColumnName = "pk")
    @JsonIgnore
    private Board board;

    //댓글을 단 사용자가 탈퇴하면 알수없음 처리 nullable
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_pk")
    @JsonIgnore
    private User user;

    @NotNull
    @CreationTimestamp
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @NotNull
    private String content;

    public static Comment makeComment(Board board, User user, String content) {
        Comment comment = new Comment();
        comment.createAt = LocalDateTime.now();
        comment.board = board;
        comment.user = user;
        comment.content = content;
        return comment;
    }

    public String convertDate(LocalDateTime createAt) {
        String convertedDate = createAt.format(DateTimeFormatter.ofPattern("yyyy. MM. dd. HH:mm"));
        return convertedDate;
    }

    public void modifyComment(String content){
        this.content = content;
    }




}
