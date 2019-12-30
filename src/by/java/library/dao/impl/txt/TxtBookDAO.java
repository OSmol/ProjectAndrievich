package library.dao.impl.txt;

import library.bean.Book;
import library.dao.BookDAO;
import library.dao.exception.DAOException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//сериализация
public class TxtBookDAO implements BookDAO {
    private static final String BOOKFILE = "src/by/resources/library/Input.txt";


    public List<Book> createListOfBooks() {
        List<Book> books = new ArrayList<>();
        File file = new File(BOOKFILE);
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(books);

        } catch (NotSerializableException e) {
            System.err.println("file don't suggesting serialization" + e);
        } catch (IOException e) {
            System.err.println("file cant be create" + e);
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    ///
                    System.err.println("error of closing stream" + e);
                }
            }

        }
        return books;
    }

    public List<Book> getBooks() throws DAOException {// public Book deserialization(String filename) throws InvalidObjectException {

        File file = new File(BOOKFILE);
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
                    System.err.println("ошибка закрытия потока ");
                }
            }
        }
    }

    @Override
    public void addBook(Book book) throws DAOException {
        List<Book> list = getBooks();
        if (list == null) {
            List<Book> books = new ArrayList<>();
            books.add(book);
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

        } else {
            list.add(book);
            File file = new File(BOOKFILE);
            ObjectOutputStream objectOutputStream = null;
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(list);

            } catch (NotSerializableException e) {
                throw new DAOException("file don't suggesting serialization" + e);
            } catch (IOException e) {
                throw new DAOException("file cant be create" + e);
            } finally {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                        ///
                        System.err.println("error of closing stream" + e);
                    }
                }
            }
        }
    }
/*
читаю
получаю лист
если лист пустой, создаю лист и доб его в файл
если лист не пустой, то добавляю книгу в лист, записываю лист в файл
 */


    @Override
    public void deleteBook(long idBook) throws DAOException {

    }

    @Override
    public void deleteBook(Book book) throws DAOException {

    }

    @Override
    public Book getBook(int idBook) throws DAOException {
        // public Book deserialization(String filename) throws InvalidObjectException {
        File file = new File(BOOKFILE);
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (Book) objectInputStream.readObject();
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
                    System.err.println("ошибка закрытия потока ");
                }
            }
        }
    }


    @Override
    public void getAllBooks(Book book) throws DAOException {

    }

    @Override
    public void updateBook(Book book) throws DAOException {

    }


}
