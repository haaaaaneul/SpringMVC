package kr.ac.hansung.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Lecture;
import kr.ac.hansung.service.LectureService;

@Controller
public class LectureController {

	@Autowired
	private LectureService lectureService;//의존성 주입받음
	
	@RequestMapping("/creditbysemester") //학기별 학점 수
	public String showCreditBySemester(Model model) {
		List<Lecture> creditBySemesterList = lectureService.getSemesterList();

		for (int i = 0; i < creditBySemesterList.size(); i++) {
			creditBySemesterList.get(i).setCredit(lectureService.getCreditBySemester(
					creditBySemesterList.get(i).getYear(), creditBySemesterList.get(i).getSemester()));
		}

		model.addAttribute("lectures", creditBySemesterList);

		return "creditbysemester";
	}
	
	
	@RequestMapping("/lecturesbysemester") //학기별 수강한 강의 조회
	public String showLecturesBySmester(@RequestParam(value="year") String year, 
			@RequestParam(value="semester") String semester, Model model) {
		List<Lecture> lecturesBySemester = 
				lectureService.getLectureBySemester(Integer.parseInt(year), Integer.parseInt(semester));//
		model.addAttribute("lectures", lecturesBySemester);
		
		return "lecturesbysemester"; //
	}
	
	@RequestMapping("/creditbyclassification")
	public String showCreditByDivision(Model model) {

		List<Lecture> creditByClassifyList = lectureService.getClassificationList();
		
		for(int i=0; i<creditByClassifyList.size(); i++) {
			creditByClassifyList.get(i).setCredit(lectureService.getCreditByClassification(creditByClassifyList.get(i).getClassification()));
		}

		creditByClassifyList.add(new Lecture("총학점", lectureService.getTotalCredit()));

		model.addAttribute("lectures", creditByClassifyList);

		return "creditbyclassification";
	}
	

	
	@RequestMapping("/addlecture") //수강신청하는 페이지
	public String addLecture(Model model) {
		
		model.addAttribute("lecture", new Lecture()); 
		
		return "addlecture"; //addlecture.jsp실행에 넘김 
	}
	
	@RequestMapping("/addinglecture") //수강신청후 페이지
	public String doAdd(Model model, @Valid Lecture lecture, BindingResult result) { /*lecture객체가 만들어지고 사용자의 값들이 저장된다. == 데이터 바인딩*/
		/*@Vaild ==> 바인딩 받은 데이터 검증*/
		
		if(result.hasErrors()) { //검증 error 저장해서 콘솔에 출력 (검증할때 제약조건 필요--> Lecture.java 에 명시)
			System.out.println("====Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors) 
				System.out.println(error.getDefaultMessage());
			return "addlecture";
		}
		
		lectureService.insert(lecture); // controller가 service객체 부름
		
		return "addsuccess"; //addsuccess.jsp실행에 넘김 
	}
	
	@RequestMapping("/searchlecture") //수강신청조회 페이지
	public String searchLecture(Model model) {
		
		List<Lecture> addedLectureList = lectureService.getAddedLectures();

		model.addAttribute("lectures", addedLectureList);
		
		return "searchlecture"; 
	}
	
}
