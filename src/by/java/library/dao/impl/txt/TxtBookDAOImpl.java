package library.dao.impl.txt;

import library.bean.Book;
import library.dao.BookDAO;
import library.dao.exception.DAOException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtBookDAOImpl implements BookDAO {
    private static final String BOOKFILE = "src/by/resources/library/Input.txt";

    public List<Book> getBooks() throws DAOException {

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

    @Override
    public void editBook(Book book) throws DAOException {

    }


    @Override
    public void deleteBook(int idBook) throws DAOException {
        List<Book> list = getBooks();
        if (list == null) {
            throw new DAOException("List empty");
        } else {
            for (Book book : list) {
                long idName = book.getId();
                if (idName == idBook) {
                    list.remove(book);
                }
            }

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
                        //
                    }
                }
            }


        }
    }

    @Override
    public void deleteBook(Book book) throws DAOException {

    }

    @Override
    public Book getBook(int idBook) throws DAOException {
        return null;
    }



    @Override
    public void updateBook(Book book) throws DAOException {

    }


}
