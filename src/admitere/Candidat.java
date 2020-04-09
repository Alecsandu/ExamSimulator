package admitere;

public class Candidat {
	private String numeCandidat;
	private String CNP;
	private int varsta;
	
	protected Candidat(String nume, String CNP, int varsta) {
		this.numeCandidat = nume;
		this.CNP = CNP;
		this.varsta = varsta;
	}

	protected String getNume_candidat() {
		return numeCandidat;
	}

	protected void setNumeCandidat(String numeCandidat) {
		this.numeCandidat = numeCandidat;
	}

	protected String getCNP() {
		return CNP;
	}

	protected void setCNP(String cNP) {
		CNP = cNP;
	}

	protected int getVarsta() {
		return varsta;
	}

	protected void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	@Override
	public String toString() {
		return "Candidat [numeCandidat=" + numeCandidat + ", CNP=" + CNP + ", varsta=" + varsta + "]";
	}
}
