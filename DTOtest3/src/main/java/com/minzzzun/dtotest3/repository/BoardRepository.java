package com.minzzzun.dtotest3.repository;

import com.minzzzun.dtotest3.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
