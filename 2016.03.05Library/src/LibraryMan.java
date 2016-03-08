import java.lang.ProcessBuilder.Redirect;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class LibraryMan extends Thread {

	private static final int TIME_TO_WAIT = 1000;
	private Map<ReadingMaterial, Double> materialsToFollow;
	

	public LibraryMan() {
		this.setDaemon(true);
		materialsToFollow = new HashMap<ReadingMaterial, Double>();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(TIME_TO_WAIT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (ReadingMaterial r : materialsToFollow.keySet()) {

				try {
					int secForThisBook = r.getSecondsForTake();
					LocalDateTime time = r.getTimeTaken();

					Duration d = Duration.between(time, LocalDateTime.now());
					if (d.getSeconds() > secForThisBook) {
						int sec = (int) (d.getSeconds() - secForThisBook);

						Double money = ((100.0 + (double) sec) / 100.0) * r.getPrice();
						synchronized (materialsToFollow) {
							materialsToFollow.put(r, money);
						}
						
					}
				} catch (LibraryException e) {
					e.printStackTrace();
				}

			}
		}
	}

	public Double getHowMuchIHaveToPayForThis(ReadingMaterial rm) {
		return materialsToFollow.get(rm);
	}

	public void addMaterialToWatch(ReadingMaterial readingMaterial) {
		try {
			synchronized (materialsToFollow) {
				materialsToFollow.put(readingMaterial, readingMaterial.getPrice());
			}
			
		} catch (LibraryException e) {
			e.printStackTrace();
		}

	}

	public void removeMaterialsToWatch(ReadingMaterial readingMaterial) {
		if (readingMaterial != null && materialsToFollow.containsKey(readingMaterial)) {
			synchronized (materialsToFollow) {
				materialsToFollow.remove(readingMaterial);
			}
			
		}
	}

	public int getNumberOfTakenMaterials() {
		return materialsToFollow.size();
	}

	public SortedSet<ReadingMaterial> getMaterialsByDate() {
		TreeSet<ReadingMaterial> set = new TreeSet<ReadingMaterial>(
				(r1, r2) -> r1.getTimeTaken().compareTo(r2.getTimeTaken()));
		set.addAll(materialsToFollow.keySet());
		return set;
	}
	
	public SortedSet<ReadingMaterial> getMaterialsOverDue() {
		TreeSet<ReadingMaterial> set = new TreeSet<ReadingMaterial>(
				(r1, r2) -> materialsToFollow.get(r1).compareTo(materialsToFollow.get(r2)));
		set.addAll(materialsToFollow.keySet());
		return set;
	}
	

}
