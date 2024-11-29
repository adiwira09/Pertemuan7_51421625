package com.mahasiswa.controller;

import com.mahasiswa.model.MahasiswaDAO;
import com.mahasiswa.model.ModelMahasiswa;
import java.util.List;

public class MahasiswaController {
    private MahasiswaDAO mahasiswaDAO;
    
    public MahasiswaController(MahasiswaDAO mahasiswaDAO){
        this.mahasiswaDAO = mahasiswaDAO;
    }
    
    public void displayMahasiswaList(List<ModelMahasiswa> mahasiswaList){
        if(mahasiswaList.isEmpty()){
            System.out.println("Tidak ada data mahasiswa");
        } else {
            System.out.println("");
            System.out.println("===========================");
            for(ModelMahasiswa m: mahasiswaList){
                System.out.println("ID          : " + m.getId());
                System.out.println("NPM         : " + m.getNpm());
                System.out.println("NAMA        : " + m.getNama());
                System.out.println("KELAS       : " + m.getKelas());
                System.out.println("SEMESTER    : " + m.getSemester());
                System.out.println("IPK         : " + m.getIpk());
                System.out.println("DOMISILI    : " + m.getDomisili());
                System.out.println("===========================");
            }
        }
    }
    
    
    public void displayMessage(String message){
        System.out.println(message);
    }
    
    
    
    public void checkDatabaseConnection(){
        boolean isConnected = mahasiswaDAO.checkConnection();
        if (isConnected){
            displayMessage("Koneksi ke db berhasil");
        } else{
            displayMessage("Koneksi DB Gagal");
        }
    }
    
    // READ ALL (Menampilkan semua mahasiswa)
    public void displayAllMahasiswa(){
        List<ModelMahasiswa> mahasiswaList = mahasiswaDAO.getAllMahasiswa();
        displayMahasiswaList(mahasiswaList);
    }
    
    public void addMahasiswa(String npm, String nama, String kelas, int semester, float ipk, String domisili){
        ModelMahasiswa mahasiswaBaru = new ModelMahasiswa(0, npm, nama, kelas, semester, ipk, domisili);
        System.out.println("Controller Data:   " + npm + nama + kelas + semester + ipk + domisili);
        System.out.println(mahasiswaBaru);
        mahasiswaDAO.addMahasiswa(mahasiswaBaru);
        displayMessage("Mahasiswa berhasil ditambahkan!");
    }
    
    public void updateMahasiswa(int id, String npm, String nama, String kelas, int semester, float ipk, String domisili){
        ModelMahasiswa mahasiswaBaru = new ModelMahasiswa(id, npm, nama, kelas, semester, ipk, domisili);
        mahasiswaDAO.updateMahasiswa(mahasiswaBaru);
        displayMessage("Mahasiswa berhasil diperbarui!");
    }
    
    public void deleteMahasiswa(int id){
        mahasiswaDAO.deleteMahasiswa(id);
        displayMessage("Mahasiswa Berhasil Dihapus!");
    }
    
    public void closeConnection() {
        mahasiswaDAO.closeConnection();
    }
}