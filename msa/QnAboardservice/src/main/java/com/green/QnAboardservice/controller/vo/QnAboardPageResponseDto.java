package com.green.QnAboardservice.controller.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QnAboardPageResponseDto {

    private List<QnAboardResponseDto> list;
    private long totalElements;
    private int totalPages;
    private int size;
}