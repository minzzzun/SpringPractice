package com.minzzzun.dtotest3.controller;


import com.minzzzun.dtotest3.domain.Board;
import com.minzzzun.dtotest3.dto.BoardDto;
import com.minzzzun.dtotest3.dto.DefaultDto;
import com.minzzzun.dtotest3.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/board")
@RestController
public class BoardRestController {

    final BoardService boardService;
    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }


    @PostMapping("")
    public DefaultDto.CreateResDto create(@RequestBody BoardDto.CreateReqDto params){
        return boardService.create(params);
    }

    @PutMapping("")
    public void update(@RequestBody BoardDto.UpdateReqDto params){
        boardService.update(params);
    }

    @DeleteMapping("")
    public void delete(@RequestBody DefaultDto.DeleteReqDto params){
        boardService.delete(params);
    }

    @GetMapping("/list")
    public List<BoardDto.DetailResDto> list(BoardDto.ListReqDto params) {
        return boardService.list(params);
    }

    @GetMapping("/pagedList")
    public DefaultDto.PagedListResDto pagedList(BoardDto.PagedListReqDto params) {
        return boardService.pagedList(params);
    }

    @GetMapping("/detail")
    public BoardDto.DetailResDto detail( DefaultDto.DetailReqDto params) {
        return boardService.detail(params);
    }
}
