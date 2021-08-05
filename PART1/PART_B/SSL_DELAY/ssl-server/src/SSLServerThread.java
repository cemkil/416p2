import javax.net.ssl.SSLSocket;
import java.io.*;

/**
 * Copyright [2017] [Yahya Hassanzadeh-Nazarabadi]

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */


public class SSLServerThread extends Thread
{

    private final String SERVER_REPLY = "Hello Client";
    private SSLSocket sslSocket;
    private char[] c = new char[1];
    private BufferedReader is;
    private BufferedWriter os;
    protected int counter;
    private String toBeSend = "64044 ckilinc17 10042021";
    public SSLServerThread(SSLSocket s)
    {
        sslSocket = s;
    }

    public void run()
    {
        try
        {
            is = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            os = new BufferedWriter(new OutputStreamWriter(sslSocket.getOutputStream()));

        }
        catch (IOException e)
        {
            System.out.println("Server Thread. Run. IO error in server thread");
        }

        try
        {
            if (counter == 0 || counter == 1){
                is.read(c);
                if(c[0] == '1'){
                    os.write("64044 ckilinc17 10042021"); 
                    os.flush();
                }else{
                    os.write(toBeSend.charAt(counter-1)); 
                    os.flush(); 
                } 
            }
            else {
                if (counter<25){
                os.write(toBeSend.charAt(counter-1)); 
                os.flush();
            } 
            }
        
           


        }
        catch (IOException e)
        {
   
            System.out.println("Server Thread. Run. IO Error/ Client " + c + " terminated abruptly");
        }
        catch (NullPointerException e)
        {
  
            System.out.println("Server Thread. Run.Client " + c + " Closed");
        } finally
        {
            try
            {
                System.out.println("Closing the connection");
                if (is != null)
                {
                    is.close();
                    System.out.println(" Socket Input Stream Closed");
                }

                if (os != null)
                {
                    os.close();
                    System.out.println("Socket Out Closed");
                }
                if (sslSocket != null)
                {
                    sslSocket.close();
                    System.out.println("Socket Closed");
                }

            }
            catch (IOException ie)
            {
                System.out.println("Socket Close Error");
            }
        }//end finally
    }
}
