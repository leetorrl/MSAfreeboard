package com.freeborad.MSAfreeboard.Repository;

import com.freeborad.MSAfreeboard.Entity.Lecture;
import com.freeborad.MSAfreeboard.Entity.QnAboard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QnAboardRepository extends JpaRepository<QnAboard, Long> {


    Optional<QnAboard> findByIdx(Long idx);

}
