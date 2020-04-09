package admitere;

public class Facultate {
	private String name;
	private SalaExamen sala;

	protected Facultate(String name, int nrSali) {
		this.name = name;
		this.sala = new SalaExamen(nrSali);
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected SalaExamen getSala() {
		return sala;
	}

	protected void setSala(SalaExamen sala) {
		this.sala = sala;
	}

	@Override
	public String toString() {
		return "Facultate [name=" + name + ", sala=" + sala.toString() + "]";
	}
	
}
