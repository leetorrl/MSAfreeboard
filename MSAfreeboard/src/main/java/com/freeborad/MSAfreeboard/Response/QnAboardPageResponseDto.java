package com.freeborad.MSAfreeboard.Response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freeborad.MSAfreeboard.Entity.Announce;
import com.freeborad.MSAfreeboard.Entity.QnAboard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QnAboardPageResponseDto {

    @JsonIgnore
    private List<QnAboard> content;

    private List<QnAboardResponseDto> list;
    private long totalElements;
    private int totalPages;
    private int size;
}
