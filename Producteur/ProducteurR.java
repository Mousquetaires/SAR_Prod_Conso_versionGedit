import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ProducteurR {
    public String id;
    public String mess;
     
    Socket socket;
    InetAddress dest;
    int portdest=4020 ;//port d'écoute du destinataire ou du serveur
    BufferedReader in;
    PrintStream out;
    public boolean demander=false;
    
    public ProducteurR(){
    	String desti="192.168.1.198";
    	try {
			dest= InetAddress.getByName(desti)	;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
    }
    
    
    public void connexion(){
    	try {
			socket= new Socket(this.dest,portdest);
			if(socket.isConnected())
				System.out.println("Connexion établit avec l'hote :"+dest);
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out= new PrintStream(socket.getOutputStream());
			out.println("producteur");
			String p= in.readLine();
			System.out.println(p);
		} catch (IOException e) {
			System.out.println("Adresse inconnue");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
    }
    
    public void envoyerA(String message) {
    	if(demander==true){
    		out.println(message);
    		fermeture();
    		
    	}else{
    		System.out.println("dans envoyer a de else");
    		connexion();
    		out.println(message);
    		receptionR();
    	}
    		
    }
    public void receptionR() {
    	try {
	
		String rep=in.readLine();
		System.out.println(rep);
		ProducteurS.surReceptionDe(rep);
		demander=true;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
    
    public void fermeture(){
    	try{
    	}catch(Exception e){}
    	finally{
    		try{
	    		in.close();
	    		out.close();
	    		socket.close();
			demander=false;
    		}catch(Exception e){}
    	}
    }
   

}
