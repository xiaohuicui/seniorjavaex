package ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.Buffer;

/**
 * Created by cuixiaohui on 16/5/26.
 */
public class ClientThread implements Runnable {
    private Socket s;
    BufferedReader br = null;

    public ClientThread(Socket s) throws IOException{
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    public void run(){
        try{

                String content = null;
                while ((content = br.readLine()) != null) {
                    if(content.equals("exit!!!")){

                        break;
                    }else {
                        System.out.println(content);
                    }
                }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("Client Exit!");
        }
    }



}
