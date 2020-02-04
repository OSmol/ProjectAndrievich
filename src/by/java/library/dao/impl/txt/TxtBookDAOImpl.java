package library.dao.impl.txt;

import library.bean.Book;
import library.dao.BookDAO;
import library.dao.exception.DAOException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class TxtBookDAOImpl implements BookDAO {
    private static final String BOOKS_TXT = "src/by/resources/library/Books.txt";
    private static Logger logger = Logger.getLogger(TxtBookDAOImpl.class);
    private static TxtBookDAOImpl instance;

    private TxtBookDAOImpl() {
    }

    public static synchronized TxtBookDAOImpl getInstance() {
        if (instance == null) {
            instance = new TxtBookDAOImpl();
        }
        return instance;
    }

    public List<Book> readFile() throws DAOException {
        File file = new File(BOOKS_TXT);
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<Book>) objectInputStream.readObject();
        } catch (ClassNotFoundException ce) {
            throw new DAOException("Класс не существует", ce);
        } catch (FileNotFoundException e) {
            throw new DAOException("Файл для десериализации не существует: ", e);
        } catch (InvalidClassException ioe) {
            throw new DAOException("Несовпадение версий классов: ", ioe);
        } catch (InvalidObjectException e) {
            throw new DAOException("объект не восстановлен");
        } catch (IOException ioe) {
            throw new DAOException("Общая IO ошибка: ");
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                System.err.println("ошибка закрытия потока ");
            }
        }
    }

    public boolean writeFile(List<Book> books) throws DAOException {
        boolean b = false;
        File file = new File(BOOKS_TXT);
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            if (fileOutputStream != null) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(books);
                b = true;
            }
        } catch (NotSerializableException e) {
            throw new DAOException("file don't suggesting serialization" + e);
        } catch (IOException e) {
            throw new DAOException("file cant be create" + e);
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
//
            }
        }
        return b;
    }


    @Override
    public List<Book> getBooks() throws DAOException {
        return (List<Book>) readFile();
    }

    @Override
    public void addBook(Book book) throws DAOException {
        List<Book> list = getBooks();
        // List<Book> list = new ArrayList<>();
        if (list == null || list.isEmpty()) {
            int generateID = 1;
            book.setId(generateID);
            List<Book> books = new ArrayList<>();
            books.add(book);
            writeFile(books);
        } else {
            int generate = generateIdBook(list);
            book.setId(generate);
            list.add(book);
            writeFile(list);
        }
    }

    @Override
    public void deleteBook(int idBook) throws DAOException {
        List<Book> list = getBooks();
        if (list == null || list.isEmpty()) {
            throw new DAOException("List is empty");
        } else {
            Iterator<Book> iterator = list.iterator();
            if (iterator.hasNext()) {
                do {
                    Book book = iterator.next();
                    if (Objects.equals(book.getId(), idBook)) {
                        iterator.remove();
                    }
                } while (iterator.hasNext());
            }
            writeFile(list);
        }
    }

    private int generateIdBook(List<Book> list) {
        int max = list.get(0).getId();
        for (Book book : list) {
            if (book.getId() > max) {
                max = book.getId();
            }
        }
        return max + 1;
    }

    @Override
    public void deleteBook(Book book) throws DAOException {
        List<Book> list = getBooks();
        if (list == null || list.isEmpty()) {
            throw new DAOException("List empty");
        } else {
            list.remove(book);
        }
        writeFile(list);
    }

    @Override
    public Book getBook(int idBook) throws DAOException {
        List<Book> list = getBooks();
        if (list == null || list.isEmpty()) {
            throw new DAOException("List empty");
        } else {
            for (Book book : list) {
                long idName = book.getId();
                if (idName == idBook) {
                    return book;
                }
            }
        }
        return null;
    }


    @Override
    public void updateBook(Book book) throws DAOException {
        List<Book> list = getBooks();
        if (CollectionUtils.isNotEmpty(list)) {
            throw new DAOException("List empty");
        } else {
            for (int i = 0; i < list.size(); i++) {
                Book book1 = list.get(i);
                if (book1.getId() == book.getId()) {
                    book1.setId(book.getId());
                    book1.setTitle(book.getTitle());
                    book1.setPrice(book.getPrice());
                    book1.setDescription(book.getDescription());
                    book1.setLanguage(book.getLanguage());
                    book1.setCountOfPages(book.getCountOfPages());
                    book1.setIsbn(book.getIsbn());
                    book1.setPublishingHouse(book.getPublishingHouse());
                    book1.setYear(book.getYear());
                    book1.setAuthor(book.getAuthor());
                    book1.setAuthorOfTranslation(book.getAuthorOfTranslation());
                    book1.setCountry(book.getCountry());
                    book1.setGenre(book.getGenre());
                    book1.setCustomer(book.getCustomer());
                    list.add(book1);
                }
            }
        }
        writeFile(list);
    }
}


