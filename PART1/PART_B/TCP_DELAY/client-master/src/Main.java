import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        ConnectionToServer connectionToServer = new ConnectionToServer(ConnectionToServer.DEFAULT_SERVER_ADDRESS, ConnectionToServer.DEFAULT_SERVER_PORT);

        connectionToServer.Connect();

        /*
        Sends a message over SSL socket to the server and prints out the received message from the server
         */
        System.out.println(connectionToServer.SendForAnswer('1'));
        System.out.printf("begin: %d, end: %d, delay: %d nanosec\n", connectionToServer.in, connectionToServer.out, connectionToServer.out-connectionToServer.in);
        /*
        Disconnects from the SSL server
         */
        connectionToServer.Disconnect();


        connectionToServer.Connect();

        /*
        Sends a message over SSL socket to the server and prints out the received message from the server
         */
        System.out.println(connectionToServer.SendForAnswer('2'));

        /*
        Disconnects from the SSL server
         */
        connectionToServer.Disconnect();
        for(int i = 0; i<23; i++){
            connectionToServer.Connect();

            /*
            Sends a message over SSL socket to the server and prints out the received message from the server
             */
            System.out.println(connectionToServer.SendForAnswer('a'));
            if(i == 22){
                System.out.printf("begin: %d, end: %d, delay: %d nanosec\n", connectionToServer.in, connectionToServer.out, connectionToServer.out-connectionToServer.in);

            }
            /*
            Disconnects from the SSL server
             */
            connectionToServer.Disconnect(); 
        }
        }
        
    }
