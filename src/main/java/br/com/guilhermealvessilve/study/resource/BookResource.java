package br.com.guilhermealvessilve.study.resource;

import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Path("/book")
public class BookResource {

    private static final List<String> BOOKS;

    static {
        BOOKS = new CopyOnWriteArrayList<>();
        BOOKS.add("The Freelancer's bible");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBooks() {
        return StringUtils.join(",", BOOKS);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addBook(String book) {
        BOOKS.add(book);
        return book;
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateBook(
            @PathParam("id") Integer index,
            String book
    ) {
        BOOKS.remove((int) index);
        BOOKS.add(index, book);
        return book;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteBook(@PathParam("id") Integer index) {
        return BOOKS.remove((int) index);
    }
}
