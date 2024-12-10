package com.freeborad.ex01.Repository;

import com.freeborad.ex01.Entity.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FreeRepository extends JpaRepository<FreeBoard, Long> {

//   List<FreeBoard> findByallidx(String username);
}
