
public class Tampon {   
    public String id;
    public String [] tabMess = new String[50];  
    public int nbMess = 0;
    public int outC = 0;   
    public int inP = 0;
    ThreadTampon serv;
    String req = "REQ";
    String ack = "ACK";
    String refus = "REFUS"; 
    
    
    public boolean autorisation(String producteur,ThreadTampon servv) {    	
    	if(nbMess<tabMess.length){
    		servv.envoyerA(producteur, ack);
    		servv.receptionP();
    		return true;
    	}else{
    		servv.envoyerA(producteur, refus);
    		return false;
    	}
    }
    
    public synchronized void surReceptionDeP(String producteur, String msg,ThreadTampon se) {
       	if(!(msg.equals(req))){
    		System.out.println("le message reçu est : "+msg);
    		tabMess[inP] = msg;
    		int tmp = inP;
    		inP = (inP+1)%tabMess.length;    		
    		nbMess++;
    		System.out.println(tabMess[tmp]+" est le numero : "+nbMess+ " dans le tampon");
    	}else{
    		this.autorisation(producteur,se);
    	}
    }
   
    public synchronized void surReceptionDeC(String consommateur, String msg, ThreadTampon se) {
    	if(nbMess>0){
    		msg = tabMess[outC];
    		System.out.println("le message envoyé est : "+msg);
    		outC = (outC+1)%tabMess.length;
    		nbMess--;
    		se.envoyerA(consommateur, msg);
    	}else{
    		se.envoyerA(consommateur, refus);
    		System.out.println("Bonjour mon conso, y'a pas de bouffe ce soir ! :)");
    	}
    }

}
