package library.dao.impl.txt;

import library.bean.Book;
import library.dao.BookDAO;
import library.dao.exception.DAOException;

import java.io.*;

//сериализация
public class TxtBookDAO implements BookDAO {
    private static final String BOOKFILE = " ";


    @Override
    public boolean addBook(Book book) throws DAOException, IOException {

        boolean b = false;
        File file = new File(BOOKFILE);
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (fileOutputStream != null) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(book);
                b = true;
            }
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
        return b;
    }


    @Override
    public void deleteBook(long idBook) throws DAOException {

    }

    @Override
    public void deleteBook(Book book) throws DAOException {

    }

    @Override
    public Book getBook(int idBook) throws DAOException, InvalidObjectException {
        // public Book deserialization(String filename) throws InvalidObjectException {
        File file = new File(BOOKFILE);
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (Book) objectInputStream.readObject();
        } catch (ClassNotFoundException ce) {
            System.err.println("Класс не существует: " + ce);
        } catch (FileNotFoundException e) {
            System.err.println("Файл для десериализации не существует: " + e);
        } catch (InvalidClassException ioe) {
            System.err.println("Несовпадение версий классов: " + ioe);
        } catch (IOException ioe) {
            System.err.println("Общая IO ошибка: " + ioe);
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                System.err.println("ошибка закрытия потока ");
            }
        }
        throw new InvalidObjectException("объект не восстановлен");
    }


    @Override
    public void getAllBooks(Book book) throws DAOException {

    }

    @Override
    public void updateBook(Book book) throws DAOException {

    }


}
