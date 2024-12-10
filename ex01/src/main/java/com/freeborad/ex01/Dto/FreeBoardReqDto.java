package com.freeborad.ex01.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freeborad.ex01.Entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Data
public class FreeBoardReqDto {

    private Long idx;

    private String title;

    private String content;

//    private Long user_idx;

//    @Schema(hidden = true)
//    private LocalDate reg_date;
//    @Schema(hidden = true)
//    private LocalDate mod_date;
//    @Schema(hidden = true)
//    private int view_Count;


}
