public class CardCatalog {

	private Card[] titleList;
	private Card[] authorList;
	private Card[] subjectList;

	private final int SIZE = 10;
	private int cardCount;

	public CardCatalog() {
		titleList = new Card[SIZE];
		authorList = new Card[SIZE];
		subjectList = new Card[SIZE];
		cardCount = 0;
	}

	public void addACard(Card card) {
		if(cardCount < SIZE) {
			addToTitleList(card);
			addToAuthorList(card);
			addToSubjectList(card);
			cardCount++;
		}
	}

	public void removeATitle(String title) {
		if(cardCount > 0) {
			Card card = getATitle(title);
			if(card != null) {
				removeFromList(titleList, card);
				removeFromList(authorList, card);
				removeFromList(subjectList, card);
				cardCount--;
			}
		}
	}

	private void growArray() {
		SIZE = SIZE * 2;
		Card[] newArray = new Card[SIZE];
		System.arraycopy(titleList, 0, newArray, 0, cardCount);
		titleList = newArray;
		newArray = new Card[SIZE];
		System.arraycopy(authorList, 0, newArray, 0, cardCount);
		authorList = newArray;
		newArray = new Card[SIZE];
		System.arraycopy(subjectList, 0, newArray, 0, cardCount);
		subjectList = newArray;
	}

	private void removeFromList(Card[] list, Card card) {
		boolean found = false;
		for(int i = 0, j = 0; i < cardCount; i++) {
			Card c = list[i];
			if(c == card) {
				found = true;
				list[i] = null;
				j = i;
			}
			if(found && i > j)
				list[i - 1] = list[i];
		}
		list[cardCount - 1] = null;
	}

	private void addToTitleList(Card card) {
		for(int i = 0; i < cardCount; i++) {
			String title = titleList[i].getTitle();
			if(card.getTitle().compareTo(title) < 0) {
				Card temp = titleList[i];
				titleList[i] = card;
				card = temp;
			}
		}
		titleList[cardCount] = card;
	}

	private void addToAuthorList(Card card) {
		for (int i = 0; i < cardCount; i++) {
			String author = authorList[i].getAuthor();
			if(card.getAuthor().compareTo(author) < 0) {
				Card temp = authorList[i];
				authorList[i] = card;
				card = temp;
			}
		}
		authorList[cardCount] = card;
	}

	private void addToSubjectList(Card card) {
		for(int i = 0; i < cardCount; i++) {
			String subject = subjectList[i].getSubject();
			if(card.getSubject().compareTo(subject) < 0) {
				Card temp = subjectList[i];
				subjectList[i] = card;
				card = temp;
			}
		}
		subjectList[cardCount] = card;
	}

	// this method is not as per the specfication
	public void printTheCatalog() {
		System.out.println(cardCount);
		System.out.println("Printing title list");
		for(int i = 0; i < titleList.length; i++)
			System.out.println(titleList[i]);
		System.out.println("\nPrinting author list");
		for(int i = 0; i < authorList.length; i++)
			System.out.println(authorList[i]);
		System.out.println("\nPrintln subject list");
		for(int i = 0; i < subjectList.length; i++)
			System.out.println(subjectList[i]);
	}

	public Card getATitle(String title) {
		for(int i = 0; i < cardCount; i++) {
			Card card = titleList[i];
			if(card.getTitle().equals(title))
				return card;
		}
		return null;
	}

	public Card[] getAnAuthor(String author) {
		Card[] cards = null;
		for(int i = 0, j=0; i < cardCount; i++) {
			Card card = authorList[i];
			if(card.getAuthor().equals(author)) {
				if(cards == null)  cards = new Card[SIZE];
				cards[j++] = card;
			}
		}
		return cards;
	}

	public Card[] getSubject(String subject) {
		Card[] cards = null;
		for(int i = 0, j=0; i < cardCount; i++) {
			Card card = subjectList[i];
			if(card.getSubject().equals(subject)) {
				if(cards == null)  cards = new Card[SIZE];
				cards[j++] = card;
			}
		}
		return cards;
	}
}
