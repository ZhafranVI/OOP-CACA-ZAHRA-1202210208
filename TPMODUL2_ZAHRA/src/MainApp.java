public class MainApp {
    public static void main(String[] args) {
        
        Perangkat perangkat = new Perangkat("Adata", 2, (float) 1.80);
        Laptop laptop = new Laptop("Seagate", 8, (float) 2.40, true);
        Handphone handphone = new Handphone("Sandisk", 3, (float) 2.20, false);

        perangkat.informasi();
        
        laptop.informasi();
        laptop.bukaGame("Roblox");
        laptop.kirimEmail("zahrahafizhahm@student.telkomuniversity.ac.id");
        laptop.kirimEmail("zahrahafizhahm@gmail.com","zahra.si4502@gmail.com");

        handphone.informasi();
        handphone.telfon(627669962);
        handphone.kirimSMS(626793085);
        handphone.kirimSMS(629764627, 62356789);
    }
}