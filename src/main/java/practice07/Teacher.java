package practice07;

public class Teacher extends Person {

    private final Klass klass;

    public Teacher(String name, int age) {
        super(name, age);
        this.klass = Klass.noClass;
    }

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Teacher. I teach " + this.klass.getDisplayName() + ".";
    }

    public String introduceWith(Student student) {
        if (student.getKlass().equals(this.klass)) {
            return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
        } else {
            return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
        }
    }
}
