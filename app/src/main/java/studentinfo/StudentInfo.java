package studentinfo;

public class StudentInfo {
    private final int id;
    private final String name;
    private final String grade;
    private final String dep; 

    public StudentInfo(int id, String name, String grade, String dep) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.dep = dep;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
    public String getDep() {
        return dep;
    }
    public StudentInfo getDetails(){
        return this;
    }
}