/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mahasiswa.view;

import com.mahasiswa.controller.MahasiswaController;
import com.mahasiswa.model.MahasiswaDAO;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class MahasiswaView {
    public static void main(String[] args){
        MahasiswaDAO mahasiswaDAO = new MahasiswaDAO();
        MahasiswaController mahasiswaController = new MahasiswaController(mahasiswaDAO);
        
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        
        while(true){
            System.out.println("Menu: ");
            System.out.println("1. Tampilkan seluruh mhs ");
            System.out.println("2. Tambahkan mhs");
            System.out.println("3. Update mhs");
            System.out.println("4. Hapus mhs");
            System.out.println("5. Cek koneksi");
            System.out.println("6. Keluar");
            System.out.println("PILIH OPSI: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch(pilihan){
                case 1:
                    mahasiswaController.displayAllMahasiswa();
                    break;
                case 2:
                    System.out.println("Masukkan NPM: ");
                    String npm = scanner.next();
                    System.out.println("Masukkan Nama: ");
                    String nama = scanner.next();
                    System.out.println("Masukkan Kelas: ");
                    String kelas = scanner.next();
                    System.out.println("Masukkan Semester: ");
                    int semester = scanner.nextInt();
                    System.out.println("Masukkan IPK: ");
                    float ipk = scanner.nextFloat();
                    System.out.println("Masukkan Domisili: ");
                    String domisili = scanner.next();
                    
                    System.out.println(npm + nama + kelas + semester + ipk + domisili);
                    mahasiswaController.addMahasiswa(npm, nama, kelas, semester, ipk, domisili);
                    break;
                    
                case 3:
                    System.out.print("Masukkan ID mahasiswa: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.println("Masukkan NPM: ");
                    String npmBaru = scanner.next();
                    System.out.println("Masukkan Nama: ");
                    String namaBaru = scanner.next();
                    System.out.println("Masukkan Kelas: ");
                    String kelasBaru = scanner.next();
                    System.out.println("Masukkan Semester: ");
                    int semesterBaru = scanner.nextInt();
                    System.out.println("Masukkan IPK: ");
                    float ipkBaru = scanner.nextFloat();
                    System.out.println("Masukkan Domisili: ");
                    String domisiliBaru = scanner.next();
                    
                    System.out.println(npmBaru + namaBaru + semesterBaru + ipkBaru);
                    mahasiswaController.updateMahasiswa (id, npmBaru, namaBaru, kelasBaru, semesterBaru, ipkBaru, domisiliBaru);
                    break;
                case 4:
                    System.out.print("Masukkan ID mahasiswa: ");
                    int idHapus = scanner.nextInt();
                    mahasiswaController.deleteMahasiswa (idHapus);
                    break;
                case 5:
                    mahasiswaController.checkDatabaseConnection();
                    break;
                case 6:
                    mahasiswaController.closeConnection();
                    System.out.println("Program Selesai.");
                    return;
                default:
                    System.out.println("Input tidak valid");
            }
        }
    }
}
