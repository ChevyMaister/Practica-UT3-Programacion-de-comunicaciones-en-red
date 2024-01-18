package org.educa.game;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Player extends Thread {
    private String gameType;
    private boolean enPartida=false;


    public Player(String name, String gameType) {
        super.setName(name);
        this.gameType = gameType;
    }

    @Override
    public void run() {
        System.out.println("Start player");
        try (Socket jugador = new Socket()) {
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            jugador.connect(addr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void conexion(Socket jugador){
        try (BufferedReader recibo = new BufferedReader(new InputStreamReader(jugador.getInputStream()));
             PrintWriter envio= new PrintWriter(new OutputStreamWriter(jugador.getOutputStream()))) {
            if(!enPartida){
                enPartida=true;
                envio.println("empiezo");
                envio.flush();
                String msg=recibo.readLine();
                if("ok".equalsIgnoreCase(msg)){
                    ////////////////////////////////
                    /////////// PREGUNTAR SI HAY QUE INTRODUCIR UN NOMBRE O CON EL GETNAME DEL HILO VALE
                    ///////////////////////////////
                    if (checkNickName(getName())) {
                        envio.println(gameType + "," + getName());
                        envio.flush();
                        //Recibimos una String; nickNameOponente, host, puerto, anfitrion
                        msg = recibo.readLine();
                        String[] datos = msg.split(",");
                        System.out.println("Mi oponentes es: "+datos[0]);
                        if("anfitrion".equalsIgnoreCase(datos[3])){
                            System.out.println("Eres anfitrion");
                            try(ServerSocket socketAnfitrion = new ServerSocket()){
                                InetSocketAddress addrPartida= new InetSocketAddress("localhost",Integer.parseInt(datos[2]));
                                socketAnfitrion.bind(addrPartida);
                                try(Socket partidaAnfitrion = socketAnfitrion.accept()){
                                    ///////////////////////////
                                    //////////////////////////
                                    //TODO
                                    //////////////////////////
                                    /////////////////////////
                                }
                            }
                        }else{
                            System.out.println("Tu oponente es el anfitrion");
                        }
                    }else{
                        System.out.println("El nombre del jugador es demasiado largo, máx 10 carácteres");
                    }
                }else{
                    System.out.println("La sala está llena");
                }

            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private boolean checkNickName(String name) {
        return name.length() <= 10;
    }
}
