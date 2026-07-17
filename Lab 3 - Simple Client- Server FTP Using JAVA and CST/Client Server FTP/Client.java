/*Imported Required Libraries:
	We Import java.io.* and java.net.* libraries.
*/

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String args[]) {
        try {
            /*	Create the Client Socket:
-	        Used the Socket class to create a client socket 
            and connect to the server at the local host 
            on port 8000.
            */
            Socket s=new Socket("localhost",8000);

            /* then we used a FileOutputStream 
            to write the received file data to a file 
            specified in the command line arguments. */

            InputStreamReader in=new InputStreamReader(s.getInputStream());
            FileOutputStream fout=new FileOutputStream(args[0]);

            int ch;
            while((ch=in.read())!=-1){
                fout.write(ch);
            }
            /*
          Closed the socket and file output stream 
          after the file transfer is complete
           */
            fout.close();
            in.close();
            s.close();

            System.out.println("File received successfully.");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}