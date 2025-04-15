package com.minzzzun.dtotest3.dto;

import com.minzzzun.dtotest3.domain.Board;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class BoardDto {
    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class CreateReqDto{
        String title;
        String content;
        String author;

        public Board toEntity(){
            return Board.of(getTitle(), getContent(), getAuthor());
        }
    }


    @Getter @Setter @SuperBuilder  @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto{
        String title;
        String content;
        String author;
        Integer countread;
    }



    @Getter @Setter @SuperBuilder  @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto extends DefaultDto.DetailResDto{
        String title;
        String content;
        String author;
        Integer countread;
    }

    @Getter @Setter @SuperBuilder  @NoArgsConstructor @AllArgsConstructor
    public static class ListReqDto extends DefaultDto.ListReqDto{
        String title;
    }

    @Getter @Setter @SuperBuilder  @NoArgsConstructor @AllArgsConstructor
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto{
        String title;
    }

}
