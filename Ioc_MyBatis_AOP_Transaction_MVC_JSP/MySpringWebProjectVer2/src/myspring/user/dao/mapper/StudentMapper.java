package myspring.user.dao.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import myspring.user.vo.CourseStatusVO;
import myspring.user.vo.CourseVO;
import myspring.user.vo.StudentVO;

@MyMapper
public interface StudentMapper {
	@ResultMap("studentResultMap")
	@Select("select * from student where stu_code=#{code}")
	StudentVO selectStudentByCode(@Param("code") int code);
	
//	List<StudentVO> selectStudentDept();
	StudentVO selectStudentDept(Integer stuCode);
//	List<StudentVO> selectStudentCourseStatus();
	StudentVO selectStudentCourseStatus(Integer stuCode);
	int insertStudent(StudentVO studentVO);
	int updateStudent(StudentVO studentVO);
	
	int insertCourseStatus(CourseStatusVO courseStatusVO);
	
	@ResultMap("courseResultMap")
	@Select("select * from course where course_code=#{code}")
	CourseVO selectCourseByCode(int code);

	List<CourseVO> selectCourse();
	int insertCourse(CourseVO course);
	
	List<StudentVO> selectStudentByName(String name);
	List<StudentVO> selectStudentByGradeOrDay(StudentVO student);
	
	
}

