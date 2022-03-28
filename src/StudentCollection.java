import java.util.ArrayList;
import java.util.Collections;

public class StudentCollection implements IContainer{

    private ArrayList<Student> listOfStudents;
    private ArrayList<Student> randList;

    public StudentCollection()
    {   listOfStudents = new ArrayList<>();
        listOfStudents.add(new Student("Hans", "Petersen", 1));
        listOfStudents.add(new Student("Karl", "Petersen", 2));
        listOfStudents.add(new Student("Peter", "Petersen", 3));
        listOfStudents.add(new Student("Balder", "Petersen", 4));

        randList = new ArrayList<>();
        randList.addAll(listOfStudents);
        Collections.shuffle(randList);
        }
    @Override
    public IIterator createIterator() {
        IIterator studentIterator = new IIterator() {
            private int s_position = 0;

            @Override
            public boolean hasNext() {
                if (s_position < listOfStudents.size())
                    return true;
                else
                    return false;
            }

            @Override
            public Student next() {
                if(this.hasNext())
                {
                    return listOfStudents.get(s_position++);
                }
                else
                    return null;
            }
        };
        return studentIterator;
    }

    public static void main(String[] args) {
        StudentCollection studentCollection = new StudentCollection();
        IIterator it= studentCollection.createIterator();
        while (it.hasNext())
        {
            System.out.println(it.next().toString());
        }

    }
/**
 * fra start til slut
   private int s_position = 0;
              @Override
              public boolean hasNext() {
                  if (s_position < listOfStudents.size())
                      return true;
                  else
                      return false;
              }

              @Override
              public Student next() {
                 if(this.hasNext())
                 {
                     System.out.println(listOfStudents.get(s_position).toString());
                     return listOfStudents.get(s_position++);
                 }
                 else
                     return null;
             }
 * Fra slut til start.
    @Override
    private int s_position = listOfStudents.size();
    public boolean hasNext() {
        if (s_position != -1)
            return true;
        else
            return false;
    }

    @Override
    public Student next() {
        if(this.hasNext())
        {
            System.out.println(listOfStudents.get(s_position).toString());
            return listOfStudents.get(s_position--);
        }
        else
            return null;
    }
 * Random iteration
     @Override
     public boolean hasNext() {
        if (s_position < randList.size())
            return true;
        else
            return false;
        }

    @Override
     public Student next() {
        if(this.hasNext())
        {
            System.out.println(randList.get(s_position).toString());
            return randList.get(s_position++);
        }
        else
            return null;
        }
 */
}
