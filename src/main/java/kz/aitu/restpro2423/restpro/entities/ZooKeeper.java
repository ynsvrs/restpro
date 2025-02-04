package kz.aitu.restpro2423.restpro.entities;

public class ZooKeeper {

    public ZooKeeper() {}

    public ZooKeeper(int id, String name, int age, int experience) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.experience = experience;
    }

    private String name;
    private int age;
    private int id;
    private int experience;


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId(){
        return id;
    }

    public int getExperience(){
        return experience;
    }


    public void setName(String name) {

        this.name = name;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setExperience(int experience){
        this.experience = experience;
    }


    public void isOlderThan(ZooKeeper otherZookeeper) {
        if (this.age > otherZookeeper.getAge()) {
            System.out.println(this.name + " is older than " + otherZookeeper.getName());
        } else {
            System.out.println(this.name + " is not older than " + otherZookeeper.getName());
        }
    }


    public void display() {
        System.out.println("Zookeeper name: " + name);
        System.out.println("Age: " + age);
    }
    @Override
    public String toString() {
        return "ZooKeeper{name='" + name + "', age=" + age + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZooKeeper zooKeeper = (ZooKeeper) o;

        if (age != zooKeeper.age) return false;
        return name.equals(zooKeeper.name);
    }
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }
}
