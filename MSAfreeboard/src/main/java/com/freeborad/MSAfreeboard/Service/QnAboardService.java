package com.freeborad.MSAfreeboard.Service;

import com.freeborad.MSAfreeboard.Dto.AnnounceReqDto;
import com.freeborad.MSAfreeboard.Dto.QnAboardReqDto;
import com.freeborad.MSAfreeboard.Entity.Announce;
import com.freeborad.MSAfreeboard.Entity.QnAboard;
import com.freeborad.MSAfreeboard.Entity.User;
import com.freeborad.MSAfreeboard.Login.LoginUserDetails;
import com.freeborad.MSAfreeboard.Repository.QnAboardRepository;
import com.freeborad.MSAfreeboard.Repository.UserRepository;
import com.freeborad.MSAfreeboard.Response.AnnounceResponseDto;
import com.freeborad.MSAfreeboard.Response.AnnounceResponsePageDto;
import com.freeborad.MSAfreeboard.Response.QnAboardPageResponseDto;
import com.freeborad.MSAfreeboard.Response.QnAboardResponseDto;
import com.freeborad.MSAfreeboard.error.BizException;
import com.freeborad.MSAfreeboard.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QnAboardService {

    private final ModelMapper modelMapper;
    private final QnAboardRepository qnAboardRepository;
    private final UserRepository userRepository;

    public QnAboard save(LoginUserDetails loginUserDetails, QnAboardReqDto qnAboardReqDto) {

        User user = userRepository.findByIdx(loginUserDetails.getIdx()).orElseThrow(()->new BizException(ErrorCode.USER_NOT_FOUND));

        QnAboard qnAboard = modelMapper.map(qnAboardReqDto, QnAboard.class);
        qnAboard.setWdate(LocalDateTime.now());

        qnAboard.setUser(user);
        qnAboardRepository.save(qnAboard);
        return qnAboard;
    }


    public QnAboardPageResponseDto qnAstudentPage(Pageable pageable, LoginUserDetails loginUserDetails) {
//        long QnAboardIdx = userAndLectureRepository
//                .findByUser_IdxAndState(loginUserDetails.getIdx(), 1)
//                .orElseThrow(() -> new BizException(ErrorCode.LECTURE_NOT_FOUND))
//                .getLecture()
//                .getIdx();

        Page<QnAboard> page = qnAboardRepository.findByQnAboradIdxOrNull(QnAboardIdx, pageable);

        return mapToQuestionResponsePageDto(page);
    }



    private QnAboardPageResponseDto mapToQuestionResponsePageDto(Page<QnAboard> page) {

        List<QnAboardResponseDto> list = page
                .getContent()
                .stream()
                .map(qnAboard -> {
                    QnAboardResponseDto qnAboardResponseDto = modelMapper.map(qnAboard, QnAboardResponseDto.class);

                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm");
                    qnAboardResponseDto.setWdate(dateTimeFormatter.format(qnAboard.getWdate()));

                    qnAboardResponseDto.setUser(( qnAboard.getUser() != null) ?  qnAboard.getUser().getName() : "탈퇴한 회원");
//                    qnAboardResponseDto.setUser(( qnAboard.getUser()!=null) ?  qnAboard.getUser().getTitle() : "전체");

                    return  qnAboardResponseDto;
                }).toList();

        QnAboardPageResponseDto qnAboardResponsePageDto = modelMapper.map(page, QnAboardPageResponseDto.class);
        qnAboardResponsePageDto.setList(list);

        return qnAboardResponsePageDto;
    }


}
