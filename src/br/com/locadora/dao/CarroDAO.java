package br.com.locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.conn.LocadoraDataSource;
import br.com.locadora.model.Carro;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarroDAO {

    private LocadoraDataSource dataSource = new LocadoraDataSource();
    
    public Carro listaCodCarro(String placa){
        try(Connection conn = dataSource.getConnection()){
            PreparedStatement ps = conn.prepareStatement("select * from carro where placa = ?");
            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();
            
            Carro car = null;
            while(rs.next()){
                car = new Carro();
                car.setPlaca(rs.getString("placa"));
                car.setMarca(rs.getString("marca"));
                car.setAno(rs.getString("ano"));
                car.setModelo(rs.getString("modelo"));
                car.setSituacao(rs.getString("situacao"));       
            }
        
            return car;
        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
