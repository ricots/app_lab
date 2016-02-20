package com.acer.app_lab;

import java.sql.Time;
import java.util.Date;

/**
 * Created by ACER on 2016-01-31.
 */
public class Item {
    public String jdl,kegiatan,gambar,id_ruang, nama_ruang, hari, kegiatan_lab, prodi,jumlah_mahasiswa, npm, password;
    public int id_kegiatan;
    public Date tgl;
    public Time jam,selesai, jam_lab, selesai_lab;

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Item(String jdl, String kegiatan, String gambar, int id_kegiatan, Date tgl, Time jam, Time selesai,
                String id_ruang, String nama_ruang, String hari, String kegiatan_lab, String Prodi, String jumlah_mahasiswa
    , Time jam_lab, Time selesai_lab, String npm, String password){
        this.jdl = jdl;
        this.kegiatan = kegiatan;
        this.gambar = gambar;

        this.id_kegiatan = id_kegiatan;
        this.tgl = tgl;
        this.jam = jam;
        this.selesai = selesai;
        this.id_ruang = id_ruang;
        this.nama_ruang =nama_ruang;
        this.hari = hari;
        this.kegiatan_lab = kegiatan_lab;
        this.prodi = prodi;
        this.jumlah_mahasiswa = jumlah_mahasiswa;
        this.jam_lab = jam_lab;
        this.selesai_lab = selesai_lab;
        this.npm = npm;
    }

    public String getId_ruang() {
        return id_ruang;
    }

    public void setId_ruang(String id_ruang) {
        this.id_ruang = id_ruang;
    }

    public String getNama_ruang() {
        return nama_ruang;
    }

    public void setNama_ruang(String nama_ruang) {
        this.nama_ruang = nama_ruang;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getKegiatan_lab() {
        return kegiatan_lab;
    }

    public void setKegiatan_lab(String kegiatan_lab) {
        this.kegiatan_lab = kegiatan_lab;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getJumlah_mahasiswa() {
        return jumlah_mahasiswa;
    }

    public void setJumlah_mahasiswa(String jumlah_mahasiswa) {
        this.jumlah_mahasiswa = jumlah_mahasiswa;
    }

    public Time getJam_lab() {
        return jam_lab;
    }

    public void setJam_lab(Time jam_lab) {
        this.jam_lab = jam_lab;
    }

    public Time getSelesai_lab() {
        return selesai_lab;
    }

    public void setSelesai_lab(Time selesai_lab) {
        this.selesai_lab = selesai_lab;
    }

    public Item(){
    }


    public String getJdl() {
        return jdl;
    }

    public void setJdl(String jdl) {
        this.jdl = jdl;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public int getId_kegiatan() {
        return id_kegiatan;
    }

    public void setId_kegiatan(int id_kegiatan) {
        this.id_kegiatan = id_kegiatan;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public Time getJam() {
        return jam;
    }

    public void setJam(Time jam) {
        this.jam = jam;
    }

    public Time getSelesai() {
        return selesai;
    }

    public void setSelesai(Time selesai) {
        this.selesai = selesai;
    }
}
