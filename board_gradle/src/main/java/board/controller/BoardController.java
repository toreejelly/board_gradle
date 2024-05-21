package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import board.service.BoardService;
import board.vo.BoardVO;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;


//import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;   

@Log4j2
@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	
	//목록 조회
    @GetMapping("/list")
    public String list(Model model) {
		log.info("BoardController list()");
		
		model.addAttribute("list", boardService.getList());
		
		return "list";
    }
    
    //글쓰기 페이지
    @GetMapping("/contentWriteForm")
    public String contentWriteForm() {
    	log.info("BoardController contentWriteForm()");
    	
    	return "contentWriteForm";
    }
    
    //글쓰기 
    @PostMapping("/contentWrite")
    public ResponseEntity<String> contentWrite(@RequestBody BoardVO boardVO){
    	log.info("BoardController contentWrite()");
    	log.info("boardVO :" + boardVO);
    	
    	ResponseEntity<String> entity = null;
    	
    	try {
    		boardService.contentWrite(boardVO);
    		int boardId = boardService.boardId();
    		String strBoardId = Integer.toString(boardId);
			log.info("boardId : " + boardId);
			
			entity = new ResponseEntity<String>(strBoardId, HttpStatus.OK);
    	}catch(Exception e) {
    		e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    		
    	}//end
    	
    	return entity;
    }
    
    //글 조회
    @GetMapping("/board/{boardId}")
    public String contentViewForm(Model model, BoardVO boardVO) {
    	log.info("BoardController contentViewForm()");
    	log.info("boardVO :" + boardVO);
    	
    	int boardId = boardVO.getBoardId();
    	log.info("boardId :" + boardId);
    	
    	model.addAttribute("content", boardService.getContent(boardId));
    	
    	return "contentViewForm";
    	
    }
    
    //글 수정 페이지
    @GetMapping("/contentModifyForm/{boardId}")
    public String contentModifyForm(Model model, BoardVO boardVO) {
    	log.info("BoardController contentModifyForm()");
    	log.info("boardVO :" + boardVO);
    	
    	int boardId = boardVO.getBoardId();
    	log.info("boardId :" + boardId);
    	
		model.addAttribute("content", boardService.getContent(boardId));
    	
		return "contentModifyForm";
    }
    
    //글 수정
    @PutMapping("/board/{boardId}")
	public ResponseEntity<String> contentModify(@RequestBody BoardVO boardVO) {
   	log.info("BoardController contentModify()");
		log.info("boardVO : " + boardVO);

		ResponseEntity<String> entity = null;
		
		try {
			boardService.contentModify(boardVO);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}//end
		
		return entity;
		
    
    
    
     }
    

    

}


