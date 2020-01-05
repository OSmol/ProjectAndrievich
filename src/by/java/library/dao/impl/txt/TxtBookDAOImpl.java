package library.dao.impl.txt;

import library.bean.Book;
import library.dao.BookDAO;
import library.dao.exception.DAOException;
import library.service.impl.txt.TxtBookServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TxtBookDAOImpl implements BookDAO {
    private static final String BOOKFILE = "src/by/resources/library/Input.txt";
    private static Logger logger = Logger.getLogger(TxtBookDAOImpl.class);

    private Object readFile() throws DAOException {
        File file = new File(BOOKFILE);
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
        } catch (ClassNotFoundException ce) {
            throw new DAOException("Класс не существует", ce);
        } catch (FileNotFoundException e) {
            throw new DAOException("Файл для десериализации не существует: ", e);
        } catch (InvalidClassException ioe) {
            throw new DAOException("Несовпадение версий классов: ", ioe);
        } catch (IOException ioe) {
            throw new DAOException("Общая IO ошибка: ", ioe);
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();

                } catch (IOException e) {
                    logger.info("Error");
                }
            }
        }
    }

    private void writeFile(List<Book> books) throws DAOException {
        File file = new File(BOOKFILE);
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(books);

        } catch (NotSerializableException e) {
            throw new DAOException("file don't suggesting serialization" + e);
        } catch (IOException e) {
            throw new DAOException("file cant be create" + e);
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    //
                }
            }
        }
    }

    @Override
    public List<Book> getBooks() throws DAOException {
        return (List<Book>) readFile();
    }

    @Override
    public void addBook(Book book) throws DAOException {
        if (book.getId() != 0) {
            throw new DAOException("book have id and cant be add in list");
        }
        List<Book> list = getBooks();

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
            throw new DAOException("List empty");
        } else {
            for (Book book : list) {
                long idName = book.getId();
                if (idName == idBook) {
                    list.remove(book);
                }
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
            int bookId = book.getId();
            for (Book book1 : list) {
                if (book1.getId() == bookId) {
                    book1 = book;
                }
            }
        }
        writeFile(list);
    }
}
