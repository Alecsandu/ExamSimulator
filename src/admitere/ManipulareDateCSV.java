package admitere;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManipulareDateCSV<T> {
	private static ManipulareDateCSV instance = null;
	
	private ManipulareDateCSV() {
	}
	
	public static ManipulareDateCSV getInstance() {
		if (instance == null) {
			instance = new ManipulareDateCSV();
		}
		return instance;
	}
	
	public void write(List<T> elementsList, String filePath) {
		Field[] fields = elementsList.get(0).getClass().getDeclaredFields();
		Field[] fieldsInherited= elementsList.get(0).getClass().getSuperclass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
		}
		for (Field field: fieldsInherited) {
			field.setAccessible(true);
		}
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
			for (T element : elementsList) {
				/*
				 * Atributele din clasa care extinde
				 */
				writer.write((elementsList.get(0).getClass().getSimpleName()).toString());
				writer.write(",");
				for (int i = 0; i < fields.length - 1; ++i) {
					Object val = fields[i].get(element);
					if (val != null) {
						writer.write(val.toString());
					}
					writer.write(",");
				}
				if (fields.length - 1 >= 0) {
					Object val  = fields[fields.length - 1].get(element);
					if (val != null) {
						writer.write(val.toString());
					}
				}
				/*
				 * Atributele din clasa de baza daca are
				 */
				writer.write(",");
				for (int j = 0; j < fieldsInherited.length - 1; ++j) {
					Object value = fieldsInherited[j].get(element);
					if (value != null) {
						writer.write(value.toString());
					}
					writer.write(",");
				}
				if (fieldsInherited.length - 1 >= 0) {
					Object value  = fieldsInherited[fieldsInherited.length - 1].get(element);
					if (value != null) {
						writer.write(value.toString());
					}
				}
				writer.write(System.lineSeparator());
			}
		} catch(IOException e) {
			System.out.println("Eroare la scrierea in fisier");
		} catch (IllegalAccessException e) {
            e.printStackTrace();
        }
		for (Field field : fields) {
			field.setAccessible(false);
		}
		for (Field field: fieldsInherited) {
			field.setAccessible(false);
		}
	}
	
	public void read(ArrayList<T> lista, String numeFisier) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(numeFisier));
			String data = reader.readLine();
			while (data != null) {
				String[] elements = data.split(",");
				Class<?> clasa = Class.forName(elements[0]);
				elements = Arrays.copyOfRange(elements, 1, elements.length);
				Constructor<?>[] constructor = clasa.getDeclaredConstructors();
				Class<?>[] dataTypes = (constructor[0]).getParameterTypes();
				Object[] paramData = new Object[5];
				String regex = "([0-9]+[.][0-9]+)";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(elements[0]);
				Double number = 0.0;
				while (matcher.find()) {
					number = Double.parseDouble(matcher.group());
				}
				
				if(elements.length>=5) {
					paramData[0] = elements[2];
					paramData[1] = elements[3];
					paramData[2] = elements[4];
					paramData[3] = new Admis(number);
					paramData[4] = elements[0];
					lista.add((T)constructor[0].newInstance(paramData));
				}
				data = reader.readLine();
			}
			reader.close();
		}catch (IOException e){
            System.out.println("Eroare la citire");
        }catch (ClassNotFoundException e){
            System.out.println("Clasa nu exista");
        }catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
	}
}
