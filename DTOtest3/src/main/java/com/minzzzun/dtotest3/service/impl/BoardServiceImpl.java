package com.minzzzun.dtotest3.service.impl;

import com.minzzzun.dtotest3.domain.Board;
import com.minzzzun.dtotest3.dto.BoardDto;
import com.minzzzun.dtotest3.dto.DefaultDto;
import com.minzzzun.dtotest3.mapper.BoardMapper;
import com.minzzzun.dtotest3.repository.BoardRepository;
import com.minzzzun.dtotest3.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    public BoardServiceImpl(BoardRepository boardRepository, BoardMapper boardMapper) {
        this.boardRepository = boardRepository;
        this.boardMapper = boardMapper;
    }

    @Override
    public DefaultDto.CreateResDto create(BoardDto.CreateReqDto param) {
        return boardRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(BoardDto.UpdateReqDto param) {
        Board board = boardRepository.findById(param.getId()).orElse(null);
        if(board == null){
            throw new RuntimeException("no data");
        }
        if(param.getDeleted() !=null){board.setDeleted(param.getDeleted());}
        if(param.getTitle() !=null){board.setTitle(param.getTitle());}
        if(param.getContent() !=null){board.setContent(param.getContent());}
        if(param.getAuthor() !=null){board.setAuthor(param.getAuthor());}

        boardRepository.save(board);
    }

    @Override
    public void delete(DefaultDto.DeleteReqDto param) {
        update(BoardDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    @Override
    public List<BoardDto.DetailResDto> list(BoardDto.ListReqDto param) {
//        List<Board> list = boardRepository.findAll();
//        List<BoardDto.DetailResDto> newList = new ArrayList<>();
//        for (Board each : list){
//            newList.add(detail(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
//        }
        return detailList(boardMapper.list(param));
    }

    public List<BoardDto.DetailResDto> detailList(List<BoardDto.DetailResDto> list){
        List<BoardDto.DetailResDto> newList = new ArrayList<>();
        for(BoardDto.DetailResDto each : list){
            newList.add(detail(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return newList;
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(BoardDto.PagedListReqDto param) {
        Integer perpage = param.getPerpage(); // 한번에 볼 글 갯수
        if(perpage == null || perpage < 1){
            perpage = 10;
        }
        if(perpage > 100){
            perpage = 100;
        }
        param.setPerpage(perpage);

        int listsize = boardMapper.pagedListCount(param); // 총 글 갯수 가져오기
        int totalpage = listsize / perpage;
        if(listsize % perpage > 0){
            totalpage++;
        }

        Integer callpage = param.getCallpage();
        if(callpage == null || callpage < 1){
            callpage = 1;
        }
        if(callpage > totalpage){
            callpage = totalpage;
        }
        param.setCallpage(callpage);

        /*
        1페이지일때 -> 0
        2페이지일때 -> (2-1) * perpage
        * */
        int offset = (callpage -1 ) * perpage;
        param.setOffset(offset);

        List<BoardDto.DetailResDto> list = boardMapper.pagedList(param);
        return DefaultDto.PagedListResDto.builder()
                        .totalpage(totalpage)
                        .callpage(callpage)
                .perpage(perpage)
                .listsize(listsize)
                .list(detailList(list))
                        .build();
    }

    @Override
    public BoardDto.DetailResDto detail(DefaultDto.DetailReqDto param) {
//        Board board = boardRepository.findById(param.getId()).orElseThrow(()-> new RuntimeException("no data"));
//        BoardDto.DetailResDto res = BoardDto.DetailResDto.builder()
//                .id(param.getId())
//                .deleted(board.getDeleted())
//                .title(board.getTitle())
//                .content(board.getContent())
//                .author(board.getAuthor())
//                .countread(board.getCountread())
//                .build();
        BoardDto.DetailResDto board = boardMapper.detail(param.getId());
        return board;
    }
}
