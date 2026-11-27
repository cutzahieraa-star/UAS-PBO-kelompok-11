import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kelas turunan dari {@code Akun} yang merepresentasikan pelanggan/penyewa busana.
 * Mengelola interaksi penyewa mulai dari melihat katalog barang, mengisi keranjang sewa,
 * melakukan proses checkout transaksi, hingga melihat riwayat sewa yang disetujui admin.
 *
 * @author Anggota 2
 * @version 1.0
 */
public class Penyewa extends Akun {
    private String nama;
    private String noTelp;
    private KeranjangSewa keranjang;
    private ArrayList<Transaksi> riwayat;

    /**
     * Konstruktor untuk membuat akun Penyewa baru.
     *
     * @param id       ID unik penyewa
     * @param username nama pengguna untuk login penyewa
     * @param password kata sandi untuk login penyewa
     * @param nama     nama lengkap penyewa
     * @param noTelp   nomor telepon aktif penyewa
     */
    public Penyewa(String id, String username, String password, String nama, String noTelp) {
        super(id, username, password);
        this.nama = nama;
        this.noTelp = noTelp;
        this.keranjang = new KeranjangSewa();
        this.riwayat = new ArrayList<>();
    }

    /**
     * Mengambil nama lengkap penyewa.
     *
     * @return nama penyewa
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengambil nomor telepon penyewa.
     *
     * @return nomor telepon penyewa
     */
    public String getNoTelp() {
        return noTelp;
    }

    /**
     * Menampilkan daftar seluruh barang yang
