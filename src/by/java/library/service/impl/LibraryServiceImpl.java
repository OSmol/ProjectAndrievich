package library.service.impl;

import library.bean.*;
import library.dao.exception.DAOException;
import library.dao.factory.DAOFactory;
import library.service.LibraryService;
import library.service.exception.ServiceException;
import library.service.util.FileHelper;
import library.service.util.InputUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {
    private static Logger logger = Logger.getLogger(LibraryServiceImpl.class);
    private final DAOFactory daoFactory = DAOFactory.getInstance();

    public static boolean printBooks(List<Book> books) {
        if(books.size() != 0) {
            int page = 1;
            int booksOnPage = 5;
            int numberOfPages = books.size() / booksOnPage + 1;
            while (page > 0 && page <= numberOfPages) {
                System.out.println("Page " + page + " of " + numberOfPages + ":");
                int i = page * booksOnPage - booksOnPage;
                for (; i < page * booksOnPage && i < books.size(); i++) {
                    System.out.print(i + 1 + " ");
                    System.out.println(getBookLine(books.get(i)));
                }
                System.out.print("Enter page number or 0 to exit: ");
                page = InputUtil.checkPageNumber();
            }
        }
        return false;
    }

    public static boolean addBook(Library library, Book book) {
        if (!library.getBooks().contains(book)) {
            library.getBooks().add(book);
            FileHelper.saveLibrary(library.getBooks());
            for (User user : users) {
                if (!user.getUserRole().getName().equals("admin")) {
                    Letter letter = new Letter(user.getEmail(), user.getEmail(), book);
                    letter.sendLetter();
                    System.out.println("Letter sent to " + user.getName());
                }
            }
            return true;
        }
        return false;
    }

    public static boolean suggestBook(Library library, Book book) {
        if (!library.getBooks().contains(book)) {
            Letter letter = new Letter(user.getEmail(), library.getUser().getEmail(), book);
            return letter.sendLetter();
        }
        return false;
    }

    public static boolean removeBook(Library library, Book book) {
        if (library.getBooks().remove(book)) {
            FileHelper.saveLibrary(library.getBooks());
            return true;
        } else {
            return false;
        }
    }

    public static String getBookLine(Book book) {
        return String.format("%s, \"%s\", %d year, type: %s",
                book.getAuthor(), book.getTitle(),
                book.getYear(), book.getBookType().getName());
    }

    public static Book createBook() {
       Book book=new Book();
        System.out.print("Enter the name of the author: ");
     //   book.setAuthor(InputUtil.checkInputLine());
        System.out.print("Enter a title for the book: ");
        book.setTitle(InputUtil.checkInputLine());
        System.out.print("Enter the year the book was published: ");
        book.setYear(InputUtil.checkInputYear());
        System.out.print("Enter the type number of the book: 1 - e-book, 2 - paper book:");
        book.setBookType(InputUtil.checkInputBookType());
        return book;
    }

    public static boolean findBook(Library library) {
        List<Book> books = null;

        System.out.print("Enter \"1\" to search by author or \"2\" to search by name: ");
        int request = InputUtil.checkInputChoice(User.UserRole.USER);
        if (request == 1) {
            System.out.print("Enter author name: ");
            String author = InputUtil.checkInputLine();
            books = BookServiceImpl.findBookByAuthor(library.getBooks(), author);
        } else if (request == 2) {
            System.out.print("Enter book title: ");
            String title = InputUtil.checkInputLine();
            books = BookServiceImpl.findBookByName(library.getBooks(), title);
        } else { return false;}
        if(books.size() != 0) {
            LibraryServiceImpl.printBooks(books);
        } else {
            System.out.println("Book not found. Perhaps the request is incorrect.");
        }
        return true;
    }



    public List<Book> findBookByName(String nameBook) throws ServiceException {//возвр лист
        logger.debug("BookServiceImpl.findBookByName - run");
        List<Book> listBooksByName = new ArrayList<>();
        try {
            List<Book> list = daoFactory.getTxtBookDAO().getBooks();
            for (Book book : list) {
                String title = book.getTitle();
                if (title.equalsIgnoreCase(nameBook)) {
                    listBooksByName.add(book);
                }
            }
            return listBooksByName;
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("BookServiceImpl.findBookByName - Book found");
        }
    }


    public List<Book> findBookByAuthor(String authorBook) throws ServiceException {
        logger.debug("BookServiceImpl.findBookByAuthor - run");
        List<Book> listBooksByAuthor = new ArrayList<>();
        try {
            List<Book> list = daoFactory.getTxtBookDAO().getBooks();
            for (Book book : list) {
                String author = book.getAuthor().getSurname();
                if (author.equalsIgnoreCase(authorBook)) {
                    listBooksByAuthor.add(book);
                }
            }
            return listBooksByAuthor;
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("BookServiceImpl.findBookByAuthor - Book found");
        }
    }



    public List<Book> findBookByGenre(Genre genre) throws ServiceException {
        logger.debug("BookServiceImpl.findBookByGenre - run");
        List<Book> listBooksByGenre = new ArrayList<>();
        try {
            List<Book> list = daoFactory.getTxtBookDAO().getBooks();
            for (Book book : list) {
                for (Genre genreName : book.getGenres()) {
                    if (genre.getName().equalsIgnoreCase(genreName.getName())) {
                        listBooksByGenre.add(book);
                    } else {
                        logger.debug("BookServiceImpl.findBookByGenre - Book not found");
                    }
                }
            }
            return listBooksByGenre;
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("BookServiceImpl.findBookByGenre - Book found");
        }
    }


    public List<Book> sortBookByName() throws ServiceException {
        logger.debug("BookServiceImpl.sortBookByName - run");
        List<Book> list;
        try {
            list = daoFactory.getTxtBookDAO().getBooks();
            list.sort(new Book.NameComparator());
            return list;
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("BookServiceImpl.sortBookByName - Book sort");
        }
    }


    @Override
    public List<Book> sortBookByYear() throws ServiceException {
        logger.debug("BookServiceImpl.sortBookByYear - run");
        List<Book> list;
        try {
            list = daoFactory.getTxtBookDAO().getBooks();
            list.sort(new Book.YearComparator());
            return list;
        } catch (DAOException e) {
            throw new ServiceException(e);
        } finally {
            logger.debug("BookServiceImpl.sortBookByYear - Book sort");
        }
    }

    @Override
    public List<Book> sortBookByRating(double averageMark) throws ServiceException {
        return null;
    }
}
