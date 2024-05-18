package board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import board.vo.BoardVO;

@Mapper
public interface BoardMapper {

	//목록 조회
	public List<BoardVO> getList();

}
