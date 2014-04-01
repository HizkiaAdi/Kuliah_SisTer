package SerializeableObject;

/**
 *
 * @author Voron
 */

import java.io.Serializable;

public class Cuaca implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String Kota;
    private String Cuaca;
    private int SuhuMin;
    private int SuhuMax;
    private int KelembapanMin;
    private int KelembapanMax;
    
    public Cuaca(String Kota, String Cuaca, int SuhuMin, int SuhuMax,
            int KelembapanMin, int KelembapanMax)
    {
        this.Kota = Kota;
        this.Cuaca = Cuaca;
        this.SuhuMin = SuhuMin;
        this.SuhuMax = SuhuMax;
        this.KelembapanMin = KelembapanMin;
        this.KelembapanMax = KelembapanMax;
    }

    public String getKota() {
        return Kota;
    }

    public String getCuaca() {
        return Cuaca;
    }

    public int getSuhuMin() {
        return SuhuMin;
    }

    public int getSuhuMax() {
        return SuhuMax;
    }

    public int getKelembapanMin() {
        return KelembapanMin;
    }

    public int getKelembapanMax() {
        return KelembapanMax;
    }
    
    @Override
    public String toString()
    {
        return "Kota: " + getKota() + "\n" +
                "Cuaca: " + getCuaca() + "\n" +
                "SuhuMin: " + getSuhuMin() + "\n" +
                "SuhuMax: " + getSuhuMax() + "\n" +
                "KelembapanMin: " + getKelembapanMin() + "\n" +
                "KelembapanMax: " + getKelembapanMax();
    }
}
