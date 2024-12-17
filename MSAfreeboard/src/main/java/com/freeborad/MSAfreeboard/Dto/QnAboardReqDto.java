package com.freeborad.MSAfreeboard.Dto;



import com.freeborad.MSAfreeboard.Entity.QnASecret;
import com.freeborad.MSAfreeboard.Entity.QnAstate;
import com.freeborad.MSAfreeboard.Entity.User;
import lombok.Data;


@Data
public class QnAboardReqDto {

    private String title;

    private String content;

    private String type;

    private QnAstate qnAstate;

    private QnASecret qnASecret;

    private String comment;

    private User commentuser;


}
