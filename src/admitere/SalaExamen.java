package admitere;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class SalaExamen{
	private int numarSala;
	private Set<Supraveghetor> supraveghetori;
	private List<CandidatMate> candMate;
	private List<CandidatInfo> candInfo;
	private List<CandidatCTI> candCTI;
	
	protected SalaExamen(int numarSala) {
		this.numarSala = numarSala;
		this.supraveghetori = new HashSet<Supraveghetor>();
		this.candMate = new ArrayList<CandidatMate>();
		this.candInfo = new ArrayList<CandidatInfo>();
		this.candCTI = new ArrayList<CandidatCTI>();
	}

	protected int getNumarSala() {
		return numarSala;
	}

	protected void setNumarSala(int numarSala) {
		this.numarSala = numarSala;
	}
	
	protected void adaugaSupraveghetor(Supraveghetor supraveghe) {
		this.supraveghetori.add(supraveghe);
	}
	
	protected void adaugaCandidatMate(CandidatMate m) {
		this.candMate.add(m);
	}
	
	protected void adaugaCandidatInfo(CandidatInfo m) {
		this.candInfo.add(m);
	}
	
	protected void adaugaCandidatCTI(CandidatCTI m) {
		this.candCTI.add(m);
	}

	@Override
	public String toString() {
		return "SalaExamen [numarSala=" + numarSala  + ", " + super.toString()
				+ "]";
	}

	protected Set<Supraveghetor> getSupraveghetori() {
		return supraveghetori;
	}

	protected void setSupraveghetori(Set<Supraveghetor> supraveghetori) {
		this.supraveghetori = supraveghetori;
	}

	protected List<CandidatMate> getCandMate() {
		return candMate;
	}

	protected void setCandMate(List<CandidatMate> candMate) {
		this.candMate = candMate;
	}

	protected List<CandidatInfo> getCandInfo() {
		return candInfo;
	}

	protected void setCandInfo(List<CandidatInfo> candInfo) {
		this.candInfo = candInfo;
	}

	protected List<CandidatCTI> getCandCTI() {
		return candCTI;
	}

	protected void setCandCTI(List<CandidatCTI> candCTI) {
		this.candCTI = candCTI;
	}
}
