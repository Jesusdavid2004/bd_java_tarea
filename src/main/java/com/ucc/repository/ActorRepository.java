package com.ucc.repository;

import com.ucc.connection.DatabaseConnetion;
import com.ucc.model.Actor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorRepository implements IRepository {

    private Connection getConnection() throws SQLException {
        return DatabaseConnetion.getInstanceConnection();
    }

    // -------- Read all (given)
    @Override
    public List<Actor> findAll() throws SQLException {
        List<Actor> actors = new ArrayList<>();
        String sql = "SELECT actor_id, first_name, last_name FROM actor";
        try (Statement st = getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Actor a = new Actor();
                a.setActor_id(rs.getInt("actor_id"));
                a.setFirst_name(rs.getString("first_name"));
                a.setLast_name(rs.getString("last_name"));
                actors.add(a);
            }
        }
        return actors;
    }

    // -------- Create (given)
    @Override
    public Actor save(Actor actor) throws SQLException {
        String sql = "INSERT INTO actor(actor_id, first_name, last_name) VALUES (?,?,?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, actor.getActor_id());
            ps.setString(2, actor.getFirst_name());
            ps.setString(3, actor.getLast_name());
            ps.executeUpdate();
        }
        return actor;
    }

    // === TASK 1: GetById ===
    @Override
    public Actor findById(int id) throws SQLException {
        String sql = "SELECT actor_id, first_name, last_name FROM actor WHERE actor_id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                Actor a = new Actor();
                a.setActor_id(rs.getInt("actor_id"));
                a.setFirst_name(rs.getString("first_name"));
                a.setLast_name(rs.getString("last_name"));
                return a;
            }
        }
    }

    // === TASK 2: Update ===
    @Override
    public int update(Actor actor) throws SQLException {
        String sql = "UPDATE actor SET first_name = ?, last_name = ? WHERE actor_id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, actor.getFirst_name());
            ps.setString(2, actor.getLast_name());
            ps.setInt(3, actor.getActor_id());
            return ps.executeUpdate(); // 0 o 1
        }
    }

    // === TASK 3: Delete ===
    @Override
    public int delete(int id) throws SQLException {
        String sql = "DELETE FROM actor WHERE actor_id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate(); // 0 o 1
        }
    }
}
