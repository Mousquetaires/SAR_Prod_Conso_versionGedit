import java.util.Scanner;

public class Producteur {
	static ProducteurS pro;
	static Scanner scan = new Scanner(System.in);
	String tamp;

	public static String saisirMessage(){
		String mess = scan.nextLine();
		mess.intern();
		return mess;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProducteurR proR=new ProducteurR();
		pro= new ProducteurS(proR);
		
		while(true){
			System.out.println("Bienvenue dans le Producteur");
			for(int i=0;i<50;i++){
				System.out.print("-");
				}
			System.out.println("-");
			System.out.println("Veuillez appuyer sur Entrer pour savoir l'état du Tampon ");
			String temp=saisirMessage();
			pro.demande(temp);
			if(pro.autorisation){
				System.out.println("Veuillez entrer votre message à envoyer au Tampon");
				for(int i=0;i<50;i++){
				System.out.print("-");
				}
				System.out.println("-");
				String tem2=saisirMessage();
				pro.produire(tem2);
			}						
		}
	}

}
