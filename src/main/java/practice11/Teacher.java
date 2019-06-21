package practice11;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    private final List<Klass> classes;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        this.classes = new ArrayList<>();
    }

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = new ArrayList<>(classes);
        for (Klass klass : this.classes) {
            klass.appendTeacher(this);
        }
    }

    void handleStudentJoin(Student student, Klass klass) {
        System.out.println("I am " + this.getName() +". I know " + student.getName() +" has joined " + klass.getDisplayName() + ".");
    }

    void handleLeaderChange(Student leader, Klass klass) {
        System.out.println("I am " + this.getName() +". I know " + leader.getName() +" become Leader of " + klass.getDisplayName() + ".");
    }

    public List<Klass> getClasses() {
        return classes;
    }

    @Override
    public String introduce() {
        if (this.classes.isEmpty()) {
            return super.introduce() + " I am a Teacher. I teach No Class.";
        } else {
            StringBuilder classesNameList = new StringBuilder();
            for (int index = 0; index < this.classes.size(); index++) {
                classesNameList.append(this.classes.get(index).getNumber());
                if (index != this.classes.size() - 1) {
                    classesNameList.append(", ");
                }
            }
            return super.introduce() + " I am a Teacher. I teach Class " + classesNameList + ".";
        }
    }

    public String introduceWith(Student student) {
        if (this.isTeaching(student)) {
            return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
        } else {
            return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
        }
    }

    public boolean isTeaching(Student student) {
        for (Klass klass : this.classes) {
            if (klass.containsMember(student)) {
                return true;
            }
        }
        return false;
    }
}
