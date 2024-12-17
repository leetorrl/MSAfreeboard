package com.green.QnAboardservice.controller;

import com.green.QnAboardservice.controller.Login.LoginUserDetails;
import com.green.QnAboardservice.controller.jpa.QnAboard;
import com.green.QnAboardservice.controller.vo.QnAboardReqDto;
import com.green.QnAboardservice.controller.vo.QnAboardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("QnA")
@RequiredArgsConstructor
@CrossOrigin
public class QnAController {

//    private final QnAboardRepository qnAboardRepository;
//    private final QnAboardService qnAboardService;

//    @GetMapping("/list")
//    public ResponseEntity<QnAboardPageResponseDto> test(@AuthenticationPrincipal LoginUserDetails loginUserDetails,
//                                                        @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
//                                                        @RequestParam(name = "size", defaultValue = "10") int size) {
//        if(loginUserDetails==null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//        QnAboardPageResponseDto qnAboardPageResponseDto = qnAboardService.qnAstudentPage(PageUtil.getPageable(pageNum, size), loginUserDetails);
//
//        return ResponseEntity.ok(qnAboardPageResponseDto);
//    }

//    @PostMapping("/save")
//    public ResponseEntity<QnAboard> save(@AuthenticationPrincipal LoginUserDetails loginUserDetails, @Valid @RequestBody QnAboardReqDto qnAboardReqDto) {
//        if(loginUserDetails==null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//        QnAboard qnAboard = qnAboardService.save(loginUserDetails, qnAboardReqDto);
//        return ResponseEntity.ok(qnAboard);
//    }


    @PostMapping("join")
    public ResponseEntity<QnAboardResponseDto> joinQnA(@RequestBody QnAboardReqDto qnAboardReqDto){

        return ResponseEntity.ok(null);
    }

    @GetMapping("login")
    public ResponseEntity<String> getQnA(){

        return ResponseEntity.ok(null);
    }

//    @GetMapping("view/{idx}")
//    public ResponseEntity<QnAboardResponseDto> findOne(@PathVariable(name = "idx") long idx) {
//        QnAboardResponseDto qnAboardResponseDto = qnAboardService.viewPage(idx);
//        return ResponseEntity.ok(qnAboardResponseDto);
//    }




//    @PutMapping("/comment/{idx}")
//    public ResponseEntity<QnAboard> addComment(@AuthenticationPrincipal LoginUserDetails loginUserDetails,
//                                               @PathVariable(name = "idx") long idx,
//                                               @Valid @RequestBody QnACommentReqDto commentReqDto) {
//        if (loginUserDetails == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//        QnAboard updatedQnAboard = qnAboardService.addComment(idx, loginUserDetails, commentReqDto);
//
//        return ResponseEntity.ok(updatedQnAboard);
//    }



}
