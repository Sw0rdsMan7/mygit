package javaprt12;

public class Student implements Comparable {
    private String name;
    private String number;
    private int year;

    Student(String number, String name, int year) {
        this.name = name;
        this.number = number;
        this.year = year;

    }

    public int compareTo(Object o) {
        if (!(o instanceof Student))
            throw new RuntimeException("不是Student对象");
        Student p = (Student) o;
        if (this.year > p.year)
            return 1;
        if (this.year == p.year) {
            return this.name.compareTo(p.name);
        }
        return -1;
    }


    public String toString() {
        return "学号: " + number + " " + "学年: " + year + " 姓名: " + name + "\n";
    }

}