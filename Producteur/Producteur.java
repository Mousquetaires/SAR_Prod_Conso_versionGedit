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
			System.out.println("Bienvenue dans le Producteur \nVeuillez appuyer sur Entrer pour savoir l'état du Tampon ");
			String temp=saisirMessage();
			pro.demande(temp);
			//System.out.println("Entre dans saisir message");
			//System.out.println("Je suis dans autorisation");
			if(pro.autorisation){
				System.out.println("Veuillez entrer votre message a envoyer au Tampon");
				String tem2=saisirMessage();
				pro.produire(tem2);
			}						
		}
	}

}
