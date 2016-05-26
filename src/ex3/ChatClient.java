package ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by cuixiaohui on 16/5/26.
 */
public class ChatClient {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("127.0.0.1", 30000);
        ClientThread ct = new ClientThread(s);
        Thread t = new Thread(ct);
        t.start();
        PrintStream ps = new PrintStream(s.getOutputStream());
        String line = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while((line=br.readLine()) != null){
            ps.println(line);

            if(line.equals(":q!")){
                break;
            }
        }


    }


}
