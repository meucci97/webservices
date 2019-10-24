package org.polytech;

import io.spring.guides.gs_producing_web_service.GetBookRequest;
import io.spring.guides.gs_producing_web_service.GetBookResponse;
import io.spring.guides.gs_producing_web_service.GetBooksRequest;
import io.spring.guides.gs_producing_web_service.GetBooksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BookEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private BookRepository bookRepository;

    @Autowired
    public BookEndpoint(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "getBookRequest")
    @ResponsePayload
    public GetBookResponse getBook(@RequestPayload GetBookRequest request){
        GetBookResponse response = new GetBookResponse();
        response.setBook(bookRepository.findBook(request.getId()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBooksRequest")
    @ResponsePayload
    public GetBooksResponse getBooks(@RequestPayload GetBooksRequest request){
        GetBooksResponse response = new GetBooksResponse();
        response.getBook().addAll(bookRepository.getAllBooks());
        return response;
    }

}
