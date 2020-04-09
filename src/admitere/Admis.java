package admitere;

public class Admis {
	private double nota;
	
	protected Admis(double nota) {
		this.nota = nota;
	}

	protected double getNota() {
		return nota;
	}

	protected void setNota(double nota) {
		this.nota = nota;
	}
	
	protected Integer admissionTest() {
		return 10;
	}

	@Override
	public String toString() {
		return "Admis [nota=" + nota + "]";
	}
}
