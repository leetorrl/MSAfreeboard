package com.freeborad.MSAfreeboard.Dto;



import com.freeborad.MSAfreeboard.Entity.QnASecret;
import com.freeborad.MSAfreeboard.Entity.QnAstate;
import lombok.Data;


@Data
public class QnAboardReqDto {

    private String title;

    private String content;

    private String type;

    private QnAstate qnAstate;

    private QnASecret qnASecret;
//    private QnAstate qnastate;

//    private Long user;

}
