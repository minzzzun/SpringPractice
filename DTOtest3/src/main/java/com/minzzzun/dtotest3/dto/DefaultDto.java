package com.minzzzun.dtotest3.dto;

import com.minzzzun.dtotest3.domain.Board;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class DefaultDto {

    @Getter @Setter @SuperBuilder  @NoArgsConstructor @AllArgsConstructor
    public static class CreateResDto {
        Long id;
    }

    @Getter @Setter @SuperBuilder
    @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto {
        Long id;
        Boolean deleted;
    }

    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class DeleteReqDto {
        Long id;
    }

    @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class DetailReqDto {
        Long id;
    }

    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto {
        Long id;
        Boolean deleted;
    }

    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ListReqDto {
        Boolean deleted;
    }

    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class PagedListReqDto {
        Boolean deleted;

        Integer offset;
        Integer callpage;
        Integer perpage;
        String orderway;
        String orderby;
    }

    @Getter @Setter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class PagedListResDto {
        Integer listsize;
        Integer totalpage;
        Integer callpage;
        Integer perpage;
        Object list;

    }

}
