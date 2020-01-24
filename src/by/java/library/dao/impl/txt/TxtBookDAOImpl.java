package library.dao.impl.txt;

import library.bean.Book;
import library.bean.User;
import library.dao.BookDAO;
import library.dao.exception.DAOException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtBookDAOImpl implements BookDAO {
    private static final String BFILE = "src/by/resources/library/Books.txt";
    private static Logger logger = Logger.getLogger(TxtBookDAOImpl.class);

    public List<Book> readFile() throws DAOException {
        File file = new File(BFILE);
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

    public boolean writeFile(List<Book> books) throws DAOException {
        boolean b = false;
        File file = new File(BFILE);
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

    public void createUser(User user, Book book) {
        List<User> users = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        users.add(user);
        books.add(book);
        // book.setUsers(users);

//сохранить изменения в базу данных + эксепшены
    }

    public void loadUsersByName(String userName) {
        List<User> users = new ArrayList<>();
        if (users.size() == 0) {
            //логировать то что ниже
            //юзеры не найдены
        }
        for (User user : users) {
            //логировать то что ниже
            user.getName();
          //  for (Book book : user.getBooks()) {
                //логировать то что ниже
              //  book.getTitle();
            }
        }
    }
//}
