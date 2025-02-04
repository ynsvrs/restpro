package kz.aitu.restpro2423.restpro.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.aitu.restpro2423.restpro.DBConnection.DBConnectionAnimal;
import kz.aitu.restpro2423.restpro.entities.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.sql.*;


@RestController
public class AnimalController
{
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/get_animal")
    public String getAnimal()
    {
        DBConnectionAnimal db = new DBConnectionAnimal();
        Connection con = null;
        ArrayList<Animal> animals = new ArrayList<>();

        try
        {
            con = db.connect();
            animals = db.getAnimals(con);
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.toString());
        }
        finally
        {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        String jsonData = null;
        try
        {
            jsonData = objectMapper.writeValueAsString(animals);
        }
        catch (JsonProcessingException e)
        {
            System.out.println("Error: " + e.toString());
        }
        return jsonData;
    }

    @GetMapping("/get_animal_by_id")
    public String getAnimalById(@RequestParam int id)
    {
        DBConnectionAnimal db = new DBConnectionAnimal();
        Connection con = null;
        Animal animal = new Animal();

        try
        {
            con = db.connect();
            animal = db.getAnimalById(con, id);
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.toString());
        }
        finally
        {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        String jsonData = null;
        try
        {
            jsonData = objectMapper.writeValueAsString(animal);
        }
        catch (JsonProcessingException e)
        {
            System.out.println("Error: " + e.toString());
        }
        return jsonData;
    }

    @GetMapping("/get_animal_by_name")
    public String getAnimalsByName(@RequestParam String name)
    {
        DBConnectionAnimal db = new DBConnectionAnimal();
        Connection con = null;
        ArrayList<Animal> animals = new ArrayList<>();

        try
        {
            con = db.connect();
            animals = db.getAnimalByName(con, name);
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.toString());
        }
        finally
        {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        String jsonData = null;
        try
        {
            jsonData = objectMapper.writeValueAsString(animals);
        }
        catch (JsonProcessingException e)
        {
            System.out.println("Error: " + e.toString());
        }
        return jsonData;
    }

    @PostMapping("/add_animal")
    public String addAnimal(@RequestParam int id, @RequestParam String name, @RequestParam int age, @RequestParam String habitat)
    {
        DBConnectionAnimal db = new DBConnectionAnimal();
        Connection con = null;
        Animal animal = new Animal(id, name, age, habitat);
        System.out.println(animal);

        try
        {
            con = db.connect();
            animal = db.addAnimal(con, animal);
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.toString());
        }
        finally
        {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        String jsonData = null;
        try
        {
            jsonData = objectMapper.writeValueAsString(animal);
        }
        catch (JsonProcessingException e)
        {
            System.out.println("Error: " + e.toString());
        }
        return jsonData;
    }

    @PostMapping("/update_animal")
    public String updateAnimal(@RequestParam int id, @RequestParam String name, @RequestParam int age, @RequestParam String habitat)
    {
        DBConnectionAnimal db = new DBConnectionAnimal();
        Connection con = null;
        Animal animal = new Animal(id, name, age, habitat);
        System.out.println(animal);

        try
        {
            con = db.connect();
            animal = db.updateAnimal(con, animal);
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.toString());
        }
        finally
        {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        String jsonData = null;
        try
        {
            jsonData = objectMapper.writeValueAsString(animal);
        }
        catch (JsonProcessingException e)
        {
            System.out.println("Error: " + e.toString());
        }
        return jsonData;
    }

    @PostMapping("/delete_animal")
    public String deleteAnimal(@RequestParam int id)
    {
        DBConnectionAnimal db = new DBConnectionAnimal();
        Connection con = null;
        Animal animal = null;

        try
        {
            con = db.connect();
            animal = db.getAnimalById(con, id);
            System.out.println("Deleting animal: " + animal);
            db.deleteAnimal(con, animal);
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.toString());
        }
        finally
        {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        String jsonData = null;
        try
        {
            jsonData = objectMapper.writeValueAsString(animal);
        }
        catch (JsonProcessingException e)
        {
            System.out.println("Error: " + e.toString());
        }
        return jsonData;
    }
}
