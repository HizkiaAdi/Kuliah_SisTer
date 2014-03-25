/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wildclient;
/**
 *
 * @author Wildhan Ibrahim
 */
public class WildClient {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Client client = new Client("localhost", 1234);
        client.Start();
    }
}
