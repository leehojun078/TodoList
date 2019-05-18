package kr.ac.hojun.cse.model;

import java.util.Date;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Post {
	private int id;

	@NotEmpty(message = "제목을 입력하세요.")
	private String title;

	private String priority;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@FutureOrPresent(message = "미래 날짜를 입력하세요.")
	private Date deadline;
	
	private String state;

	@NotEmpty(message = "내용을 입력하세요.")
	private String description;

}
