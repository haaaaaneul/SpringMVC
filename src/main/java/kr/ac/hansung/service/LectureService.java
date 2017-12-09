package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.LectureDAO;

import kr.ac.hansung.model.Lecture;

@Service
public class LectureService {

	@Autowired //외부에서 dao객체 주입
	private LectureDAO lectureDao;
	
	//학기 리스트
	public List<Lecture> getSemesterList() {
		return lectureDao.getSemesterList();
	}
	
	//학기별 강의 리스트
	public List<Lecture> getLectureBySemester(int year, int semester) {
		return lectureDao.getLectureBySemester(year, semester);
	}
	
	public int getCreditBySemester(int year, int semester) {
		return lectureDao.getCreditBySemester(year, semester);
	}
	
	public void insert(Lecture lecture) {
		lectureDao.insert(lecture); //service는 dao호출
	}

	public List<Lecture> getClassificationList() {
		return lectureDao.getClassificationList();
	}

	public int getTotalCredit() {
		return lectureDao.getTotalCredit();
	}

	public int getCreditByClassification(String classification) {
		return  lectureDao.getCreditByClassification(classification);
	}

	public List<Lecture> getAddedLectures() {
		return lectureDao.getAddedLectures();
	}
	
}
