package lesson160405;

public class BookExamples {
	
	static class Book{
		String title;
		int[] pageCounts;	//сколько томов с int-страницами
		double height;
		
		public Book(String title, int[] pageCounts, double height) {
			super();
			this.title = title;
			this.pageCounts = pageCounts;
			this.height = height;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int[] getPageCounts() {
			return pageCounts;
		}

		public void setPageCounts(int[] pageCounts) {
			this.pageCounts = pageCounts;
		}

		public double getHeight() {
			return height;
		}

		public void setHeight(double height) {
			this.height = height;
		}
		
	}
	
	public static void main(String[] args) {
		
		Book b1 = new Book("Sherlock Holmes", new int[] {256}, 25.5);
		Book b2 = new Book("Tom Sawyer", new int[] {300}, 20.5);
		Book b3 = new Book("War and Peace", new int[] {500, 450, 300, 600}, 50.0);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
