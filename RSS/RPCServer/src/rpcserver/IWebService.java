package rpcserver;

/**
 *
 * @author Voron
 */

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface IWebService
{
    @WebMethod
    public byte[] getGempaTerkini();
    @WebMethod
    public byte[] getCuacaIndonesia();
    @WebMethod
    public byte[] getAviationObservation();
    @WebMethod
    public byte[] getStasiun();
    @WebMethod
    public byte[] getKoordinatKota();
}
