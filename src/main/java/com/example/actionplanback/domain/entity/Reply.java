package com.example.actionplanback.domain.entity;


import com.example.actionplanback.domain.dto.ReplyRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 2021-07-10 14:28 최왕규 작성
 */

@NoArgsConstructor
@Entity
@Getter
public class Reply extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long replyId;

    @Column(nullable = false)
    private String replyContent;

    @Column(nullable = false)
    private String replyPassword;

    @Column(nullable = false)
    private String replyWriter;

    // Fk 가지는곳을 ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planId")
    private Plan plan;

    public Reply(ReplyRequestDto requestDto, Plan plan) {
        checkEmptyReply(requestDto);

        this.replyContent = requestDto.getReplyContent();
        this.replyWriter = requestDto.getReplyWriter();
        this.replyPassword = requestDto.getReplyPassword();
        this.plan = plan;
    }

    // Reply 수정 by 2021-07-12-19:18 최민서
    public void update(ReplyRequestDto requestDto) {
        checkContent(requestDto);
        this.replyContent = requestDto.getReplyContent();
    }

    // 내용이 비었는지 확인 by 2021-07-12-19:18 최민서
    public void checkContent(ReplyRequestDto requestDto) {
        if (requestDto.getReplyContent() == null || requestDto.getReplyContent().isEmpty()) {
            throw new IllegalArgumentException("내용을 입력해주세요.");
        }
    }

    // 처음 Reply 작성시 빈필드가 있는지 확인 by 2021-07-12-19:18 최민서
    public void checkEmptyReply(ReplyRequestDto requestDto) {
        if (requestDto.getReplyPassword() == null || requestDto.getReplyPassword().isEmpty()) {
            throw new IllegalArgumentException("비밀번호를 입력해주세요.");
        }
        if (requestDto.getReplyWriter() == null || requestDto.getReplyWriter().isEmpty()) {
            throw new IllegalArgumentException("작성자를 입력해주세요.");
        }

        checkContent(requestDto);
    }
}
