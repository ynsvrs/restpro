package kz.aitu.restpro2423.restpro.entities;

import java.util.Arrays;

public class Zoo {

    public Zoo() {}

    public Zoo(String name, Animal[] animals) {
        this.name = name;
        this.animals = animals;
    }

    private String name;
    private Animal[] animals;

    public String getName() {
        return this.name;
    }

    public Animal[] getAnimals() {
        return this.animals;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    // Get available animals in the zoo
    public void getAvailableAnimals() {
        if (animals == null || animals.length == 0) {
            System.out.println("No animals available at " + this.name);
        } else {
            System.out.println("Available animals at " + this.name + ":");
            for (Animal animal : animals) {
                System.out.println(animal);
                System.out.println();  // Add a blank line for readability
            }
        }
    }

    // Override toString() for better object representation
    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", animals=" + Arrays.toString(animals) +
                '}';
    }

    // Override equals() for comparing Zoo objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zoo zoo = (Zoo) o;

        if (!name.equals(zoo.name)) return false;
        return Arrays.equals(animals, zoo.animals);
    }

    // Override hashCode() for generating a hash code for Zoo objects
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Arrays.hashCode(animals);
        return result;
    }
}

