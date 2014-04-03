package SerializeableObject;

/**
 *
 * @author Voron
 */

import java.io.Serializable;

public class Kota implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private String Kota;
    private float Lintang;
    private float Bujur;

    public Kota(String Kota, float Lintang, float Bujur) {
        this.Kota = Kota;
        this.Lintang = Lintang;
        this.Bujur = Bujur;
    }

    public String getKota() {
        return Kota;
    }

    public float getLintang() {
        return Lintang;
    }

    public float getBujur() {
        return Bujur;
    }
    
    @Override
    public String toString()
    {
        return "Kota: " + getKota() + "\n" +
                "Lintang: " + getLintang() + "\n" +
                "Bujur: " + getBujur();
    }
}
