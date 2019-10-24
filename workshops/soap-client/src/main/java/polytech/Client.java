package polytech;

import mypackage.*;

public class Client {
    public static void main(String args[]){
        BooksPortService booksPortService = new BooksPortService();
        GetBooksRequest getBooksRequest = new GetBooksRequest();
        GetBooksResponse booksResponse = booksPortService.getBooksPortSoap11().getBooks(getBooksRequest);

        System.out.println("test");
        System.out.println("Get Books Resquest");
        booksResponse.getBook().stream().forEach(el -> {
            System.out.println("Id: "+ el.getId());
            System.out.println("Name: "+ el.getName());
            System.out.println("Publisher: "+ el.getPublisher());
            System.out.println("Number Of pages: "+ el.getNumberOfPages());
            System.out.println("-----------------------------------------");
        });
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");

        GetBookRequest getBookRequest = new GetBookRequest();
        getBookRequest.setId(2);
        GetBookResponse bookResponse =  booksPortService.getBooksPortSoap11().getBook(getBookRequest);
        System.out.println("Get Book     Resquest");
        System.out.println("Id: "+ bookResponse.getBook().getId());
        System.out.println("Name: "+ bookResponse.getBook().getName());
        System.out.println("Publisher: "+ bookResponse.getBook().getPublisher());
        System.out.println("Number Of pages: "+ bookResponse.getBook().getNumberOfPages());

    }
}
