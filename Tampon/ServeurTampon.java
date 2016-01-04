import java.io.*;
import java.net.*;

public class ServeurTampon {
    static ServerSocket socketServeur;
    static Socket socketService;
    static int port = 4020;
    
    
    
    public static void main(String[] args){
    	System.out.println("Bienvenu, attente du demarrage du server");
    	Tampon t=new Tampon();
    	try{
		socketServeur = new ServerSocket(port);			
        	System.out.println("Le serveur est pret ");        	
        	while (true) {
			socketService = socketServeur.accept();			
    			System.out.println("La connexion est accpetée pour "+socketService.getInetAddress());
    			ThreadTampon threadTampon = new ThreadTampon(socketService,t);
    		}
        }catch(IOException e){
        	e.getMessage();   
        }
        finally{
        	try{
        		socketServeur.close();
        		socketService.close();
        	}catch(IOException e){
        		e.getMessage();
        	}
        }
    }
    
    
    

}
