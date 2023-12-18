import java.net.*;
import java.io.*;

public class HttpServer{
    public static void main(String[] args) throws IOException{
        int port = 8081;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server listening on port " + port);
        while(true){
            Socket clientSocket = server.accept();
            System.out.println("Client Connected");
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String s;
            while((s = in.readLine())!= null){
                System.out.println(s);
                if(s.isEmpty()){
                    break;
                }
            }
            OutputStream clientOutput = clientSocket.getOutputStream();
            clientOutput.write("HTTP/1.1 200 OK \r\n".getBytes());
            clientOutput.write("\r\n".getBytes());
            clientOutput.write("<b>Welcome to server</b>".getBytes());
            clientOutput.write("\r\n\r\n".getBytes());
            clientOutput.flush();
            System.out.println("Client connection closed");
            in.close();
            clientOutput.close();
        }
    }
} 