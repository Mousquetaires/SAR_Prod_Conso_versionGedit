
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
			System.out.println("dans produire");
			p.envoyerA(mess);
			autorisation = false;
			p.demander=false;
			
		}
	}
	public void demande(String dest) {
	p.envoyerA(req);

	}

	public static void surReceptionDe(String mess){
		System.out.println("dans sureceptionDe ");
		System.out.println(mess);
		if(mess.equals(ack)){
			autorisation = true;
		}else if(mess.equals(refu)){
			System.out.println("Pas de Place dans le tampon");
		}
		
	}
}

    
   

