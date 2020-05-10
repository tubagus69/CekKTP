
package id.ac.bismillah_ktp.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("tps")
    @Expose
    private String tps;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("tempat_lahir")
    @Expose
    private String tempatLahir;
    @SerializedName("jenis_kelamin")
    @Expose
    private String jenisKelamin;
    @SerializedName("namaPropinsi")
    @Expose
    private String namaPropinsi;
    @SerializedName("namaKabko")
    @Expose
    private String namaKabko;
    @SerializedName("namaKec")
    @Expose
    private String namaKec;
    @SerializedName("namaKel")
    @Expose
    private String namaKel;

    public String getTps() {
        return tps;
    }

    public void setTps(String tps) {
        this.tps = tps;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNamaPropinsi() {
        return namaPropinsi;
    }

    public void setNamaPropinsi(String namaPropinsi) {
        this.namaPropinsi = namaPropinsi;
    }

    public String getNamaKabko() {
        return namaKabko;
    }

    public void setNamaKabko(String namaKabko) {
        this.namaKabko = namaKabko;
    }

    public String getNamaKec() {
        return namaKec;
    }

    public void setNamaKec(String namaKec) {
        this.namaKec = namaKec;
    }

    public String getNamaKel() {
        return namaKel;
    }

    public void setNamaKel(String namaKel) {
        this.namaKel = namaKel;
    }

}
