package com.freeborad.MSAfreeboard.Repository;

import com.freeborad.MSAfreeboard.Entity.Announce;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AnnounceRepository extends JpaRepository<Announce, Long> {

    Page<Announce> findByLecture_Idx(Long lectureidx, Pageable pageable);
    Page<Announce> findByLecture_IdxIsNull(Pageable pageable);

    @Query("SELECT a FROM Announce a WHERE a.lecture.idx = :lectureidx OR a.lecture.idx IS NULL")
    Page<Announce> findByLectureIdxOrNull(@Param("lectureidx") Long lectureidx, Pageable pageable);
}