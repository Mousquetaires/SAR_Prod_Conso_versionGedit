
public class ProducteurS {
	
	public static boolean autorisation=false;
	String id;
	String mess;
	static ProducteurR p;
	static String ack="ACK";
	static String refu="REFUS";
		
	/*A definir le requete*/
	String req = "REQ";
	
	public ProducteurS(ProducteurR p){
		this.p = p;
	}
	public static boolean getAuto(){
		return autorisation;
	}
	public void produire(String mess) {
		while(autorisation == false){
			System.out.println("pas de Place ");
		}
		if(autorisation == true){
			p.envoyerA(mess);
			autorisation = false;
			p.demander=false;
			
		}
	}
	public void demande(String dest) {
		p.envoyerA(req);

	}

	public static void surReceptionDe(String mess){
		if(mess.equals(ack)){
			autorisation = true;
			for(int i=0;i<50;i++){
				System.out.print("-");
			}
			System.out.println("-");
			System.out.println("le serveur vous autorise à produire un message");
			for(int i=0;i<50;i++){
				System.out.print("-");
			}
			System.out.println("-");
		}else if(mess.equals(refu)){
			for(int i=0;i<50;i++){
				System.out.print("-");
			}
			System.out.println("-");
			System.out.println("le serveur vous n'autorise pas à produire un message car manque de place");
			for(int i=0;i<50;i++){
				System.out.print("-");
			}
			System.out.println("-");
		}
		
	}
}

    
   

