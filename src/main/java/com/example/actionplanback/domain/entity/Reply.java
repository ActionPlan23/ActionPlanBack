package com.example.actionplanback.domain.entity;


import com.example.actionplanback.domain.dto.ReplyRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 *
 *  2021-07-10 14:28 최왕규 작성
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

    @ManyToOne
    @JoinColumn(name="planId")
    private Plan plan;

    public Reply(ReplyRequestDto requestDto, Plan plan){
        this.replyContent = requestDto.getReplyContent();
        this.replyWriter = requestDto.getReplyWriter();
        this.replyPassword = requestDto.getReplyPassword();
        this.plan = plan;
    }
}
