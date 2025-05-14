package com.teechhelp.inventario.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionTest {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://aws-0-us-east-2.pooler.supabase.com:6543/postgres";
        String username = "postgres.qcezfxgazncaqynjuodc";
        String password = "Emivargas1308";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Conexión a Supabase exitosa.");
            conn.close();
        } catch (Exception e) {
            System.out.println("❌ Error al conectar con Supabase:");
            e.printStackTrace();
        }
    }
}
