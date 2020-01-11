package library.dao.impl.txt;

import library.bean.Book;
import library.bean.User;
import library.dao.UserDAO;
import library.dao.exception.DAOException;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.List;

public class TxtUserDAOImpl implements UserDAO {
    private static final String BOOKFILE = "src/by/resources/library/Data.txt";
    private static Logger logger = Logger.getLogger(TxtUserDAOImpl.class);


    @Override
    public List<User> getAll() throws DAOException {
        return (List<User>) readFile();
    }

    @Override
    public void add(User user) throws DAOException {
        if (user.getId() != 0) {
            throw new DAOException("book have id and cant be add in list");
        }
        List<User> list = getAll();
        if (list == null || list.isEmpty()) {
            int generateId = 1;
            user.setId(generateId);
            list.add(user);
            writeUserInFile(user);
        }
    }

    @Override
    public void delete(String login) throws DAOException {
        List<User> list = getAll();
        if (list == null || list.isEmpty()) {
            throw new DAOException("List is empty");
        } else {
            for (User user : list) {
                String login1 = user.getLogin();
                if (login1.equals(login)) {
                    list.remove(user);
                }
            }
        }
    }

    @Override
    public void delete(User user) throws DAOException {
        List<User> list = getAll();
        if (list == null || list.isEmpty()) {
            throw new DAOException("List is empty");
        } else {
            list.remove(user);
        }
        writeListInFile(list);
    }

    @Override
    public User get(String login) throws DAOException {
        List<User> list = getAll();
        if (list == null || list.isEmpty()) {
            throw new DAOException("List is empty");
        } else {
            for (User user : list) {
                String loginName = user.getLogin();
                if (loginName == login) {
                    return user;
                }
            }
        }
        return null;
    }

    @Override
    public void update(User user) throws DAOException {
        List<User> list = getAll();
        if (list == null || list.isEmpty()) {
            throw new DAOException("List is empty");
        } else {
            int idUser = user.getId();
            for (User user1 : list) {
                if (user1.getId() == idUser) {
                    user1 = user;
                }
            }
        }
        writeListInFile(list);
    }

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

    private void writeUserInFile(User user) throws DAOException {
        File file = new File(BOOKFILE);
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);

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

    private void writeListInFile(List<User> list) throws DAOException {
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


