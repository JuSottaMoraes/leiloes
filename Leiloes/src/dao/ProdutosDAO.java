        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bd.ConectaDAO;
import beans.ProdutosDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Juliana
 */
public class ProdutosDAO {
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public int salvar (ProdutosDTO func){
        int status;
        
        
        ConectaDAO bd = new ConectaDAO();
        bd.conectar();   
        
        try {
            prep = bd.getConexao().prepareStatement ("INSERT INTO  Produtos (nome, valor, status) values (?,?,?)");
            prep.setString(1, func.getNome());
            prep.setInt(2, func.getValor());
            prep.setString(3, func.getStatus());
            status = prep.executeUpdate();
            return status; //retornar 1 
           
            
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }
       
    }
     
     public List<ProdutosDTO> ListaProdutos() throws SQLException {
         
      ConectaDAO bd = new ConectaDAO();
        bd.conectar();

        String query = "select * from produtos";
        {
            ArrayList<ProdutosDTO> produtos;
            try ( PreparedStatement consulta = bd.getConexao().prepareStatement(query)) {
                ResultSet rs = consulta.executeQuery();
               List<ProdutosDTO> listagem = new ArrayList<>();
                while (rs.next()) {
                    ProdutosDTO prod = new  ProdutosDTO();
                    prod.setId(rs.getInt("id"));
                    prod.setNome(rs.getString("nome"));
                    prod.setValor(rs.getInt("valor"));
                    prod.setStatus(rs.getString("status"));
                    listagem.add(prod);
                }
                return listagem;

                }
            }
           
    }
}