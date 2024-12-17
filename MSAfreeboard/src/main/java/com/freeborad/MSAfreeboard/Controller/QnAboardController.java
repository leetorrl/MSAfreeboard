package com.freeborad.MSAfreeboard.Controller;

import com.freeborad.MSAfreeboard.Dto.AnnounceReqDto;
import com.freeborad.MSAfreeboard.Dto.QnACommentReqDto;
import com.freeborad.MSAfreeboard.Dto.QnAboardReqDto;
import com.freeborad.MSAfreeboard.Entity.Announce;
import com.freeborad.MSAfreeboard.Entity.QnAboard;
import com.freeborad.MSAfreeboard.Login.LoginUserDetails;
import com.freeborad.MSAfreeboard.Repository.QnAboardRepository;
import com.freeborad.MSAfreeboard.Response.AnnounceResponseDto;
import com.freeborad.MSAfreeboard.Response.AnnounceResponsePageDto;
import com.freeborad.MSAfreeboard.Response.QnAboardPageResponseDto;
import com.freeborad.MSAfreeboard.Response.QnAboardResponseDto;
import com.freeborad.MSAfreeboard.Service.QnAboardService;
import com.freeborad.MSAfreeboard.utility.PageUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("QnA")
@RequiredArgsConstructor
@CrossOrigin
public class QnAboardController {

    private final QnAboardRepository qnAboardRepository;
    private final QnAboardService qnAboardService;

    @GetMapping("/list")
    public ResponseEntity<QnAboardPageResponseDto> test(@AuthenticationPrincipal LoginUserDetails loginUserDetails,
                                               @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
                                               @RequestParam(name = "size", defaultValue = "10") int size) {
        if(loginUserDetails==null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        QnAboardPageResponseDto qnAboardPageResponseDto = qnAboardService.qnAstudentPage(PageUtil.getPageable(pageNum, size), loginUserDetails);

        return ResponseEntity.ok(qnAboardPageResponseDto);
    }

    @PostMapping("/save")
    public ResponseEntity<QnAboard> save(@AuthenticationPrincipal LoginUserDetails loginUserDetails, @Valid @RequestBody QnAboardReqDto qnAboardReqDto) {
        if(loginUserDetails==null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        QnAboard qnAboard = qnAboardService.save(loginUserDetails, qnAboardReqDto);
        return ResponseEntity.ok(qnAboard);
    }


    @GetMapping("view/{idx}")
    public ResponseEntity<QnAboardResponseDto> findOne(@PathVariable(name = "idx") long idx) {
        QnAboardResponseDto qnAboardResponseDto = qnAboardService.viewPage(idx);
        return ResponseEntity.ok(qnAboardResponseDto);
    }




    @PutMapping("/comment/{idx}")
    public ResponseEntity<QnAboard> addComment(@AuthenticationPrincipal LoginUserDetails loginUserDetails,
                                               @PathVariable(name = "idx") long idx,
                                               @Valid @RequestBody QnACommentReqDto commentReqDto) {
        if (loginUserDetails == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        QnAboard updatedQnAboard = qnAboardService.addComment(idx, loginUserDetails, commentReqDto);

        return ResponseEntity.ok(updatedQnAboard);
    }


}
