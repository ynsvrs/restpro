package kz.aitu.restpro2423.restpro.entities;

public class Student {
    public Student(){

    }
    public Student(String name, int a){
        this.name = name;
        this.age = a;

    }

    private String name;
    private int age;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId (){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
