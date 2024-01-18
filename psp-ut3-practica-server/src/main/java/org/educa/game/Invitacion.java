package org.educa.game;

import java.io.*;
import java.net.Socket;

public class Invitacion implements Runnable{
    Socket socket;

    Invitacion(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try(InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader reader= new BufferedReader(new InputStreamReader(is))){
            Server.getSala().getListaJugadores()
                    .add(new Jugador(reader.readLine(),
                            reader.readLine(),
                            Integer.parseInt(reader.readLine())));
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
