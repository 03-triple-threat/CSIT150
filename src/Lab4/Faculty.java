package Lab4;

public class Faculty extends Employee {
    private String[] courses;

    public Faculty(){
        super(); //Called automatically
        courses = new String[4];
    }

    public Faculty(String inName, double inSalary, String[] inCourses){
        super(); //Called automatically
        setName(inName);
        setSalary(inSalary);
        setCourses(inCourses);
    }

    public String getName(){
        return "Professor " + super.getName();
    }

    public String[] getCourses(){
        String[] temp = new String[courses.length];
        for (int i = 0; i < courses.length; i++)
            temp[i] = courses[i];
        return temp;
    }

    public void setCourses(String[] inCourses){
        courses = new String[inCourses.length];
        for (int i = 0; i < inCourses.length; i++)
            courses[i] = inCourses[i];
    }

    public String toString(){
        return getName() + " earns " + getSalary();
    }
}
