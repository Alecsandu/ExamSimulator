package admitere;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Audit {
	public static void write(String serviciu) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("audit.csv", true))) {
			Date data = new Date();
			StringBuilder infos = new StringBuilder(data.toString());
			infos.append(",");
			infos.append(serviciu);
			infos.append(System.lineSeparator());
			writer.write(infos.toString());
		} catch(IOException e) {
			System.out.println("Eroare la scrierea in fisier!");
		}
	}
}
