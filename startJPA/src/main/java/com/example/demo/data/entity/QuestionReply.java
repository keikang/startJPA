package com.example.demo.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name = "QUESTION_REPLY")
@Data
public class QuestionReply implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RNUM")
	private Integer rnum;
	
	@Column(name = "CREATE_DT")
	@CreationTimestamp
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="Asia/Seoul")
	private Timestamp createDt;
	
	
	@Column(name = "CONSULT_ID")
	private String consultId;
	
	@Column(name = "QUESTION_TITLE")
	private String questionTitle;
	
	@Column(name = "QUESTION_CONTENT")
	private String questionContent;
	
	@Column(name = "REPLY_YN")
	private String replyYn;

	
}
