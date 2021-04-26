/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LocadoraDataSource {

    private static final String URL_TEMPLATE = "jdbc:postgresql://localhost:5433/%s?user=%s&password=%s&useTimezone=true&serverTimezone=UTC";

    private Connection getConnection(String dbName, String username, String password) throws SQLException {
        String url = String.format(URL_TEMPLATE, dbName, username, password);
        return DriverManager.getConnection(url);
    }

    public Connection getConnection() throws SQLException {
        return getConnection("Locadora", "postgres", "proot"); // retornando a conexao estabelecida com o banco( metodo publico)
    }
}
