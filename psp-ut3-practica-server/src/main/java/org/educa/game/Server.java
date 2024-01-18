package org.educa.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final String DIRECCION = "localhost";
    private final int PUERTO = 5555;
    private  static SalaEsperaJugadores salaEsperaJugadores=new SalaEsperaJugadores();

    public void run() {
        System.out.println("Creando socket servidor");
        try(ServerSocket serverSocket= new ServerSocket();) {
            InetSocketAddress addr = new InetSocketAddress(DIRECCION,PUERTO);
            serverSocket.bind(addr);
            System.out.println("Se han aceptado las conexiones");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void esperarJugadores(ServerSocket serverSocket){
        while (true) {
            try (Socket newSocket = serverSocket.accept()){

            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized SalaEsperaJugadores getSala() {
        return salaEsperaJugadores;
    }
}
