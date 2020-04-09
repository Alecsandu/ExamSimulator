package admitere;

import java.util.*;
import java.math.*;

public class Service {
	Facultate facultatea;
	
	public Service() {
		System.out.println("Ati pornit aplicatia de admitere, puteti simula o admitere la mai multe domenii de lincenta(Mate,Info,CTI):\n");
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public void creazaFacultate() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduceti numele ");
		String nume = scan.nextLine();
		System.out.println("Precizati numarul salii:");
		int nrS = scan.nextInt();
		scan.nextLine();
		facultatea = new Facultate(nume, nrS);
	}
	
	public void inscrieCandidat() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Dati numele candidatului");
		String nume = scan.nextLine();
		scan.nextLine();
		
		System.out.println("CNP: ");
		String cnp = scan.nextLine();
		scan.nextLine();
		
		System.out.println("Varsta: ");
		int varsta = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Anul inscrierii: ");
		int anul = scan.nextInt();
		scan.nextLine();
		
		System.out.println("La ce domeniu de licenta doriti sa il inscrieti(Mate/Info/CTI)");
		String licenta = scan.nextLine();
		scan.nextLine();
		
		if (licenta.equals("Mate")) {
			facultatea.getSala().adaugaCandidatMate(new CandidatMate(nume, cnp, varsta, new Admis(0), anul));
		}
		if (licenta.equals("Info")) {
			facultatea.getSala().adaugaCandidatInfo(new CandidatInfo(nume, cnp, varsta, new Admis(0), anul));
		}
		if (licenta.equals("CTI")) {
			facultatea.getSala().adaugaCandidatCTI(new CandidatCTI(nume, cnp, varsta, new Admis(0), anul));
		}
	}
	
	public void stergeCandidat() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Specificati pe cine vreti sa stergeti");
		String name = scan.nextLine();
		scan.nextLine();
		System.out.println("Specificati din cadrul carui examen doriti sa il stergeti");
		String nameL = scan.nextLine();
		scan.nextLine();
		
		if (nameL.equals("Mate")) {
			Iterator<CandidatMate> itr = facultatea.getSala().getCandMate().iterator();
			while(itr.hasNext()) {
				CandidatMate m = itr.next();
				if (m.getNume_candidat().equals(name))
					itr.remove();
			}
		}
		
		if (nameL.equals("Info")) {
			Iterator<CandidatInfo> itr = facultatea.getSala().getCandInfo().iterator();
			while(itr.hasNext()) {
				CandidatInfo m = itr.next();
				if (m.getNume_candidat().equals(name))
					itr.remove();
			}
		}
		
		if (nameL.equals("CTI")) {
			Iterator<CandidatCTI> itr = facultatea.getSala().getCandCTI().iterator();
			while(itr.hasNext()) {
				CandidatCTI m = itr.next();
				if (m.getNume_candidat().equals(name))
					itr.remove();
			}
		}
	}
	
	public void sorteazaCandidatii() {
		System.out.println("Candidatii carei probe doriti sa ii sortati?(Mate/Info/CTI)");
		Scanner scan = new Scanner(System.in);
		String nume = scan.nextLine();
		scan.nextLine();
		if (nume.equals("Mate")) {
			Collections.sort(facultatea.getSala().getCandMate(), (a, b) -> a.getNume_candidat().compareTo(b.getNume_candidat()));
		}
		if (nume.equals("Info")) {
			Collections.sort(facultatea.getSala().getCandInfo(), (a, b) -> a.getNume_candidat().compareTo(b.getNume_candidat()));
		}
		if (nume.equals("CTI")) {
			Collections.sort(facultatea.getSala().getCandCTI(), (a, b) -> a.getNume_candidat().compareTo(b.getNume_candidat()));
		}
	}
	
	public void testCandidati() {
		System.out.println("Ce candidati doriti sa testati?(Mate/Info/CTI)");
		Scanner scan = new Scanner(System.in);
		String tipCandidati = scan.nextLine();
		scan.nextLine();
		if (tipCandidati.equals("Mate")) {
			for(CandidatMate i:facultatea.getSala().getCandMate()) {
				double x = Math.random();
				x = round(x,3);
				x = x *100;
				i.getAdmited().setNota(x);
			}
		}
		if (tipCandidati.equals("Info")) {
			for(CandidatInfo i:facultatea.getSala().getCandInfo()) {
				double x = Math.random();
				x = round(x,3);
				x = x *100;
				i.getAdmited().setNota(x);
			}
		}
		if (tipCandidati.equals("CTI")) {
			for(CandidatCTI i:facultatea.getSala().getCandCTI()) {
				double x = Math.random();
				x = round(x,3);
				x = x *100;
				i.getAdmited().setNota(x);
			}
		}
	}
	
	public void afiseazaCandidatii() {
		for(Candidat i : facultatea.getSala().getCandMate())
			System.out.println(i.getNume_candidat());
		for(Candidat i : facultatea.getSala().getCandInfo())
			System.out.println(i.getNume_candidat());
		for(Candidat i : facultatea.getSala().getCandCTI())
			System.out.println(i.getNume_candidat());
	}
	
	public void afiseazaSupraveghe() {
		for(Supraveghetor i:facultatea.getSala().getSupraveghetori()) {
			System.out.println(i.toString());
		}
	}
	
	public void arataInformatii() {
		System.out.println("Precizati despre ce candidat doriti sa aflati inforamtii si domeniul la care candideaza");
		Scanner scan = new Scanner(System.in);
		String numeC = scan.nextLine();
		scan.nextLine();
		String numeL = scan.nextLine();
		scan.nextLine();
		if (numeL.equals("Mate")) {
			for(CandidatMate i : facultatea.getSala().getCandMate()) {
				if (i.getNume_candidat().equals(numeC)) {
					System.out.println(i.toString());
				}
			}
		}
		if (numeL.equals("Info")) {
			for(CandidatInfo i : facultatea.getSala().getCandInfo()) {
				if (i.getNume_candidat().equals(numeC)) {
					System.out.println(i.toString());
				}
			}
		}
		if (numeL.equals("CTI")) {
			for(CandidatCTI i : facultatea.getSala().getCandCTI()) {
				if (i.getNume_candidat().equals(numeC)) {
					System.out.println(i.toString());
				}
			}
		}
	}
	
	public void adaugaSupraveghetor() {
		System.out.println("Precizati numele supraveghetorului");
		Scanner scan = new Scanner(System.in);
		String numeS = scan.nextLine();
		scan.nextLine();
		
		facultatea.getSala().getSupraveghetori().add(new Supraveghetor(numeS));
	}
	
	public void verificaCandidatii() {
		System.out.println("Doriti sa verificati candidatii daca copiaza?(true/false)");
		Scanner scan = new Scanner(System.in);
		boolean x = scan.nextBoolean();
		scan.nextLine();
		int nr = 0;
		if (x == true) {
			Iterator<CandidatMate> itr = facultatea.getSala().getCandMate().iterator();
			while(itr.hasNext()) {
				CandidatMate m = itr.next();
				double y = Math.random();
				if (y < 0.2) {
					itr.remove(); nr++;}
			}

			Iterator<CandidatInfo> itr2 = facultatea.getSala().getCandInfo().iterator();
			while(itr2.hasNext()) {
				CandidatInfo m = itr2.next();
				double y = Math.random();
				if (y < 0.15) {
					itr2.remove(); nr++; }
			}
			
			Iterator<CandidatCTI> itr3 = facultatea.getSala().getCandCTI().iterator();
			while(itr3.hasNext()) {
				CandidatCTI m = itr3.next();
				double y = Math.random();
				if (y < 0.25) {
					itr3.remove(); nr++; }
			}
		}
		if (nr > 0)
			System.out.println("Am gasit " + nr + " candidati care au incercat sa copieze");
		else
			System.out.println("Nu avem candidati care copiaza");
	}
}