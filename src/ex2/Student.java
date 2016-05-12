package ex2;

/**
 * Created by cuixiaohui on 16/5/12.
 */
@Entity(tablename = "Student")
public class Student {
    @Identity(columnName = "student_id",columnType = "integer",generator = "identity")
    private int id;
    @Property(columnName = "student_name",columnType = "string")
    private String name;
    @Property(columnName = "student_age",columnType = "integet")
    private int age;
    @Property(columnName = "student_no",columnType = "string")
    private int no;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
