package com.minzzzun.dtotest3.service;


import com.minzzzun.dtotest3.dto.BoardDto;
import com.minzzzun.dtotest3.dto.DefaultDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    DefaultDto.CreateResDto create(BoardDto.CreateReqDto param);
    void update(BoardDto.UpdateReqDto param);
    void delete(DefaultDto.DeleteReqDto param);
    List<BoardDto.DetailResDto> list(BoardDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(BoardDto.PagedListReqDto param);
    BoardDto.DetailResDto detail(DefaultDto.DetailReqDto param);
}
