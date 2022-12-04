public class Handphone extends Perangkat {
    protected boolean fingerprint;
    
    public Handphone(String drive, int ram, float processor,boolean fingerprint) {
        super(drive,ram,processor);
        this.fingerprint = fingerprint;
    }

    public void informasi() {
        System.out.print("\nHandphone ini memiliki drive tipe " + this.drive + " dengan ram sebesar " + this.ram + " GB dan processor secepat " + this.processor +" Ghz. ");
        if(fingerprint == false) {
            System.out.print("Selain itu, handphone ini TIDAK memiliki Fingerprint \n");
        } else {
            System.out.print("Selain itu, handphone ini juga memiliki Fingerprint \n");
        }
    }

    public void telfon(int no_hp) {
        System.out.println("Handphoen berhasil menyambungkan telfon ke Nomor " + no_hp);
    }

    public void kirimSMS(int no_hp) {
        System.out.println("Handphone berhasil mengirim SMS ke Nomor " + no_hp);
    }

    public void kirimSMS(int no_hp1, int no_hp2) {
        System.out.println("Handphone berhasil mengirim SMS ke Nomor " + no_hp1 + " dan ke Nomor " + no_hp2);
    }
}