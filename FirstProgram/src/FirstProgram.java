
public class FirstProgram {
	public static void main(String[] args)
	{
		System.out.println("Hello out there.");
		System.out.println("Want to talk some more?");
		System.out.println("Answer y for yes or n for no.");
		
		char answerLetter;
		answerLetter = SavitchIn.readLineNonwhiteChar();
		if(answerLetter == 'y')
			System.out.println("Nice weather we are having.");
		System.out.println("Good-bye");
		
		System.out.println("Press Enter key to end program.");
		String junk;
		junk = SavitchIn.readLine();
			
	}
}
