package rental;

/** Barang kategori busana pengantin/pesta dengan biaya jasa fitting tambahan. */
public class BusanaPengantin extends Barang {
    private double biayaFitting;

    /**
     * Membuat barang busana pengantin.
     *
     * @param id ID barang
     * @param nama nama busana
     * @param ukuran ukuran busana
     * @param tarifHarian tarif sewa per hari
     * @param biayaFitting biaya jasa fitting/rias
     */
    public BusanaPengantin(String id, String nama, String ukuran,
                           double tarifHarian, double biayaFitting) {
        super(id, nama, ukuran, tarifHarian);
        setBiayaFitting(biayaFitting);
    }

    /** @return biaya fitting */
    public double getBiayaFitting() { return biayaFitting; }

    /** @param biayaFitting biaya fitting baru */
    public void setBiayaFitting(double biayaFitting) {
        if (biayaFitting < 0) {
            throw new IllegalArgumentException("Biaya fitting tidak boleh negatif.");
        }
        this.biayaFitting = biayaFitting;
    }

    @Override
    public String getKategori() { return "Busana Pengantin/Pesta"; }

    /**
     * Menghitung tarif harian dikalikan lama sewa ditambah biaya fitting.
     *
     * @param hari lama sewa
     * @return total biaya
     */
    @Override
    public double hitungBiaya(int hari) {
        if (hari <= 0) throw new IllegalArgumentException("Lama sewa harus lebih dari 0 hari.");
        return (getTarifHarian() * hari) + biayaFitting;
    }

    @Override
    public String toString() {
        return super.toString() + " | Biaya fitting: Rp"
            + String.format("%,.0f", biayaFitting);
    }
}
