package com.green.QnAboardservice.controller.vo;

import com.green.QnAboardservice.controller.jpa.QnASecret;
import com.green.QnAboardservice.controller.jpa.QnAstate;
import lombok.Data;

@Data
public class QnAboardReqDto {

    private String title;

    private String content;

    private String type;

    private QnAstate qnAstate;

    private QnASecret qnASecret;

//    private String comment;
//
//    private String commentuser;

}
