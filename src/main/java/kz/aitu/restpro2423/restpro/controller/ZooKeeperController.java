package kz.aitu.restpro2423.restpro.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.aitu.restpro2423.restpro.DBConnection.DBConnectionZookeeper;
import kz.aitu.restpro2423.restpro.entities.ZooKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.sql.*;

@RestController
public class ZooKeeperController
{
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/get_zookeepers")
    public String getZooKeepers()
    {
        DBConnectionZookeeper db = new DBConnectionZookeeper();
        Connection con = null;
        ArrayList<ZooKeeper> zookeepers = new ArrayList<>();

        try
        {
            con = db.connect();
            zookeepers = db.getZookeepers(con);
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
            jsonData = objectMapper.writeValueAsString(zookeepers);
        }
        catch (JsonProcessingException e)
        {
            System.out.println("Error: " + e.toString());
        }
        return jsonData;
    }

    @GetMapping("/get_zookeeper_by_id")
    public String getZooKeeperById(@RequestParam int id)
    {
        DBConnectionZookeeper db = new DBConnectionZookeeper();
        Connection con = null;
        ZooKeeper zookeeper = new ZooKeeper();

        try
        {
            con = db.connect();
            zookeeper = db.getZooKeepersById(con, id);
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
            jsonData = objectMapper.writeValueAsString(zookeeper);
        }
        catch (JsonProcessingException e)
        {
            System.out.println("Error: " + e.toString());
        }
        return jsonData;
    }

    @GetMapping("/get_zookeepers_by_name")
    public String getZooKeepersByName(@RequestParam String name)
    {
        DBConnectionZookeeper db = new DBConnectionZookeeper();
        Connection con = null;
        ArrayList<ZooKeeper> zookeepers = new ArrayList<>();

        try
        {
            con = db.connect();
            zookeepers = db.getZooKeepersByName(con, name);
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
            jsonData = objectMapper.writeValueAsString(zookeepers);
        }
        catch (JsonProcessingException e)
        {
            System.out.println("Error: " + e.toString());
        }
        return jsonData;
    }

    @PostMapping("/addzookeeper")
    public String addZooKeeper(@RequestParam int id, @RequestParam String name, @RequestParam int age, @RequestParam int experience)
    {
        DBConnectionZookeeper db = new DBConnectionZookeeper();
        Connection con = null;
        ZooKeeper zookeeper = new ZooKeeper(id, name, age, experience);
        System.out.println(zookeeper);

        try
        {
            con = db.connect();
            db.addZooKeeper(con, zookeeper);
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
            jsonData = objectMapper.writeValueAsString(zookeeper);
        }
        catch (JsonProcessingException e)
        {
            System.out.println("Error: " + e.toString());
        }
        return jsonData;
    }

    @PostMapping("/update_zookeeper")
    public String updateZooKeeper(@RequestParam int id, @RequestParam String name, @RequestParam int age, @RequestParam int experience)
    {
        DBConnectionZookeeper db = new DBConnectionZookeeper();
        Connection con = null;
        ZooKeeper zookeeper = new ZooKeeper(id, name, age, experience);
        System.out.println(zookeeper);

        try
        {
            con = db.connect();
            zookeeper = db.updateZooKeeper(con, zookeeper, id);
        }
        catch (Exception e)
        {
            System.out.println("Error: "  + e.toString());
        }
        finally
        {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        String jsonData = null;
        try
        {
            jsonData = objectMapper.writeValueAsString(zookeeper);
        }
        catch (JsonProcessingException e)
        {
            System.out.println("Error: " + e.toString());
        }
        return jsonData;
    }

    @PostMapping("/delete_zookeeper")
    public String deleteZooKeeper(@RequestParam int id)
    {
        DBConnectionZookeeper db = new DBConnectionZookeeper();
        Connection con = null;
        ZooKeeper zookeeper = null;

        try
        {
            con = db.connect();
            zookeeper = db.getZooKeepersById(con, id);
            System.out.println("Deleting Zookeeper: " + zookeeper);
            db.deleteZooKeeper(con,zookeeper);
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
            jsonData = objectMapper.writeValueAsString(zookeeper);
        }
        catch (JsonProcessingException e)
        {
            System.out.println("Error: " + e.toString());
        }
        return jsonData;
    }
}