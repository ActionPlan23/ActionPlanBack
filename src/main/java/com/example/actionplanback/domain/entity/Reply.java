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
@Setter
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

    @Column(nullable = false)
    private Long planId; // 애는 db에서 plan_id로될거임

    public Reply(ReplyRequestDto requestDto, Long planId){
        this.replyContent = requestDto.getReplyContent();
        this.replyWriter = requestDto.getReplyWriter();
        this.replyPassword = requestDto.getReplyPassword();
        this.planId = planId;
    }
}
