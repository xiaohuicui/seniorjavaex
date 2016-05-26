package ex3;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Collections;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;


/**
 * Created by cuixiaohui on 16/5/26.
 */
public class ChatServer {
    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(30000);
        while(true){
            Socket s = ss.accept();
            socketList.add(s);
            new Thread(new ServerThread(s)).start();
        }
    }

}
