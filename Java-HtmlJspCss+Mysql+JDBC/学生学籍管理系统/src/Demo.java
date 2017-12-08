import com.dal.student.StudentVO;
import com.dal.teacher.TeacherVO;
import com.logic.*;

public class Demo{
	public static void main(String[] args){
		String ID="1";
		String password="1";
		String userType = new String("student");
		//上述模拟，实际上是网页传入的参数
		
		UserFactory userFactory = new UserFactory();
		User user = userFactory.getUser(userType);
		StudentVO studentVO = null;
		TeacherVO teacherVO = null;
		if(user instanceof Student){
			studentVO =(StudentVO) user.login(ID, password);
		}
		System.out.println(studentVO.getID()+" "+studentVO.getName()+" "+studentVO.getPassword());
		
		
	}
}
