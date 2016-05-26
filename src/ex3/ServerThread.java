package ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cuixiaohui on 16/5/26.
 */
public class ServerThread implements Runnable {
    Socket s = null;
    BufferedReader br = null;
    public ServerThread(Socket s) throws IOException{
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    public void run(){
        try {
            String content = null;

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");

            for(Socket s : ChatServer.socketList){
                PrintStream ps = new PrintStream(s.getOutputStream());
                content = "New User"+" IP:"+s.getInetAddress()+" login in at "+df.format(new Date())+"!";
                ps.println(content);
            }

            while((content = readFromClient())!=null){

                if(content.equals(":q!")){

                    for(Socket s : ChatServer.socketList){
                        PrintStream ps = new PrintStream(s.getOutputStream());
                        if (s != this.s) {
                            content = "User" + " IP:" + s.getInetAddress() + " log out!";
                            ps.println(content);
                        }else{
                            ps.println("exit!!!");
                        }
                    }

                    ChatServer.socketList.remove(this.s);
                    break;

                }else {

                    for (Socket s : ChatServer.socketList) {
                        PrintStream ps = new PrintStream(s.getOutputStream());
                        content = "content:" + content + " ||IP:" + s.getInetAddress() + " ||Time:" + df.format(new Date());
                        ps.println(content);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private String readFromClient(){
        try{
            return br.readLine();
        }catch (IOException e){
            e.printStackTrace();
            ChatServer.socketList.remove(s);
        }
        return null;
    }

}
