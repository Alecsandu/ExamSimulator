package admitere;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Service choice = new Service();
		Scanner scanner = new Scanner(System.in);
		boolean continua = true;
		do {
			System.out.println("Menu:");
			System.out.println("1. Creaza facultate");
			System.out.println("2. Inscrie candidat");
			System.out.println("3. Sterge candidat");
			System.out.println("4. Sorteaza candidatii");
			System.out.println("5. Testeaza candidatii");
			System.out.println("6. Afiseaza candidatii");
			System.out.println("7. Afiseaza supraveghetorii");
			System.out.println("8. Afiseaza informatii despre un candidat");
			System.out.println("9. Adauga supraveghetor");
			System.out.println("10. Verifica candidatii");
			int choosed = scanner.nextInt();
			scanner.nextLine();
			switch (choosed) {
				case 1:
					choice.creazaFacultate();
					break;
				case 2:
					choice.inscrieCandidat();
					break;
				case 3:
					choice.stergeCandidat();
					break;
				case 4:
					choice.sorteazaCandidatii();
					break;
				case 5:
					choice.testCandidati();
					break;
				case 6:
					choice.afiseazaCandidatii();
					break;
				case 7:
					choice.afiseazaSupraveghe();
					break;
				case 8:
					choice.arataInformatii();
					break;
				case 9:
					choice.adaugaSupraveghetor();
					break;
				case 10:
					choice.verificaCandidatii();
					break;
				default:
					System.out.println("Optiunea aleasa nu exista sau inca nu a fost implementata");
			}
			System.out.println("Doriti sa continuati simularea?");
			try {
				continua = scanner.nextBoolean();
				scanner.nextLine();
			} catch (InputMismatchException e) {
				continua = false;
			}
		}while(continua);
		
		System.out.println("Va multumim pentru folosirea aplicatiei!");
		
		scanner.close();
	}

}
