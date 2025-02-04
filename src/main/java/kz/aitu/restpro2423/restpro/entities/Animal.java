package kz.aitu.restpro2423.restpro.entities;

public abstract class Animal {

    public Animal() {
    }


    public Animal(String name, int age, String habitat) {
        this.name = name;
        this.age = age;
        this.habitat = habitat;
    }

    private String name;
    private int age;
    private String habitat;


    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getHabitat() {
        return this.habitat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public abstract void makeSound();


    @Override
    public String toString() {
        return "Animal{name='" + name + "', age=" + age + ", habitat='" + habitat + "'}";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return age == animal.age && name.equals(animal.name) && habitat.equals(animal.habitat);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + habitat.hashCode();
        return result;
    }
}