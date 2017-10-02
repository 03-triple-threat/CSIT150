package Lab4;

public class Employee implements Rules {

    private String name;
    private double salary;

    public Employee() {
        name = "New Employee";
        salary = 0;
    }

    public Employee(String inName, double inSalary){
        setName(inName);
        setSalary(inSalary);
    }

    //Setters for Name and Salary
    public void setName(String inName){name = inName;}

    public void setSalary(double inSalary){salary = inSalary;}

    /**
     * Get name accessor
     * @return
     */
    public  String getName(){
        return name;
    }

    /**
     * Get salary accessor
     * @return
     */
    public  double getSalary(){
        return salary;
    }

    /**
     * Employee info
     * @return
     */
    public String toString(){
        return "Employee " + name + " earns " + salary;
    }
}
