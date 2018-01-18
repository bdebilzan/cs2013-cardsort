package cs2013.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck<E extends Comparable <E>> {
	private ArrayList<Card> dataCollection = new ArrayList<Card>();
	
	public void addCard(Card card){
		dataCollection.add(card);
	}
	public void shuffle(){
		Collections.shuffle(dataCollection);
	}
	public ArrayList<Card> getCards(){
		return dataCollection;
	}
	public int getSize(){
		return dataCollection.size();
	}
	public Card removeRear(){
		Card card = null;
		if(!dataCollection.isEmpty()){
			Card newCard = dataCollection.get(0);
			dataCollection.remove(0);
			return newCard;
		}
		else
			return card;
	}
	public Card insertFront(Card card){
		dataCollection.set(dataCollection.size() - 1,card);
		return card;
	}	
	public  void quickSort(){
		quickSort(dataCollection,0,dataCollection.size()-1);
	}
	public void quickSort(ArrayList<Card> dataCollection, int first,int last){
		if(last > first){
			int pivotIndex = partition(dataCollection,first,last);
			quickSort(dataCollection,first,pivotIndex - 1);
			quickSort(dataCollection,pivotIndex + 1, last);
		}
	}
	
	public static int partition(ArrayList<Card> dataCollection, int first, int last){
		int low = first + 1;
		int high = last;
		Card pivot = dataCollection.get(first);
		
		while(high > low){
			
			while(low<= high && dataCollection.get(low).compareTo(pivot) <= 0)
				low++;
			
			while(low<= high && dataCollection.get(high).compareTo(pivot)>= 0)
				high--;
				
			if(high > low){
					
				Card temp = dataCollection.get(high);
				dataCollection.set(high, dataCollection.get(low));
				dataCollection.set(low, temp);
				}
		}
		
		while(high > first && dataCollection.get(high).compareTo(pivot) >=0)
			high--;
			if(pivot.compareTo(dataCollection.get(high)) >= 0){
				dataCollection.set(first,dataCollection.get(high));
				dataCollection.set(high, pivot);
				return high;
			}
			else{
				return first;
			}
	}
	
	public void bubbleSort()
	{
		bubbleSort(dataCollection);
	}
	
	
	public void bubbleSort(ArrayList<Card> dataCollection)
	{
		boolean needNextPass = true;
		
		for(int k = 1; k < dataCollection.size() && needNextPass; k++)
		{
			needNextPass = false;
			
			for(int i = 0; i < dataCollection.size() - k; i++)
			{
				if (dataCollection.get(i).compareTo(dataCollection.get(i + 1)) >= 0)
						{
							Card temp = dataCollection.get(i);
							dataCollection.set(i, dataCollection.get(i+1));
							dataCollection.set(i + 1, temp);

							needNextPass = true;
						}
			}
		}
	}
	
	public void insertionSort()
	{
		insertionSort(dataCollection);
	}
	
	public void insertionSort(ArrayList<Card> dataCollection)
	{
		for (int i = 1; i < dataCollection.size(); i++)
		{
			Card currentElement = dataCollection.get(i);
			int k;
			for(k = i - 1; k >= 0 && dataCollection.get(k).compareTo(currentElement) >= 0; k--)
			{
				dataCollection.set(k + 1, dataCollection.get(k));
			}
			
			dataCollection.set(k + 1, currentElement);
		}
	}
	
	public boolean isEqual(Deck<Card> otherDeck, Deck<Card> otherDeck2){	
		
		Object[] array1 = new Object[otherDeck.getSize()];
		Object[] array2 = new Object[otherDeck2.getSize()];
		
		int index = 0;	
		 
		//fills array1 w/ otherDeck (d2)
		for (Card card : otherDeck.getCards()) {
		  array1[index] = card;
		  index++;
		}

		index = 0;
		
		//fills array2 w/ otherDeck2 cards (d1)
		for (Card card : otherDeck2.getCards()) {
		  array2[index] = card;
		  index++;
		}

		
		String objectAsString1 = Arrays.toString(array1);
		String objectAsString2 = Arrays.toString(array2);
		
		if(objectAsString1.equals(objectAsString2))
		{
			return true;
		}
		else
		{
			return false;
		}	
	}
}
