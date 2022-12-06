public class Perangkat {
    protected String drive;
    protected int ram;
    protected float processor;

    public Perangkat(String drive, int ram, float processor) {
        this.drive = drive;
        this.ram = ram;
        this.processor = processor;
    }

    public void informasi() {
        System.out.println("Perangkat tidak diketahui memiliki drive tipe " + this.drive + " dengan ram sebesar " + this.ram + " GB dan processor secepat " + this.processor + " Ghz");
    }
}