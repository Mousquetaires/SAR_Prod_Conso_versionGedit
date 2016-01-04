


public class ConsommateurS {
    public String id;
    public String mess;
    ConsommateurR cons;
    static String req="REFUS";
    
    

    public ConsommateurS(ConsommateurR consoR) {
    	this.cons=consoR;
    }

    public void demande() {
    	cons.envoyerA(req);
    }

    public static void surReceptionDe(String message) {
    	if(message.equals(req)){
		for(int i=0;i<50;i++){
		System.out.print("-");
	}
	System.out.println("-");
	System.out.println("Le serveur est vide");
	for(int i=0;i<50;i++){
		System.out.print("-");
	}
	System.out.println("-");	
    	}else{
		consommer(message);
    	}
    }
    public static void consommer(String message){
	System.out.println("Le message reçu est: ");  
	for(int i=0;i<50;i++){
		System.out.print("-");
	}
	System.out.println("-");
	System.out.println(message);	
	for(int i=0;i<50;i++){
		System.out.print("-");
	}
	System.out.println("-");
    }

}
