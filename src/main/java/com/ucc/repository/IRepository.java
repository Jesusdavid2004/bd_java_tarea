package com.ucc.repository;

import com.ucc.model.Actor;
import java.sql.SQLException;
import java.util.List;

public interface IRepository {
    List<Actor> findAll() throws SQLException;  // ya lo tenías
    Actor save(Actor actor) throws SQLException; // ya lo tenías

    // === Tarea ===
    Actor findById(int id) throws SQLException;   // GetById
    int update(Actor actor) throws SQLException;  // Update (rows affected)
    int delete(int id) throws SQLException;       // Delete (rows affected)
}
