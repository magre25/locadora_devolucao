package br.com.locadora.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JOptionPane;

import br.com.locadora.conn.LocadoraDataSource;
import br.com.locadora.model.Carro;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.Reserva;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservaDAO {

    private LocadoraDataSource dataSource = new LocadoraDataSource();
    
    /*public List<Reserva> listarReserva(){
        List<Reserva> lista = new ArrayList<>();
        try(Connection conn = dataSource.getConnection()){
           PreparedStatement ps = conn.prepareStatement("select * from reserva");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String cpf = rs.getString("cpf_cliente");
                String placa = rs.getString("placa");
                Reserva reserva = new Reserva();
                reserva.setCodReserva(rs.getInt("cod_reserva"));
                reserva.setDataRetirada(rs.getDate("data_prev_ret"));
                reserva.setDataDevolucao(rs.getDate("data_prev_dev"));
                
                ClienteDAO daocliente = new ClienteDAO();
                Cliente cliente = daocliente.listaCodCliente(cpf);
                CarroDAO daocarro = new CarroDAO();
                Carro carro = daocarro.listaCodCarro(placa);
             
                reserva.setCliente(cliente);
                reserva.setCarro(carro);
                lista.add(reserva);
                
            }
            
            return lista;
            
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    */
    public List<Reserva> listaCodReserva(String cpf) {
         List<Reserva> lista = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from reserva where cpf_cliente = ?");
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            Reserva reserva = null;
            while (rs.next()) {
                reserva = new Reserva();
                reserva.setCodReserva(rs.getInt("cod_reserva"));
                reserva.setDataRetirada(rs.getDate("data_prev_ret"));
                reserva.setDataDevolucao(rs.getDate("data_prev_dev"));
                String codigo = rs.getString("cpf_cliente");
                ClienteDAO daocli = new ClienteDAO();
                Cliente cliente = daocli.listaCodCliente(cpf);
                reserva.setCliente(cliente);
                String placa = rs.getString("placa");
                CarroDAO daocarro = new CarroDAO();
                Carro carro = daocarro.listaCodCarro(placa);
                reserva.setCarro(carro);
                reserva.setSituacao(rs.getString("situacao"));
                lista.add(reserva);
            }

            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public Reserva ReservaItem(String cpf) {
         //List<Reserva> lista = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from reserva where cpf_cliente = ?");
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            Reserva reserva = null;
            while (rs.next()) {
                reserva = new Reserva();
                reserva.setCodReserva(rs.getInt("cod_reserva"));
                reserva.setDataRetirada(rs.getDate("data_prev_ret"));
                reserva.setDataDevolucao(rs.getDate("data_prev_dev"));
                String cpf_cod = rs.getString("cpf_cliente");
                ClienteDAO daocli = new ClienteDAO();
                Cliente cliente = daocli.listaCodCliente(cpf_cod);
                reserva.setCliente(cliente);
                String placa = rs.getString("placa");
                CarroDAO daocarro = new CarroDAO();
                Carro carro = daocarro.listaCodCarro(placa);
                 reserva.setSituacao(rs.getString("situacao"));
                reserva.setCarro(carro);
            }

            return reserva;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
}


