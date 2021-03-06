import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;

public class Library {
	private Map<TypeOfReadingMaterial, Map<String, List<ReadingMaterial>>> materials;
	private LibraryMan libraryMan;
	private final int numberOfMaterils = 6;

	public Library() {
		libraryMan = new LibraryMan();
		libraryMan.start();
		materials = new HashMap<>();
		materials.put(TypeOfReadingMaterial.BOOK, new TreeMap<>());
		materials.put(TypeOfReadingMaterial.MAGAZINE, new TreeMap<>());
		materials.put(TypeOfReadingMaterial.TEXTBOOK, new TreeMap<>());

		materials.get(TypeOfReadingMaterial.BOOK).put("Istoricheski",
				Arrays.asList(new Book(LocalDateTime.of(1963, 11, 10, 3, 34), "Ivan Vazoz", "Pod igoto", "Prosveta"),
						new Book(LocalDateTime.now(), "Ekzuperi", "Malkiq princ", "Nova")));

		materials.get(TypeOfReadingMaterial.MAGAZINE).put("Modni",
				Arrays.asList(new Book(LocalDateTime.of(1963, 11, 10, 3, 34), "Ivan Vazoz", "Pod igoto", "Prosveta"),
						new Book(LocalDateTime.now(), "Ekzuperi", "Malkiq princ", "Nova")));

		materials.get(TypeOfReadingMaterial.BOOK).put("Istoricheski",
				Arrays.asList(new Magazine(LocalDateTime.now(), 3, "Cosmos", "Anubis"),
						new Magazine(LocalDateTime.now(), 2, "Blqsyk", "Bulvest 2000")));

		materials.get(TypeOfReadingMaterial.TEXTBOOK).put("Informatika",
				Arrays.asList(new TextBook("Ganio Hristev", "Algebra za 5 klas", "Anubis"),
						new TextBook("Stamat neshto", "Integrali za 2 klas", "prosveta")));
	}

	public void showCatalog(TypeOfReadingMaterial type) {
		Map<String, List<ReadingMaterial>> catalog = materials.get(type);
		for (String category : catalog.keySet()) {
			System.out.println(category + ":");
			List<ReadingMaterial> list = catalog.get(category);
			list.sort(list.get(0).getComparator());

			for (ReadingMaterial rm : list) {
				System.out.println(rm);
			}
		}
	}
	
	public List<ReadingMaterial> catalogOfBooks(){
		List<ReadingMaterial> list = new ArrayList<>();
		for(String subject : materials.get(TypeOfReadingMaterial.BOOK).keySet()){
			list.addAll(materials.get(TypeOfReadingMaterial.BOOK).get(subject));
		}
		return list;
	}
	

	public List<ReadingMaterial> catalogOfTextBooks(){
		List<ReadingMaterial> list = new ArrayList<>();
		for(String subject : materials.get(TypeOfReadingMaterial.TEXTBOOK).keySet()){
			list.addAll(materials.get(TypeOfReadingMaterial.TEXTBOOK).get(subject));
		}
		return list;
	}
	

	public void getReadingMaterial(ReadingMaterial readingMaterial) throws LibraryException {
		if (readingMaterial != null && readingMaterial.canBeTaken() && !(readingMaterial.isTaken())) {
			readingMaterial.takeIt(true);

			libraryMan.addMaterialToWatch(readingMaterial);
		} else {
			throw new LibraryException("Ne moje da se vzema toq obekt taka");
		}
	}

	public void returnReadingMaterial(ReadingMaterial readingMaterial) {
		readingMaterial.takeIt(false);
		System.out.println("Dyljish " + libraryMan.getHowMuchIHaveToPayForThis(readingMaterial));
		libraryMan.removeMaterialsToWatch(readingMaterial);
	}

	public int NumberOfAvailableReadingMaterials() {
		return numberOfMaterils - libraryMan.getNumberOfTakenMaterials();
	}

	public void logTakenMaterials() {
		SortedSet<ReadingMaterial> materials = libraryMan.getMaterialsByDate();
		PrintWriter writer;
		try {
			writer = new PrintWriter("materials.txt", "UTF-8");

			System.out.println("Obsht broi " + materials.size());
			for (ReadingMaterial rm : materials) {
				writer.println(rm);
			}
			writer.close();

		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
