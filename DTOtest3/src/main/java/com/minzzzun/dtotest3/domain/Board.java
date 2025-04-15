package com.minzzzun.dtotest3.domain;


import com.minzzzun.dtotest3.dto.BoardDto;
import com.minzzzun.dtotest3.dto.DefaultDto;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Entity
public class Board extends AuditingFields{
    String title;
    String content;
    String author;
    Integer countread;

    protected Board(){};

    private Board(Boolean deleted, String title, String content, String author, Integer countread) {
        this.deleted = deleted;
        this.title = title;
        this.content = content;
        this.author = author;
        this.countread = countread;
    }

    public static Board of(String title, String content, String author){
        return new Board(false,title, content, author, 0);
    }


    public DefaultDto.CreateResDto toCreateResDto() { return DefaultDto.CreateResDto.builder().id(getId()).build();}
}
