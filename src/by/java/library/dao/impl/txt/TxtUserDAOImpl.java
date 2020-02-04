package library.dao.impl.txt;

import library.bean.User;
import library.dao.UserDAO;
import library.dao.exception.DAOException;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class TxtUserDAOImpl implements UserDAO {
    private static final String USERS_TXT = "src/by/resources/library/Users.txt";
    private static Logger logger = Logger.getLogger(TxtUserDAOImpl.class);


    @Override
    public List<User> getUsers() throws DAOException {
        return (List<User>) readFile();
    }

    @Override
    public void add(User user) throws DAOException {
        List<User> list = getUsers();
        // List<User>list = new ArrayList<>();
        if (list == null || list.isEmpty()) {
            int generateId = 1;
            user.setId(generateId);
            List<User> users = new ArrayList<>();
            users.add(user);
            writeFile(users);
        } else {
            int generate = generateIdUser(list);
            user.setId(generate);
            list.add(user);
            writeFile(list);
        }
    }

    @Override
    public void delete(String login) throws DAOException {
        List<User> list = getUsers();
        if (list == null || list.isEmpty()) {
            throw new DAOException("List is empty");
        } else {
            Iterator<User> iterator = list.iterator();
            if (iterator.hasNext()) {
                do {
                    User user = iterator.next();
                    if (Objects.equals(user.getLogin(), login)) {
                        iterator.remove();
                    }
                } while (iterator.hasNext());
            }
            writeFile(list);
        }
    }

    @Override
    public void deleteUser(User user) throws DAOException {
        List<User> list = getUsers();
        if (list == null || list.isEmpty()) {
            throw new DAOException("List is empty");
        } else {
            list.remove(user);
        }
        writeFile(list);
    }


    @Override
    public User getUser(String login) throws DAOException {
        List<User> list = getUsers();
        if (list == null || list.isEmpty()) {
            throw new DAOException("List is empty");
        } else {
            for (User user : list) {
                String loginName = user.getLogin();
                if (login.equals(loginName)) {
                    return user;
                }
            }
        }
        return null;//замена на Optional.null (Java8), тк нельзя возвращать null из метода, тк может привести к NullPointer
    }

    @Override
    public void update(User user) throws DAOException {
        List<User> list = getUsers();
        if (list == null || list.isEmpty()) {
            throw new DAOException("List is empty");
        } else {
            int idUser = user.getId();
            for (int i = 0; i < list.size(); i++) {
                User user1 = list.get(i);
                if (user1.getId() == idUser) {
                    user1.setLogin(user.getLogin());
                    user1.setPassword(user.getPassword());
                    user1.setName(user.getName());
                    user1.setUserRole(user.getUserRole());
                    user1.setLocale(user.getLocale());
                    user1.setEmail(user.getEmail());
                    user1.setId(user.getId());

                }
            }
        }
        writeFile(list);
    }

    public List<User> readFile() throws DAOException {
        File file = new File(USERS_TXT);
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<User>) objectInputStream.readObject();
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

    public boolean writeFile(List<User> list) throws DAOException {
        boolean b = false;
        File file = new File(USERS_TXT);
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            if (fileOutputStream != null) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(list);
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


