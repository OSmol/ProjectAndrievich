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
            throw new DAOException("Файл для десериализации не существует: ",e);
        } catch (InvalidClassException ioe) {
            throw new DAOException("Несовпадение версий классов: ",ioe);
        } catch (IOException ioe) {
            throw new DAOException("Общая IO ошибка: ",ioe);
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
