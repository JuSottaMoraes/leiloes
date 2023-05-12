/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author juliana
 */
public class ConectaDAO {

    Connection conn;

    public Connection conectar() {

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/leiloes", "root", "j18091979c");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return conn;
    }

    public Connection getConexao() {

        return conn;

    }
}
