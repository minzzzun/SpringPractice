package com.minzzzun.practicesave4week.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Notice {
    @Id Long id;
    String title;
    String content;
    String author;
}
