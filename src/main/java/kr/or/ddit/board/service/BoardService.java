package kr.or.ddit.board.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public class BoardService implements BoardServiceInf{

	@Override
	public List<BoardVo> getBoardList() {
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		
		//db에서 조회가 되었다고 가정하고 임의의 값을 리턴
		boardList.add(new BoardVo("첫번째 글입니다.","첫번째 내용입니다.", "brown", "곰", new Date()));
		boardList.add(new BoardVo("두번째 글입니다.","두번째 내용입니다.", "sally", "여우", new Date()));
		boardList.add(new BoardVo("세번째 글입니다.","세번째 내용입니다.", "cony", "강아지", new Date()));
		boardList.add(new BoardVo("네번째 글입니다.","네번째 내용입니다.","james", "오리", new Date()));
		boardList.add(new BoardVo("다섯번째 글입니다.","다섯번째 내용입니다.", "tom", "토끼", new Date()));
		
		return boardList;
	}

}
