package library.dao.impl.txt;

import library.bean.User;
import library.dao.UserDAO;
import library.dao.exception.DAOException;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TxtUserDAOImpl implements UserDAO {
    private static final String BOOKFILE = "src/by/resources/library/Books.txt";
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
            list = new ArrayList<>();
            user.setId(generateId);
            list.add(user);
            writeFile(list);
        } else {
            int generate = generateIdUser(list);
            user.setId(generate);
            list.add(user);
            writeFile(list);
        }
    }

    @Override
    public void delete(String login) throws DAOException {
        List<User> list = getAll();
        if (list == null || list.isEmpty()) {
            throw new DAOException("List is empty");
        } else {
            Iterator<User> iterator = list.iterator();
            if (iterator.hasNext()) {
                do {
                    User user = iterator.next();
                    if (user.getLogin().equalsIgnoreCase(login)) {
                        iterator.remove();
                    }
                } while (iterator.hasNext());
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
        writeFile(list);
    }

    @Override
    public User get(String login) throws DAOException {
        List<User> list = getAll();
        if (list == null || list.isEmpty()) {
            throw new DAOException("List is empty");
        } else {
            for (User user : list) {
                String loginName = user.getLogin();
                if (loginName.equals(login)) {
                    return user;
                }
            }
        }
        return null;//замена на Optional.null (Java8), тк нельзя возвращать null из метода, тк может привести к NullPointer
    }

    @Override
    public void update(User user) throws DAOException {
        List<User> list = getAll();
        if (list == null || list.isEmpty()) {
            throw new DAOException("List is empty");
        } else {
            int idUser = user.getId();
            for (int i = 0; i < list.size(); i++) {
                User user1 = list.get(i);
                if (user1.getId() == idUser) {
                    list.set(i, user1);
                }
            }
        }
        writeFile(list);
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

    private void writeFile(List<User> list) throws DAOException {
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

    private int generateIdUser(List<User> list) {
        int max = list.get(0).getId();
        for (User user : list) {
            if (user.getId() > max) {
                max = user.getId();
            }
        }
        return max + 1;
    }
}


