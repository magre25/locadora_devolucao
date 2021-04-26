package br.com.locadora.dao;

import br.com.locadora.conn.LocadoraDataSource;
import br.com.locadora.model.Devolucao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DevolucaoDAO{
    
    LocadoraDataSource dataSource = new LocadoraDataSource();
    
    public void salvar(Devolucao devolucao){
        try(Connection conn = dataSource.getConnection()){
            conn.setAutoCommit(false);
            
            try(PreparedStatement ps1 = conn.prepareStatement("select proc_devolucao(?)")){
                ps1.setString(1, devolucao.getCarro().getPlaca());
                ps1.execute();
            }catch(SQLException e){
                e.printStackTrace();
            }
            
            try(PreparedStatement ps = conn.prepareStatement("INSERT INTO devolucao(cpf_cliente, placa)"
                    + "values(?,?)")){
                ps.setString(1, devolucao.getCliente().getCpf());
                ps.setString(2, devolucao.getCarro().getPlaca());
                ps.executeUpdate();
                
                conn.commit();
            }catch(SQLException e){
                conn.rollback();
                e.printStackTrace();
            }
        
        } catch (SQLException ex) {
            
            Logger.getLogger(DevolucaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}