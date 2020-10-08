package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    
    private ServerSocket serverSocket;
    
    private void criarServerSocet(int porta) throws IOException{
        serverSocket = new ServerSocket(porta);
        
        
    }
    
    private Socket esperaConexao() throws IOException{
        Socket socket =  serverSocket.accept();
        return socket;
    }
    
    private  void trataConexao (Socket socket) throws ClassNotFoundException{
        
        try {
            
                
                
            
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        
            //ler qual o tipo de ordenação
            Integer ordenação = input.readInt();
            
            //ler o vetor
            ArrayList<Integer> entradaArrayList = new ArrayList((ArrayList<Integer>) input.readObject());
            System.out.println("Mensagem Recebida\n");
            ArrayList<Integer> saidaArrayList = new ArrayList<>();
            
            
            System.out.println("Ordenação Recebida:");
            if(ordenação == 1){
             System.out.println(ordenação +" Insertion Sort\n");
             saidaArrayList = InsertionSort.insertionSort(entradaArrayList);
            }
            if(ordenação == 2){
             System.out.println(ordenação +" Selection Sort\n");
             saidaArrayList = SelectionSort.SelectionSort(entradaArrayList);
            }
            if(ordenação == 3){
             System.out.println(ordenação+" Burble Sort\n");
             saidaArrayList = BurbleSort.bubblesort(entradaArrayList);
             
            }

            System.out.println("Array recebido: \n"+entradaArrayList);
            
            output.writeObject(saidaArrayList);
            System.out.println("\nMensagem Enviada\n");            
            output.flush();
            System.out.println("Array Enviado:\n"+saidaArrayList);
            
            input.close();
            output.close();
            
        } catch (IOException ex) {
            System.out.println("Problema com o tratamento de conexção ao cliente " + socket.getInetAddress());
            System.out.println("Erro:"+ex.getMessage());
        
            
            
            
            
        }  
        finally{
            try {    
                fechaSocket(socket);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void fechaSocket(Socket s) throws IOException{
        s.close();
    }
     
    public static void main(String[] args) {
        try {
            Server server = new Server();
            
            server.criarServerSocet(55455);
            
            while (true) {
            System.out.println("Esperando Conexão......\n");   
            Socket socket = server.esperaConexao();
            System.out.println("Conectado ao cliente\n");
            server.trataConexao(socket);
            System.out.println("\nCliente Desconectado\n");
            
        }
        
        } catch ( Exception e) {
        }
        
        
        
             
        
    }
    
}
