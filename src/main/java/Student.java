
public class Student {

    private String name;
    private int age;
    private int rollNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public int getrollNo() {
        return rollNo;
    }

    public void setrollNo(int rollNo) {
        if (rollNo > 0) {
            this.rollNo = rollNo;
        }
    }
}