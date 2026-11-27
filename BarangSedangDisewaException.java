package rental;

/** Exception ketika operasi edit/hapus dilakukan pada barang yang sedang disewa. */
public class BarangSedangDisewaException extends Exception {
    /**
     * Membuat exception dengan pesan kesalahan.
     * @param pesan keterangan kesalahan
     */
    public BarangSedangDisewaException(String pesan) {
        super(pesan);
    }
}
