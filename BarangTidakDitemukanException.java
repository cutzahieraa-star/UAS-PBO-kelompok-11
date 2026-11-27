package rental;

/** Exception ketika barang dengan ID tertentu tidak ditemukan. */
public class BarangTidakDitemukanException extends Exception {
    /**
     * Membuat exception dengan pesan kesalahan.
     * @param pesan keterangan kesalahan
     */
    public BarangTidakDitemukanException(String pesan) {
        super(pesan);
    }
}
