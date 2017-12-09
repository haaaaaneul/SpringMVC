package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor 
@ToString
public class Lecture {
	
	//총학점 넣기용 lecture생성자
	public Lecture(String classification, int credit) {
		this.classification = classification;
		this.credit = credit;
	}

	//@NotEmpty(message="The year cannot be empty")
	private int year;
	
	//@NotEmpty(message="The semester cannot be empty")
	private int semester;
	
	//@NotEmpty(message="The code cannot be empty")
	@Size(min=5, max=8, message="Text must be between 5 and 8 chars")
	private String code;
	
	//@NotEmpty(message="The classname cannot be empty")
	private String classname;
	
	//@NotEmpty(message="The classification cannot be empty")
	private String classification;
	
	//@NotEmpty(message="The credit cannot be empty")
	private int credit;

}
