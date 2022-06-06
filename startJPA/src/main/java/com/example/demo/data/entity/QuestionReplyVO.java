package com.example.demo.data.entity;

import java.util.List;

import lombok.Data;

@Data
public class QuestionReplyVO {

	private String frmOrderByVal;
	
	private List<QuestionReply> questionReplieList;
	
}
