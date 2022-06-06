package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.entity.Board;
import com.example.demo.data.entity.QuestionReply;
import com.example.demo.data.entity.QuestionReplyVO;
import com.example.demo.service.QuestionReplyService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/questionReply")
public class QuestionReplyController {
	
	@Autowired
	QuestionReplyService quesReplyService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<QuestionReplyVO> getQuestionReplyList(@RequestParam String frmOrderByVal){
		
		/*
		 * for (QuestionReply questionReply : quesReplyService.questionReplyList()) {
		 * System.err.println("QuestionReplyController : "+questionReply); }
		 */
		QuestionReplyVO questionReplyVO = new QuestionReplyVO();
System.err.println("QuestionReplyController.java getQuestionReplyList frmOrderByVal  : "+frmOrderByVal);		
		questionReplyVO.setQuestionReplieList(quesReplyService.questionReplyList(frmOrderByVal));
		
		return new ResponseEntity<QuestionReplyVO>(questionReplyVO, HttpStatus.OK) ;
	}
	
	@GetMapping(value = "/questionReply/{rnum}")
	public ResponseEntity<QuestionReply> getQuestionReply( @PathVariable(value = "rnum", required = true) int rnum){
		
		Optional<QuestionReply> resultObj = quesReplyService.getQuestionReply(rnum);
		if(resultObj.isPresent()) {
			return new ResponseEntity<QuestionReply>(resultObj.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<QuestionReply>(resultObj.get(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PutMapping(value = "/questionReply/{rnum}")
	public ResponseEntity<QuestionReply> updateQuestionVO( @PathVariable(value = "rnum", required = true) int rnum
														, @RequestBody QuestionReply questionReply){
//System.err.println("QuestionReplyController.java getQuestionReply rnum : "+rnum);
System.err.println("QuestionReplyController.java updateQuestionVO questionReply : "+questionReply);
		QuestionReply resultObj = quesReplyService.updateQuestionVO(questionReply);
		
		return new ResponseEntity<QuestionReply>(resultObj, HttpStatus.OK);
	}
	

	
	@RequestMapping(value = "/makeList", method = RequestMethod.GET)
	public List<Board> getMakeList(){
		Board board = new Board();
		board.setRnum(1);
		board.setTitle("吏덈Ц�젣紐�1");
		board.setContent("吏덈Ц�궡�슜1");
		List<Board> boardList = new ArrayList<Board>();
		boardList.add(board);
		
		return boardList;
	}
}
