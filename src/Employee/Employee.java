package Employee;
import Employee.Comparable;

public class Employee implements Comparable<Employee>{
    public String name;
    public int birth_month;
    public int ssn;
    public boolean married;

    Employee(){}

    public Employee(int ssn){
        this.ssn = ssn;
        this.name = "Kwon";
        this.birth_month = 3;
        this.married = true;
    }

    @Override
    public int compareTo(Employee other) {
        int result;
        if(this.equals(other)){
            result = 0;
        }else if(ssn < other.ssn){
            result = -1;
        }else{
            result = 1;
        }
        return result;
    }
}