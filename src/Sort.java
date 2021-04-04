import java.util.Comparator;

public class Sort implements Comparator<Web>{
	public int compare(Web a,Web b) {
		return (int)(b.score - a.score);
	}
}