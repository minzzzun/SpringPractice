package com.minzzzun.dtotest3.mapper;

import com.minzzzun.dtotest3.dto.BoardDto;

import java.util.List;

public interface BoardMapper {
    BoardDto.DetailResDto detail(Long id);
    List<BoardDto.DetailResDto> list(BoardDto.ListReqDto param);

    List<BoardDto.DetailResDto> pagedList(BoardDto.PagedListReqDto param);
    int pagedListCount(BoardDto.PagedListReqDto param);

}
