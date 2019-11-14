package emailapp;

public class EmailApp {
	
	public static void main(String[] args) {
			// TODO Auto-generate method stub
		Email em1 = new Email("John", "Smith");
		
		// em1.setAlternateEmail("yy@gmail.com");
		// System.out.println("Alternate Mail: " + em1.getAlternateEmail());
		
		System.out.println(em1.showInfo());
		
	}
}