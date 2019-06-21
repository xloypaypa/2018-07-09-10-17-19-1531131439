package practice05;

public class Worker extends Person {
    public Worker(String name, int age) {
        super(name, age);
    }

    @Override
    public String introduce() {
        return "My name is " + this.getName() + ". I am " + this.getAge() + " years old. I am a Worker. I have a job.";
    }
}
