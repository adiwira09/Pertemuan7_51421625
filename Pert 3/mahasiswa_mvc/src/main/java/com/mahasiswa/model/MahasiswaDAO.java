package com.mahasiswa.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaDAO {
    private Connection connection;
    
    public MahasiswaDAO(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahasiswa_mvc", "root", "");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean checkConnection(){
        try{
            if(connection != null && !connection.isClosed()){
                return true; //koneksi berhasil
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
   
    public void addMahasiswa(ModelMahasiswa mahasiswa){
        String sql = "INSERT INTO mahasiswa_la (npm, nama, kelas, semester, ipk, domisili) VALUES (?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, mahasiswa.getNpm());
            pstmt.setString(2, mahasiswa.getNama());
            pstmt.setString(3, mahasiswa.getKelas());
            pstmt.setInt(4, mahasiswa.getSemester());
            pstmt.setFloat(5, mahasiswa.getIpk());
            pstmt.setString(6, mahasiswa.getDomisili());
            pstmt.executeUpdate(); 
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    public List<ModelMahasiswa> getAllMahasiswa(){
        List<ModelMahasiswa> mahasiswaList = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa_la";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
           while(rs.next()){
               mahasiswaList.add(new ModelMahasiswa(
                       rs.getInt("id"),
                       rs.getString("npm"),
                       rs.getString("nama"),
                       rs.getString("kelas"),
                       rs.getInt("semester"),
                       rs.getFloat("ipk"),
                       rs.getString("domisili")
               ));
           }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return mahasiswaList;
    }
    
    public void updateMahasiswa(ModelMahasiswa mahasiswa){
        String sql = "UPDATE mahasiswa_la SET npm = ?, nama = ?, kelas = ?, semester = ?, ipk = ?, domisili = ? WHERE id = ?";
        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, mahasiswa.getNpm());
            pstmt.setString(2, mahasiswa.getNama());
            pstmt.setString(3, mahasiswa.getKelas());
            pstmt.setInt(4, mahasiswa.getSemester());
            pstmt.setFloat(5, mahasiswa.getIpk());
            pstmt.setInt(6, mahasiswa.getId()); 
            pstmt.setString(7, mahasiswa.getDomisili());
            pstmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void deleteMahasiswa(int id){
        String sql = "DELETE FROM mahasiswa_la WHERE id = ?";
        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    // Method untuk menutup koneksi database
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}