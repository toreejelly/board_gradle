package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import board.service.BoardService;

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

}


