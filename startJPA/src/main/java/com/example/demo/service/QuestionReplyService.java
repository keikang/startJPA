package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.data.entity.QuestionReply;
import com.example.demo.data.entity.QuestionReplyVO;
import com.example.demo.repository.QuestionReplyRepository;

@Service
@Transactional
public class QuestionReplyService{
	
	@Autowired
	QuestionReplyRepository questionReplyRepository;
	
	public List<QuestionReply> questionReplyList(String frmOrderByVal){
//System.err.println("QuestionReplyService.java questionReplyList frmOrderByVal : "+param.get("frmOrderByVal"));
		Sort sort = Sort.by("createDt").descending();
		
		if(frmOrderByVal.equals("recent")) {
			sort = Sort.by("createDt").descending();
//return questionReplyRepository.findAll(Sort.by("createDt").descending());
		}else if(frmOrderByVal.equals("old")) {
			sort = Sort.by("createDt").ascending();
//return questionReplyRepository.findAll(Sort.by("createDt").ascending());
		}
		return questionReplyRepository.findAll(sort);
	}
	
	public Optional<QuestionReply> getQuestionReply(int rnum) {
		return questionReplyRepository.findById(rnum);
	}
	
	public QuestionReply updateQuestionVO(QuestionReply questionReply) {
		Optional<QuestionReply> resultObj = questionReplyRepository.findById(questionReply.getRnum());
		QuestionReply getObj ;
		if(resultObj.isPresent()) {
			getObj = resultObj.get();
//System.err.println("QuestionReplyService.java updateQuestionVO questionReply : "+questionReply);
			getObj.setQuestionContent(questionReply.getQuestionContent());
			getObj.setQuestionTitle(questionReply.getQuestionTitle());
			getObj.setReplyYn(questionReply.getReplyYn());
		}else {
			return questionReply;
		}
		
		return getObj;
	}
}
