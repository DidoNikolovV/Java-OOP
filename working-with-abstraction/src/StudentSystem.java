import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentsInfo;

    public StudentSystem()
    {
        this.studentsInfo = new HashMap<>();
    }

    public Map<String, Student> getStudentsInfo() {
        return this.studentsInfo;
    }

    public void ParseCommand(String[]args)
    {
//        Scanner scanner = new Scanner(System.in);
//        String[] args = scanner.nextLine().split(" ");

        if (args[0].equals("Create"))
        {
            String name = args[1];
            int age = Integer.parseInt(args[2]);
            double grade =Double.parseDouble(args[3]);
            if (!studentsInfo.containsKey(name))
            {
                Student student = new Student(name, age, grade);
                studentsInfo.put(name,student);
            }
        }
        else if (args[0].equals("Show"))
        {
            var name = args[1];
            if (studentsInfo.containsKey(name))
            {
                Student student = studentsInfo.get(name);
                String format = student.toString();

                if (student.getGrade() >= 5.00)
                {
                    format += " Excellent student.";
                }
                else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50)
                {
                    format += " Average student.";
                }
                else
                {
                    format += " Very nice person.";
                }

                System.out.println(format);
            }
        }
    }
}
