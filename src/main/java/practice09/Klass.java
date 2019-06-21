package practice09;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Klass {

    public static final Klass noClass = new Klass() {
        @Override
        public int getNumber() {
            throw new RuntimeException("no class not have number");
        }

        @Override
        public String getDisplayName() {
            return "No Class";
        }
    };

    private final int number;
    private final Set<Student> member;

    private Student leader;

    private Klass() {
        this.number = 0;
        this.member = new HashSet<>();
    }

    public Klass(int number) {
        this.number = number;
        this.member = new HashSet<>();
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return "Class " + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return number == klass.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public void assignLeader(Student student) {
        if (this.member.contains(student)) {
            this.leader = student;
        } else {
            System.out.println("It is not one of us.");
        }
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student student) {
        this.member.add(student);
    }
}
