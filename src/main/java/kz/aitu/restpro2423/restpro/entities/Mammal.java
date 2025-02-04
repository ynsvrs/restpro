package kz.aitu.restpro2423.restpro.entities;

public class Mammal extends Animal {
    private boolean hasFur;

    public Mammal(String name, int age, String habitat, boolean hasFur) {
        super(name, age, habitat);
        this.hasFur = hasFur;
    }
    public boolean hasFur() {
        return hasFur;
    }
    public void setHasFur(boolean hasFur) {
        this.hasFur = hasFur;
    }
    @Override
    public void makeSound() {
        System.out.println("Mammal makes a mammal sound");
    }


    @Override
    public String toString() {
        return "Mammal{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", habitat='" + getHabitat() + '\'' +
                ", hasFur=" + hasFur +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Mammal mammal = (Mammal) o;

        return hasFur == mammal.hasFur;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (hasFur ? 1 : 0);
        return result;
    }
}