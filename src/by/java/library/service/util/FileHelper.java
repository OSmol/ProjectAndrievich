package library.service.util;

import library.bean.Book;
import library.bean.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    private static String userFile = "src/by/resources/library/Users.txt";
    private static String catalogFile = "src/by/resources/library/Books.txt";

    public static List<User> loadUsers() {
        String line;
        String splitBy = " - ";
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(userFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                User user = new User(data[1], data[2]);
                user.setName(data[0]);
                user.setUserRole(User.UserRole.valueOf(data[3].toUpperCase()));
                users.add(user);

            }
        } catch (IOException e) {
          //
        }
        return users;
    }

    public static void saveUserList(List<User> users) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(userFile))) {
            for (User user : users) {
                String sb = user.getName() + " - " + user.getLogin() + " - " + user.getPassword() + " - " + user.getUserRole().name().toLowerCase();
                bw.write(sb);
                bw.newLine();
            }

        } catch (IOException e) {
          //
        }
    }

    public static List<Book> loadBooks() {
        String line;
        String splitBy = " - ";
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(catalogFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                Book book = new Book();
               // book.setAuthor(data[0]);
                book.setTitle(data[1]);
                book.setYear(Integer.parseInt(data[2]));
              //  book.setBookType(Book.BookType.valueOf(data[3].toUpperCase()));
                        //build();
                books.add(book);
            }
        } catch (IOException e) {
           //
        }
        return books;
    }

    public static void saveLibrary(List<Book> books) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(catalogFile))) {
            for (Book book : books) {
                StringBuilder sb = new StringBuilder();
                sb.append(book.getAuthor());
                sb.append(" - ");
                sb.append(book.getTitle());
                sb.append(" - ");
                sb.append(book.getYear());
                sb.append(" - ");
              //  sb.append(book.getBookType().name().toLowerCase());

                bw.write(sb.toString());
                bw.newLine();
            }
        } catch (IOException e) {
           //
        }
    }
}


