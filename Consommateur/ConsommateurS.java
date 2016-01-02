


public class ConsommateurS {
    public String id;
    public String mess;
    ConsommateurR cons;
    String req="REQ";
    
    

    public ConsommateurS(ConsommateurR consoR) {
    	this.cons=consoR;
    }

    public void demande() {
    	cons.envoyerA(req);
    	
    }

    public static void surReceptionDe(String message) {
    	if(message!="REFUS"){
    		System.out.println(message);
    	}else{
    		System.out.println("Pas de message");
    	}
    		
    }

}
