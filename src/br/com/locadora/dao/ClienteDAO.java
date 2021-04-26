package br.com.locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.conn.LocadoraDataSource;
import br.com.locadora.model.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    private LocadoraDataSource dataSource = new LocadoraDataSource();

    public List<Cliente> listaCliente() {

        List<Cliente> lista = new ArrayList<>();
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Cliente ORDER BY nome");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getString("cpf_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                lista.add(cliente);
            }

            return lista;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
            // TODO: handle exception
        }

    }

    public Cliente listaCodCliente(String cpf) {

        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from cliente where cpf_cliente = ?");
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            Cliente cliente = null;
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCpf(rs.getString("cpf_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
            }

            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
