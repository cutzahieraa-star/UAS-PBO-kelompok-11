package rental;

/** Barang kategori kostum karakter/cosplay dengan biaya perawatan tambahan. */
public class KostumKarakter extends Barang {
    private String asalKarakter;
    private double biayaPerawatan;

    /**
     * Membuat barang kostum karakter.
     *
     * @param id ID barang
     * @param nama nama kostum
     * @param ukuran ukuran kostum
     * @param tarifHarian tarif sewa per hari
     * @param asalKarakter nama karakter asal kostum
     * @param biayaPerawatan biaya cuci/perawatan
     */
    public KostumKarakter(String id, String nama, String ukuran,
                          double tarifHarian, String asalKarakter,
                          double biayaPerawatan) {
        super(id, nama, ukuran, tarifHarian);
        setAsalKarakter(asalKarakter);
        setBiayaPerawatan(biayaPerawatan);
    }

    /** @return nama karakter asal kostum */
    public String getAsalKarakter() { return asalKarakter; }

    /** @param asalKarakter nama karakter */
    public void setAsalKarakter(String asalKarakter) {
        if (asalKarakter == null || asalKarakter.trim().isEmpty()) {
            throw new IllegalArgumentException("Asal karakter tidak boleh kosong.");
        }
        this.asalKarakter = asalKarakter.trim();
    }

    /** @return biaya perawatan kostum */
    public double getBiayaPerawatan() { return biayaPerawatan; }

    /** @param biayaPerawatan biaya perawatan baru */
    public void setBiayaPerawatan(double biayaPerawatan) {
        if (biayaPerawatan < 0) {
            throw new IllegalArgumentException("Biaya perawatan tidak boleh negatif.");
        }
        this.biayaPerawatan = biayaPerawatan;
    }

    @Override
    public String getKategori() { return "Kostum Karakter/Cosplay"; }

    /**
     * Menghitung tarif harian dikalikan lama sewa ditambah biaya perawatan.
     *
     * @param hari lama sewa
     * @return total biaya
     */
    @Override
    public double hitungBiaya(int hari) {
        if (hari <= 0) throw new IllegalArgumentException("Lama sewa harus lebih dari 0 hari.");
        return (getTarifHarian() * hari) + biayaPerawatan;
    }

    @Override
    public String toString() {
        return super.toString() + " | Karakter: " + asalKarakter
            + " | Perawatan: Rp" + String.format("%,.0f", biayaPerawatan);
    }
}
