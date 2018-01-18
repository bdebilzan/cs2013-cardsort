package cs2013.edu;

public class App {
	//duplicates cards
	void duplicate(Deck<Card> src, Deck<Card> dest) {
		for(Card card: src.getCards()){
			dest.addCard(card);
		}
	}
	
	//quickSort
	public long runTest(final int deckSize, final boolean validateFlag) {
		Deck<Card> d1 = new Deck<Card>();
		Deck<Card> d2 = new Deck<Card>();
		
		//fill decks
		for (int i = 0; i < deckSize; i++) {
			Card card = new Card((int)(Math.random() * 52));
			d1.addCard(card);
		}

		if (validateFlag) {
			duplicate(d1, d2);
	
			d2.quickSort();
		}
		
		d1.shuffle();
		
		final long start = System.currentTimeMillis();
		d1.quickSort();
		final long stop = System.currentTimeMillis();
		final long total = stop - start;
		

		if (validateFlag) {
			assert(d1.isEqual(d2, d1));
		}
		
		return total;
	}
	
	//bubbleSort
	public long runTest2(final int deckSize, final boolean validateFlag) {
		Deck<Card> d1 = new Deck<Card>();
		Deck<Card> d2 = new Deck<Card>();
		
		//fill decks
		for (int i = 0; i < deckSize; i++) {
			Card card = new Card((int)(Math.random() * 52));
			d1.addCard(card);
		}
		
		//1st time validateflag = true -> runs
		if (validateFlag) {
			duplicate(d1, d2);
			
			d2.bubbleSort();
		}
		
		d1.shuffle();

		final long start = System.currentTimeMillis();
		d1.bubbleSort();
		final long stop = System.currentTimeMillis();
		final long total = stop - start;
		
		if (validateFlag) {
			assert(d1.isEqual(d2, d1));
		}
		
		return total;
	}
	
	//insertionSort
	public long runTest3(final int deckSize, final boolean validateFlag) {
		Deck<Card> d1 = new Deck<Card>();
		Deck<Card> d2 = new Deck<Card>();
		
		//fill decks
		for (int i = 0; i < deckSize; i++) {
			Card card = new Card((int)(Math.random() * 52));
			d1.addCard(card);
		}
		
		//1st time validateflag = true -> runs
		if (validateFlag) {
			duplicate(d1, d2);
			
			d2.insertionSort();
		}
		
		d1.shuffle();

		final long start = System.currentTimeMillis();
		d1.insertionSort();
		final long stop = System.currentTimeMillis();
		final long total = stop - start;

		if (validateFlag) {
			assert(d1.isEqual(d2, d1));
		}
		
		return total;
	}
	
	//check to see if all sorts are working properly
	public void checkToSeeIfAllSortsWorking(final int deckSize, final boolean validateFlag) {
		Deck<Card> d1 = new Deck<Card>();
		Deck<Card> d2 = new Deck<Card>();
		Deck<Card> d3 = new Deck<Card>();

		//fill decks
		for (int i = 0; i < deckSize; i++) {
			Card card = new Card((int)(Math.random() * 52));
			d1.addCard(card);
		}
		
		if (validateFlag) {
			duplicate(d1, d2);
			duplicate(d1, d3);
		}
		
		d1.shuffle();
		d2.shuffle();
		d3.shuffle();

		d1.quickSort();
		d2.bubbleSort();
		d3.insertionSort();
		

		if (validateFlag) 
		{
			assert(d1.isEqual(d2, d1));
			assert(d1.isEqual(d3, d1));
		}
	}

	public static void main(String[] args) {
		App app = new App(); 
		
		//quickSort
		{
			System.out.println("Times for quickSort");
			final boolean validate = true;
			final int deckSize = 200; //change to 200!
			final long time = app.runTest(deckSize, validate);
			System.out.println("time: " + time + " (<-Deck size of 200)");
		}
		
		{
			final boolean validate = false;
			for (int i = 1; i < 6; i++) {
				final int deckSize = (int) Math.pow(10, i);
				final long time = app.runTest(deckSize, validate);
				System.out.println(deckSize + " " + time);
			}
		}
		
		//bubbleSort
		{
			System.out.println("");
			System.out.println("Times for bubbleSort");
			final boolean validate = true;
			final int deckSize = 200;
			final long time = app.runTest2(deckSize, validate);
			System.out.println("time: " + time + " (<-Deck size of 200)");
		}
		{
			final boolean validate = false;
			for (int i = 1; i < 6; i++) {
				final int deckSize = (int) Math.pow(10, i);
				final long time = app.runTest2(deckSize, validate);
				System.out.println(deckSize + " " + time);
			}
		}
		
		//insertionSort
		{
			System.out.println("");
			System.out.println("Times for insertionSort");
			final boolean validate = true;
			final int deckSize = 200;
			final long time = app.runTest3(deckSize, validate);
			System.out.println("time: " + time + " (<-Deck size of 200)");
		}
		{
			final boolean validate = false;
			for (int i = 1; i < 6; i++) {
				final int deckSize = (int) Math.pow(10, i);
				final long time = app.runTest3(deckSize, validate);
				System.out.println(deckSize + " " + time);
			}
		}
		
		//check to see if all sorts are working
		{
			System.out.println("");
			System.out.println("Check to see if all sorts are working:");
			final boolean validate = true;
			final int deckSize = 500;
			app.checkToSeeIfAllSortsWorking(deckSize, validate);
			System.out.println("All sorts working");
		}
	}
}