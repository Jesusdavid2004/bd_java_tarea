package com.ucc;

import com.ucc.model.Actor;
import com.ucc.repository.ActorRepository;
import com.ucc.repository.IRepository;
import com.ucc.connection.DatabaseConnetion;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection ignored = DatabaseConnetion.getInstanceConnection()) {

            IRepository repo = new ActorRepository();

            // CREATE (id manual para la demo)
            System.out.println("=== CREATE ===");
            Actor a = new Actor();
            a.setActor_id(9999);
            a.setFirst_name("PepitoCode2");
            a.setLast_name("PepitoCode2");
            repo.save(a);
            System.out.println("Inserted: " + a);

            // GET BY ID
            System.out.println("\n=== GET BY ID ===");
            System.out.println("Found: " + repo.findById(9999));

            // UPDATE
            System.out.println("\n=== UPDATE ===");
            a.setFirst_name("PepitoUpdated");
            a.setLast_name("PepitoUpdated");
            System.out.println("Rows updated: " + repo.update(a));
            System.out.println("After update: " + repo.findById(9999));

            // DELETE
            System.out.println("\n=== DELETE ===");
            System.out.println("Rows deleted: " + repo.delete(9999));

        } catch (Exception e) {
            System.out.println("Connection Fail: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
