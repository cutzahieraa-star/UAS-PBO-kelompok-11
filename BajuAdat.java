package rental;

/** Barang kategori baju adat dengan tarif sewa harian biasa. */
public class BajuAdat extends Barang {
    private String asalDaerah;

    /**
     * Membuat barang baju adat.
     *
     * @param id ID barang
     * @param nama nama baju adat
     * @param ukuran ukuran baju
     * @param tarifHarian tarif sewa per hari
     * @param asalDaerah daerah asal busana
     */
    public BajuAdat(String id, String nama, String ukuran,
                    double tarifHarian, String asalDaerah) {
        super(id, nama, ukuran, tarifHarian);
        setAsalDaerah(asalDaerah);
    }

    /** @return daerah asal busana */
    public String getAsalDaerah() { return asalDaerah; }

    /** @param asalDaerah daerah asal busana */
    public void setAsalDaerah(String asalDaerah) {
        if (asalDaerah == null || asalDaerah.trim().isEmpty()) {
            throw new IllegalArgumentException("Asal daerah tidak boleh kosong.");
        }
        this.asalDaerah = asalDaerah.trim();
    }

    @Override
    public String getKategori() { return "Baju Adat"; }

    /**
     * Menghitung tarif harian dikalikan lama sewa.
     *
     * @param hari lama sewa
     * @return total biaya
     */
    @Override
    public double hitungBiaya(int hari) {
        validasiHari(hari);
        return getTarifHarian() * hari;
    }

    private void validasiHari(int hari) {
        if (hari <= 0) throw new IllegalArgumentException("Lama sewa harus lebih dari 0 hari.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Asal: " + asalDaerah + " | " + getKategori();
    }
}
