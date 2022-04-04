import java.util.ArrayList;
import java.util.List;

public interface edu {
    List<String> courses = new ArrayList<>();

    public void getEduAccount();
    public String setSchoolName(String placeHolder);
    public void getSchoolName();
    public void addCourse(String course);
    public void printCourses();
}
