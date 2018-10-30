package devops.numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class NumberWordsApplication {
	private final NumberWords numberWords ;
	private final BufferedReader reader ;
	
	public NumberWordsApplication() {
		numberWords = new NumberWords() ;
		reader = new BufferedReader( new InputStreamReader( System.in ) ) ;
	}
	
	public void execute() {
		while( true ) {
			try {
				System.out.printf( "Enter number (0 to exit): " ) ;
				String value = reader.readLine() ;
				int number = Integer.parseInt( value ) ;
				if ( number == 0 ) {
					System.out.printf( "You Enter 0: Exiting..... \n" ) ;
					System.exit(0);
					} 
				else {
						String words = numberWords.toWords(number);
						System.out.printf("%s\n", words) ;
					}
			} catch ( NumberFormatException | IOException e ) {
				System.out.println( "Invalid number" ) ;
			}
		}
	}

	public static void main(String[] args) {
		new NumberWordsApplication().execute() ;
	}

}
