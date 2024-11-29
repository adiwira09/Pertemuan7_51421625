/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mahasiswa.model;

/**
 *
 * @author HP
 */
public class ModelMahasiswa {
    private int id;
    private String npm;
    private String nama;
    private String kelas;
    private int semester;
    private float ipk;
    private String domisili;
    
    public ModelMahasiswa(int id, String npm, String nama, String kelas, int semester, float ipk, String domisili){
        this.id = id;
        this.npm = npm;
        this.nama = nama;
        this.kelas = kelas;
        this.semester = semester;
        this.ipk = ipk;
        this.domisili = domisili;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public float getIpk() {
        return ipk;
    }

    public void setIpk(float ipk) {
        this.ipk = ipk;
    }
    
    public String getDomisili() {
        return domisili;
    }

    public void setDomisili(String domisili) {
        this.domisili = domisili;
    }
}
