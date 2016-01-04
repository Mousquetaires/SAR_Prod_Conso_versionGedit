

import java.util.Scanner;

public class Consommateur {

	public static void main(String[] args) {
		ConsommateurR consRe=new ConsommateurR();
		ConsommateurS consS=new ConsommateurS(consRe);
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.println("Bienvenue dans le service du consommateur");
			for(int i=0;i<50;i++){
				System.out.print("-");
			}
			System.out.println("-");
			System.out.println("Veillez appuyer sur Entrer tampon pour consommer un message s'il y'en a !");
			String temp=sc.nextLine();
			consS.demande();
		}
		
	}

}
