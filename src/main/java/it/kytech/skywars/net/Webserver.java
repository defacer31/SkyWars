package it.kytech.skywars.net;

import java.net.ServerSocket;
import java.net.Socket;

import it.kytech.skywars.SkyWars;


public class Webserver extends Thread {

    public void run() {
        try{
        ServerSocket st =  new ServerSocket(880);

            while (!SkyWars.isDisabling()) {

                Socket skt = st.accept();

                // Spin off request to a new thread to be handled
                Connection c = new Connection(skt);
                c.start();
               // st.close();
            }
            st.close();
        }catch (Exception e) {

            e.printStackTrace();
        }

    }
}

