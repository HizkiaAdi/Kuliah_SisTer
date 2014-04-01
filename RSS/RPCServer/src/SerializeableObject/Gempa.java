package SerializeableObject;

/**
 *
 * @author Voron
 */

import java.io.Serializable;

public class Gempa implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private String Tanggal;
    private String Jam;
    private String Lintang;
    private String Bujur;
    private String Magnitude;
    private String Kedalaman;
    private String Wilayah;
    
    public Gempa()
    {
    }
    
    public Gempa(String Tanggal, String Jam, String Lintang, String Bujur, String Magnitude,
            String Kedalaman, String Wilayah)
    {
        this.Tanggal = Tanggal;
        this.Jam = Jam;
        this.Lintang = Lintang;
        this.Bujur = Bujur;
        this.Magnitude = Magnitude;
        this.Kedalaman = Kedalaman;
        this.Wilayah = Wilayah;
    }
    
    public String getTanggal() {
        return Tanggal;
    }
    
    public String getJam(){
        return Jam;
    }

    public String getLintang() {
        return Lintang;
    }

    public String getBujur() {
        return Bujur;
    }

    public String getMagnitude() {
        return Magnitude;
    }

    public String getKedalaman() {
        return Kedalaman;
    }

    public String getWilayah() {
        return Wilayah;
    }
    
    @Override
    public String toString()
    {
        return "Tanggal: " + getTanggal() + "\n" +
                "Jam: " + getJam() + "\n" +
                "Lintang: " + getLintang() + "\n" +
                "Bujur: " + getBujur() + "\n" +
                "Magnitude: " + getMagnitude() + "\n" +
                "Kedalaman: " + getKedalaman() + "\n" +
                "Wilayah: " + getWilayah();
    }
}
