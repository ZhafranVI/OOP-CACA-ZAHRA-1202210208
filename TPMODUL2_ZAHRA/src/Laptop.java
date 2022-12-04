public class Laptop extends Perangkat {
    protected boolean webcam;
    
    public Laptop(String drive, int ram, float processor, boolean webcam) {
        super(drive, ram, processor);
        this.webcam = webcam;
    }

    public void informasi() {
        System.out.print("\nLaptop ini memiliki drive tipe " + this.drive + " dengan ram sebesar " + this.ram + " GB dan processor secepat " + this.processor + " Ghz. ");
        if(webcam == false) {
            System.out.print("Selain itu, laptop ini TIDAK memiliki Webcam \n");
        } else {
            System.out.print("Selain itu, laptop ini juga memiliki Webcam \n");
        }
    }

    public void bukaGame(String nama_game){
        System.out.println("Laptop berhasil membuka game " + nama_game);
    }

    public void kirimEmail(String email){
        System.out.println("Laptop berhasil mengirim Email ke " + email);
    }

    public void kirimEmail(String email1, String email2){
        System.out.println("Laptop berhasil mengirim Email ke " + email1 + " dan ke " + email2);
    }
}