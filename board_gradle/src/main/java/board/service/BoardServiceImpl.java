package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.mapper.BoardMapper;
import board.vo.BoardVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	//목록 조회
	@Override
	public List<BoardVO> getList(){			
		log.info("BoardServiceImpl getList()");
		return mapper.getList();
	}
	
	//글 쓰기
	@Override
	public void contentWrite(BoardVO boardVO) {
		mapper.contentWrite(boardVO);
	}
	
	//최신 글번호
	@Override
	public int boardId() {
		return mapper.boardId();
	}
	
	//글 조회
	@Override
	public BoardVO getContent(int boardId) {
		return mapper.getContent(boardId);
	}
	
	//글 수정
	@Override
	public void contentModify(BoardVO boardVO) {
		mapper.contentModify(boardVO);
	}
	
	//글 삭제
	@Override
	public void contentDelete(int boardId) {
		mapper.contentDelete(boardId);
	}

}