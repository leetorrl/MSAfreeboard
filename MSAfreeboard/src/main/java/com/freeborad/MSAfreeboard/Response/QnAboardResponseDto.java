package com.freeborad.MSAfreeboard.Response;


import com.freeborad.MSAfreeboard.Entity.QnASecret;
import com.freeborad.MSAfreeboard.Entity.QnAstate;
import com.freeborad.MSAfreeboard.Entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QnAboardResponseDto {

    private String title;
    private String content;
    private String type;
    private QnAstate qnastate;
    private QnASecret qnASecret;

    private String Wdate;
    private String user;
}
