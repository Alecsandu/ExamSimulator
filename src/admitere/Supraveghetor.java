package admitere;

public class Supraveghetor {
	private String name;
	
	protected Supraveghetor(String name) {
		this.name = name;
	}
	
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Supraveghetor [name=" + name + "]";
	}
}
