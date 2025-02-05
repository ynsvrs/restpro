package kz.aitu.restpro2423.restpro.DBConnection;

import kz.aitu.restpro2423.restpro.entities.Animal;
import java.util.ArrayList;
import java.sql.*;

public class DBConnectionAnimal extends DBConnection
{
    public ArrayList<Animal> getAnimals(Connection con) throws SQLException
    {
        String query = "select * from test.animal";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Animal> animals = new ArrayList<>();

        while(rs.next())
        {
            Animal animal = new Animal();
            animal.setId(rs.getInt("id"));
            animal.setName(rs.getString("name"));
            animal.setAge(rs.getInt("age"));
            animal.setHabitat(rs.getString("habitat"));
            animals.add(animal);
        }

        st.close();
        return animals;
    }

    public Animal getAnimalById(Connection con, int id) throws SQLException
    {
        String query = "select * from test.animal where id = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        Animal animal = new Animal();

        while(rs.next())
        {
            animal.setId(id);
            animal.setName(rs.getString("name"));
            animal.setAge(rs.getInt("age"));
            animal.setHabitat(rs.getString("habitat"));
        }
        st.close();
        return animal;
    }

    public ArrayList<Animal> getAnimalByName(Connection con, String name) throws SQLException
    {
        String query = "select * from test.animal where name = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, name);
        ResultSet rs = st.executeQuery();
        ArrayList<Animal> animals = new ArrayList<>();

        while(rs.next())
        {
            Animal animal = new Animal();
            animal.setId(rs.getInt("id"));
            animal.setName(rs.getString("name"));
            animal.setAge(rs.getInt("age"));
            animal.setHabitat(rs.getString("habitat"));
            animals.add(animal);
        }

        st.close();
        return animals;
    }

    public Animal addAnimal(Connection con, Animal animal) throws SQLException
    {
        String query = "insert into test.animal (id, name, age, habitat) values (?, ?, ?, ?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, animal.getId());
        st.setString(2, animal.getName());
        st.setInt(3, animal.getAge());
        st.setString(4, animal.getHabitat());

        int success = st.executeUpdate();
        st.close();
        if (success > 0)
        {
            System.out.println("Animal with name " + animal.getName() + " created successfully.");
            return animal;
        }
        return null;
    }

    public Animal updateAnimal(Connection con, Animal animal) throws SQLException
    {
        String query = "update test.animal set name = ?, age = ?, habitat = ? where id = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, animal.getName());
        st.setInt(2, animal.getAge());
        st.setString(3, animal.getHabitat());
        st.setInt(4, animal.getId());

        int success = st.executeUpdate();
        st.close();
        if (success > 0)
        {
            System.out.println("Animal with name " + animal.getName() + " updated successfully.");
            return animal;
        }
        return null;
    }

    public Animal deleteAnimal(Connection con, Animal animal) throws SQLException
    {
        String query = "delete from test.animal where id = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, animal.getId());

        int success = st.executeUpdate();
        st.close();
        if (success > 0)
        {
            System.out.println("animal with id " + animal.getId() + " deleted successfully.");
            return new Animal();
        }
        return null;
    }
}
