package library.serializator;

import library.bean.Book;

import java.io.*;
//Сериализация в файл с помощью класса ObjectOutputStream
public class Serializator {
    public boolean serialization(Book book, String filename) {
        boolean b = false;
        File file = new File(filename);
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (fileOutputStream != null) {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(book);
                b = true;
            }
        } catch (FileNotFoundException e) {
            System.err.println("file cant be create" + e);
        } catch (NotSerializableException e) {
            System.err.println("file don't suggesting serialization" + e);
        } catch (IOException e) {
            System.err.println("file cant be create" + e);
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                System.err.println("error of closing stream" + e);
            }
        }
        return b;
    }

    public Book deserialization(String filename) throws InvalidObjectException {
        File file = new File(filename);
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            Book book = (Book) objectInputStream.readObject();
            return book;
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
}
