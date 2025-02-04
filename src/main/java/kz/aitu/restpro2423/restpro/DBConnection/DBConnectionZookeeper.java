package kz.aitu.restpro2423.restpro.DBConnection;

import kz.aitu.restpro2423.restpro.entities.ZooKeeper;

import java.util.ArrayList;
import java.sql.*;

public class DBConnectionZookeeper extends DBConnection
{
    public ArrayList<ZooKeeper> getZookeepers(Connection con) throws SQLException
    {
        String query = "select * from test.zookeeper";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<ZooKeeper> zookeepers = new ArrayList<>();

        while(rs.next())
        {
            ZooKeeper zookeeper = new ZooKeeper();
            zookeeper.setId(rs.getInt("id"));
            zookeeper.setName(rs.getString("name"));
            zookeeper.setAge(rs.getInt("age"));
            zookeeper.setExperience(rs.getInt("experience"));
            zookeepers.add(zookeeper);
        }

        st.close();
        return zookeepers;
    }

    public ZooKeeper getZooKeepersById(Connection con, int id) throws SQLException
    {
        String query = "select * from test.zookeeper where id = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        ZooKeeper zookeeper = new ZooKeeper();

        while(rs.next())
        {
            zookeeper.setId(id);
            zookeeper.setName(rs.getString("name"));
            zookeeper.setAge(rs.getInt("age"));
            zookeeper.setExperience(rs.getInt("experience"));
        }
        st.close();
        return zookeeper;
    }

    public ArrayList<ZooKeeper> getZooKeepersByName(Connection con, String name) throws SQLException
    {
        String query = "select * from test.zookeeper where name = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, name);
        ResultSet rs = st.executeQuery();
        ArrayList<ZooKeeper> zookeepers = new ArrayList<>();

        while(rs.next())
        {
            ZooKeeper zookeeper = new ZooKeeper();
            zookeeper.setId(rs.getInt("id"));
            zookeeper.setName(rs.getString("name"));
            zookeeper.setAge(rs.getInt("age"));
            zookeeper.setExperience(rs.getInt("experience"));
            zookeepers.add(zookeeper);
        }

        st.close();
        return zookeepers;
    }

    public ZooKeeper addZooKeeper(Connection con, ZooKeeper zookeeper) throws SQLException
    {
        String query = "insert into test.zookeeper (id, name, age, experience) values (?, ?, ?, ?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, zookeeper.getId());
        st.setString(2, zookeeper.getName());
        st.setInt(3, zookeeper.getAge());
        st.setInt(4, zookeeper.getExperience());

        int success = st.executeUpdate();
        st.close();
        if(success > 0)
        {
            System.out.println("Zookeeper with name " + zookeeper.getName() + " created successfully.");
            return zookeeper;
        }
        return null;
    }

    public ZooKeeper updateZooKeeper(Connection con, ZooKeeper zookeeper, int id) throws SQLException
    {
        String query = "update test.zookeeper set name = ?, age = ?, experience = ? where id = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, zookeeper.getName());
        st.setInt(2, zookeeper.getAge());
        st.setInt(3, zookeeper.getExperience());
        st.setInt(4, zookeeper.getId());

        int success = st.executeUpdate();
        st.close();
        if(success > 0)
        {
            System.out.println("Zookeeper with id " + id + " updated successfully.");
            return zookeeper;
        }
        return null;
    }

    public ZooKeeper deleteZooKeeper(Connection con, ZooKeeper zookeeper) throws SQLException
    {
        String query = "delete from test.zookeeper where id = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, zookeeper.getId());

        int success = st.executeUpdate();
        st.close();
        if(success > 0)
        {
            System.out.println("Zookeeper with id " + zookeeper.getId() + " deleted successfully.");
            return zookeeper;
        }
        return null;
    }
}
