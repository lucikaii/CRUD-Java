package br.senai.sp.jandira.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String server, banco, user, password;
    public Connection conexao;
    public Conexao(){
        this.server = "Localhost";
        this.banco = "db_empresa";
        this.user = "root";
        this.password = "bcd127";

    }

    public void connectDriver() {
        try {
            this.conexao = DriverManager.getConnection("jdbc:mysql://" + this.server + "/" + this.banco, this.user, this.password);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Connection getConnection(){
        connectDriver();
        return conexao;
    }
}
