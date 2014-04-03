package SerializeableObject;

/**
 *
 * @author Voron
 */

import java.io.Serializable;

public class Stasiun implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private String Kota;
    private String Stasiun;
    private String Tipe;
    private String Balai;
    private String Alamat;
    private String Telp;
    private String Fax;
    private String KepalaStasiun;
    private String NIP;
    private String Mail;
    private String Web;

    public Stasiun(String Kota, String Stasiun, String Tipe, String Balai, String Alamat, String Telp, String Fax, String KepalaStasiun, String NIP, String Mail, String Web) {
        this.Kota = Kota;
        this.Stasiun = Stasiun;
        this.Tipe = Tipe;
        this.Balai = Balai;
        this.Alamat = Alamat;
        this.Telp = Telp;
        this.Fax = Fax;
        this.KepalaStasiun = KepalaStasiun;
        this.NIP = NIP;
        this.Mail = Mail;
        this.Web = Web;
    }

    public String getKota() {
        return Kota;
    }

    public String getStasiun() {
        return Stasiun;
    }

    public String getTipe() {
        return Tipe;
    }

    public String getBalai() {
        return Balai;
    }

    public String getAlamat() {
        return Alamat;
    }

    public String getTelp() {
        return Telp;
    }

    public String getFax() {
        return Fax;
    }

    public String getKepalaStasiun() {
        return KepalaStasiun;
    }

    public String getNIP() {
        return NIP;
    }

    public String getMail() {
        return Mail;
    }

    public String getWeb() {
        return Web;
    }
    
    @Override
    public String toString()
    {
        return "Kota: " + getKota() + "\n" +
                "Stasiun: " + getStasiun() + "\n" +
                "Tipe: " + getTipe() + "\n" +
                "Balai: " + getBalai() + "\n" +
                "Alamat: " + getAlamat() + "\n" +
                "Telp: " + getTelp() + "\n" +
                "Fax: " + getFax() + "\n" +
                "Kepala stasiun: " + getKepalaStasiun() + "\n" +
                "NIP: " + getNIP() + "\n" +
                "Mail: " + getMail() + "\n" +
                "Web: " + getWeb();
    }
}
