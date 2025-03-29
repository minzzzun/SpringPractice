package com.minzzzun.practicesave4week.repository;

import com.minzzzun.practicesave4week.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
}

