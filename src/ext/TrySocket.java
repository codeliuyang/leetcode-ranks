package ext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TrySocket {

    public static void main(String[] args){
        try {
            // 服务端启动
            ServerSocket serverSocket = new ServerSocket(9999);
            while(true){
                Socket socket = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        BufferedReader bufferedReader = null;
                        try {
                            bufferedReader =
                                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            String str;
                            while((str = bufferedReader.readLine()) != null){
                                System.out.println(str);
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
