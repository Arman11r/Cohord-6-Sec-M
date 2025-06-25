package bookbuddy;
import java.util.*;
public class BooksBuddyyy {
  static ArrayList<String> bookshelf = new ArrayList<>();  
 
	static void addBook(String title, String author) {  
	    if (title.isEmpty() || author.isEmpty()) {  
	        System.out.println("Invalid input: Title or Author is empty.");  
	        return;  
	    }  
	    bookshelf.add(title + " - " + author);  
	}  

	
	static void sortBooksAlphabetically() {  
	    Collections.sort(bookshelf);  
	}  
	static void searchByAuthor(String author) {  
	    boolean found = false;  
	    for (String book : bookshelf) {  
	        String[] parts = book.split(" - ");  
	        if (parts.length == 2 && parts[1].equalsIgnoreCase(author)) {  
	            System.out.println(book);  
	            found = true;  
	        }  
	    }  
	    if (!found) System.out.println("No books found by " + author);  
	}  
	static void exportBooks() {  
	    String[] booksArray = bookshelf.toArray(new String[0]);  
	    System.out.println("Exported Books:");  
	    for (String book : booksArray) {  
	        System.out.println(book);  
	    }  
	}   
	public static void main(String[] args) {  
	    addBook("Harry Potter", "J.K. Rowling");  
	    addBook("The jungle book", "host story");  
	    addBook("1920 london", "George");  

	    sortBooksAlphabetically();  
	    exportBooks();  

	    System.out.println("\nSearching by Author:");  
	    searchByAuthor("George");  
	}
}

}
