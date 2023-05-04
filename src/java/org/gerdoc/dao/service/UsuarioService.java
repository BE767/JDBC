/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.gerdoc.dao.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.gerdoc.dao.Usuario;

/**
 *
 * @author Evelyn
 */
public class UsuarioService  extends Conexion<Usuario>
{
    public List<Usuario> getUsuarioList() 
    {
        List<Usuario> UsuarioList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Usuario usuario = null;

        try 
        {
            connection = getConnection();
            if (connection == null) 
            {
                return null;
            }
            statement = connection.createStatement();
            if (statement == null) {
                return null;
            }
            resultSet = statement.executeQuery("SELECT * FROM ROL");
            if (resultSet == null) 
            {
                return null;
            }
            UsuarioList = new ArrayList<>();
            while (resultSet.next()) 
            {
                usuario = new Usuario();
                usuario.setNombre(resultSet.getString(1));
                usuario.setApellidoP(resultSet.getString(2));
                usuario.setApellidoM(resultSet.getString(3));
                usuario.setEdad(resultSet.getInt(4));
                usuario.setFecha(resultSet.getDate(5));
                UsuarioList.add(usuario);
            }
            resultSet.close();
            closeConnection(connection);
            return UsuarioList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
}
