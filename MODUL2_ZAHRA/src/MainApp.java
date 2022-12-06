public class MainApp {
    public static void main(String[] args) throws Exception {
        TransportasiAir transportasi_air = new TransportasiAir(4, 20000);
        Sampan sampan = new Sampan(20, 50000, 2);
        Kapal kapal = new Kapal(50, 100000, "Diesel");

        transportasi_air.informasi();
        transportasi_air.berlayar();
        transportasi_air.berlabuh();

        sampan.informasi();
        sampan.berlayar();
        sampan.berlabuh();
        sampan.berlabuh(2);

        kapal.informasi();
        kapal.berlayar();
        kapal.berlayar(20);
        kapal.berlabuh();
    }
}
