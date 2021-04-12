import java.util.Arrays;
// Task A
public class Output {
    public static void main(String[] args){
        System.out.println("java.vm.version is " + System.getProperty("java.vm.version"));
        System.out.println("java.vm.vendor is " + System.getProperty("java.vm.vendor"));
        System.out.println("java.vm.name is " + System.getProperty("java.vm.name"));
        System.out.println("java.vm.specification.version is " + System.getProperty("java.vm.specification.version"));
        System.out.println("java.vm.specification.vendor is " + System.getProperty("java.vm.specification.vendor"));
        System.out.println("java.vm.specification.name is " + System.getProperty("java.vm.specification.name"));
        System.out.println("java.version is " +  System.getProperty("java.version"));
        System.out.println("java.vendor is " + System.getProperty("java.vendor"));
        System.out.println();

        // variables for some students
        Student student1 = new Student("Tim");
        student1.setDepartment("SPEA");

        Student student2 = new Student("Becky");
        student2.setDepartment("Kelly");

        Student student3 = new Student("Leeroy");
        student3.setDepartment("Robotics");

        //array containing the students
        Student[] stuArray = new Student[3];
        stuArray[0] = student1;
        stuArray[1] = student2;
        stuArray[2] = student3;
        for(int i = 0; i < stuArray.length; i++){
            System.out.println("Student " + (i + 1));
            stuArray[i].display();
            System.out.println();
        }

    }
    
}

class Student {
    //name, department are instance variables
    public String name = "Unknown";
    private String department = "Unknown";
    public Student(String name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDepartment() {
        return department;
    }
    public void display() {
        System.out.println("Student Information");
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }
}
