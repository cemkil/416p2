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
public class Main
{
    public final static String TLS_SERVER_ADDRESS = "localhost";
    public final static String MESSAGE_TO_TLS_SERVER = "hello from client";
    public final static int TLS_SERVER_PORT = 64044;

    public static void main(String[] args) throws Exception
    {

        SSLConnectToServer sslConnectToServer = new SSLConnectToServer(TLS_SERVER_ADDRESS, TLS_SERVER_PORT);

        sslConnectToServer.Connect();

        /*
        Sends a message over SSL socket to the server and prints out the received message from the server
         */
        System.out.println(sslConnectToServer.SendForAnswer('1'));
        System.out.printf("begin: %d, end: %d, delay: %d nanosec\n", sslConnectToServer.in, sslConnectToServer.out, sslConnectToServer.out-sslConnectToServer.in);
        /*
        Disconnects from the SSL server
         */
        sslConnectToServer.Disconnect();


        sslConnectToServer.Connect();

        /*
        Sends a message over SSL socket to the server and prints out the received message from the server
         */
        System.out.println(sslConnectToServer.SendForAnswer('2'));

        /*
        Disconnects from the SSL server
         */
        sslConnectToServer.Disconnect();
        for(int i = 0; i<23; i++){
            sslConnectToServer.Connect();

            /*
            Sends a message over SSL socket to the server and prints out the received message from the server
             */
            System.out.println(sslConnectToServer.SendForAnswer('a'));
            if(i == 22){
                System.out.printf("begin: %d, end: %d, delay: %d nanosec\n", sslConnectToServer.in, sslConnectToServer.out, sslConnectToServer.out-sslConnectToServer.in);

            }
            /*
            Disconnects from the SSL server
             */
            sslConnectToServer.Disconnect(); 
        }
    }
}
