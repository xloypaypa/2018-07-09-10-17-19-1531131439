package practice08;

import java.util.Objects;

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

    private Klass() {
        this.number = 0;
    }

    public Klass(int number) {
        this.number = number;
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
}
