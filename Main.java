import java.awt.*;
import java.awt.event.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

import javax.swing.*;
import javax.swing.event.*;

//NETWORKING:
//6000 - MAIN COMMUNICATIONS
//6001 - INITIAL SERVER CONNECTION

public class Main implements ActionListener{
    //Properties
    boolean blnConnected = false;
    boolean blnHost;
    String strUsername;
    String strServerAddress;
    SuperSocketMaster HostSocket = new SuperSocketMaster(6000, this);
    SuperSocketMaster ClientSocket = new SuperSocketMaster(strServerAddress, 6000, this);

    //Methods
    public void actionPerformed(ActionEvent evt){
        

    }
    
    //Client Only Methods
    public void findServer(){
        try{
            // Create a DatagramSocket to listen on a specific port
            DatagramSocket inSocket = new DatagramSocket(6001);

            // Buffer to store incoming data
            byte[] buffer = new byte[1024];

            // Create a DatagramPacket to receive the incoming data
            DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);
            
            while(!blnConnected){
                //Receive the packet
                inSocket.receive(inPacket);

                //Extract and display the received message
                String receivedMessage = new String(inPacket.getData(), 0, inPacket.getLength());
                System.out.println(receivedMessage);
                try{
                    Thread.sleep(5000);
                }
                catch(InterruptedException e){

                }
            }

            // Close the socket
            inSocket.close();
        }
        catch(Exception e){

        }
    }

    //Server Only Methods
    public void broadcastIP(){
        try{
            //Create a DatagramSocket
            DatagramSocket outSocket = new DatagramSocket();
            
            //Set the broadcast address
            InetAddress broadcastAddress = InetAddress.getByName("255.255.255.255");

            //Message to be sent
            String message = HostSocket.getMyAddress();
            byte[] data = message.getBytes();

            //Create a DatagramPacket with the message, length, and broadcast address
            DatagramPacket outPacket = new DatagramPacket(data, data.length, broadcastAddress, 6001);

            //Send the packet
            while(!blnConnected){
                outSocket.send(outPacket);
                System.out.println("Broadcasted IP");
                try{
                    Thread.sleep(5000);
                }
                catch(InterruptedException e){

                }
            }

            //Close the socket
            outSocket.close();
        }
        catch(Exception e){

        }
    }

    //Constructor
    public Main(){

    }
}