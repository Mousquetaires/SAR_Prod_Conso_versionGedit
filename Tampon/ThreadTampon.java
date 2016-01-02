import java.io.*;
import java.net.Socket;

public class ThreadTampon extends Thread{
	Socket socket = null;
	BufferedReader in = null;
	PrintWriter out = null;
	Tampon tampon;
	String conso;
	String prod;
	
	String str;
	String prodTemp;

	public ThreadTampon(Socket s,Tampon t){
		tampon=t;
		socket = s;
		start();
	}
	
	public void run(){
		try{
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new PrintWriter(socket.getOutputStream(),true);
			
			str = in.readLine();
			prodTemp = "producteur";			
			
			 if(str.equals(prodTemp)){
				 out.println("type producteur reçu !");				 
				 receptionP();
			 }else{
				 out.println("type consommateur reçu !");
				 receptionC();
			 }			
		}catch(IOException e){
			e.getMessage();
		}
		finally{
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException e) {
				e.getMessage();
				System.out.println("Fin de la connexion avec "+socket.getInetAddress());
			}
		}
	}	

	public void envoyerA(String dest, String msg){
	out.println(msg);
	}
   
	public void receptionP() {
	String msg = "";
		try {
			System.out.println("dans reception P");
			msg = in.readLine();
	    		tampon.surReceptionDeP(prod, msg,this);
		} catch (IOException e) {
			e.getMessage();
		}

	}
	public void receptionC() {
	String msg = "";
		try {
				msg = in.readLine();
				tampon.surReceptionDeC(conso, msg, this);
			} catch (IOException e) {
				e.getMessage();
			}    		
	}
}
