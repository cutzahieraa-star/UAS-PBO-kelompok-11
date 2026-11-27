package rental;

 /**
  * Kelas abstrak yang menjadi dasar seluruh barang yang disewakan.
  * Menyimpan informasi umum barang dan menyediakan perhitungan biaya
  * yang diimplementasikan berbeda oleh setiap kategori.
  */
public abstract class Barang {
    private String id;
    private String nama;
    private String ukuran;
    private double tarifHarian;
    private boolean tersedia;

    /**
     * Membuat objek barang baru.
     *
     * @param id ID unik barang
     * @param nama nama barang
     * @param ukuran ukuran barang
     * @param tarifHarian tarif sewa per hari
     */
    public Barang(String id, String nama, String ukuran, double tarifHarian) {
        setId(id);
        setNama(nama);
        setUkuran(ukuran);
        setTarifHarian(tarifHarian);
        this.tersedia = true;
    }

    /** @return ID barang */
    public String getId() { return id; }

    /** @param id ID baru barang */
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID tidak boleh kosong.");
        }
        this.id = id.trim().toUpperCase();
    }

    /** @return nama barang */
    public String getNama() { return nama; }

    /** @param nama nama baru barang */
    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama barang tidak boleh kosong.");
        }
        this.nama = nama.trim();
    }

    /** @return ukuran barang */
    public String getUkuran() { return ukuran; }

    /** @param ukuran ukuran baru barang */
    public void setUkuran(String ukuran) {
        if (ukuran == null || ukuran.trim().isEmpty()) {
            throw new IllegalArgumentException("Ukuran tidak boleh kosong.");
        }
        this.ukuran = ukuran.trim();
    }

    /** @return tarif sewa per hari */
    public double getTarifHarian() { return tarifHarian; }

    /** @param tarifHarian tarif sewa per hari yang baru */
    public void setTarifHarian(double tarifHarian) {
        if (tarifHarian <= 0) {
            throw new IllegalArgumentException("Tarif harian harus lebih dari 0.");
        }
        this.tarifHarian = tarifHarian;
    }

    /** @return true jika barang tersedia untuk disewa */
    public boolean isTersedia() { return tersedia; }

    /** @param tersedia status ketersediaan barang */
    public void setTersedia(boolean tersedia) { this.tersedia = tersedia; }

    /** @return nama kategori barang */
    public abstract String getKategori();

    /**
     * Menghitung biaya sewa sesuai kategori barang.
     *
     * @param hari lama penyewaan dalam hari
     * @return total biaya sewa
     */
    public abstract double hitungBiaya(int hari);

    /**
     * Menghasilkan informasi barang untuk ditampilkan.
     *
     * @return teks informasi barang
     */
    @Override
    public String toString() {
        return String.format(
            "%-8s | %-25s | %-8s | Rp%,.0f/hari | %s",
            id, nama, ukuran, tarifHarian, tersedia ? "Tersedia" : "Sedang disewa"
        );
    }
}
