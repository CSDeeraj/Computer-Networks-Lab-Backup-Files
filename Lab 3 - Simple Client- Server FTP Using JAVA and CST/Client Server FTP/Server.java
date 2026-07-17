import java.io.*;
import java.net.*;

public class Server {
    public static void main(String args[]) {
        try {
            /*  Used the ServerSocket class 
            to create a server socket on port 8000.
            */

            ServerSocket ss = new ServerSocket(8000);
            System.out.println("Server waiting...");

            /*-	Used the accept() method 
            to listen for and accept 
            client connection requests. */

            Socket s = ss.accept();
            System.out.println("Client Connected.");

            /*Then we used a FileInputStream 
            to read the file specified 
            in the command line arguments. */

             FileInputStream fin=new FileInputStream(args[0]);

             /*Now we used an OutputStreamWriter 
             to send the file data to the client. */
            
             OutputStreamWriter out=new OutputStreamWriter(s.getOutputStream());

            int ch;
            while((ch=fin.read())!=-1){
                out.write(ch);
            }

            out.flush();
            /*-	Closed the socket and file input stream 
            after the file transfer is complete. */
            fin.close();
            out.close();
            s.close();
            ss.close();

            System.out.println("File sent successfully.");
        }
        catch(Exception e){
            System.out.println(e);

        }
    }
}