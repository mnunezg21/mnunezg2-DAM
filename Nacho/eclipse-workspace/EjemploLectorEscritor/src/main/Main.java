package main;

public class Main{
	

	public static void main(String args[])
	{
		Book book=new Book("The Alchemist");
	
		BookReader johnReader=new BookReader(book);
		BookReader arpitReader=new BookReader(book);
	
		Thread johnThread=new Thread(johnReader,"John");
		Thread arpitThread=new Thread(arpitReader,"Arpit");
	
		arpitThread.start();
		johnThread.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BookWriter bookWriter=new BookWriter(book);
		Thread bookWriterThread=new Thread(bookWriter);
		bookWriterThread.start();
	}
}