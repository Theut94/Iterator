public class Student {
    private String name;
    private String lastName;
    private int id;

    public Student(String name, String lastName, int id)
    {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Studentname=" + name
                 + " " + lastName +
                ", id=" + id
                ;
    }
}
