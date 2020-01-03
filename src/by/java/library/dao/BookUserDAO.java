package library.dao;

import library.bean.Book;
import library.bean.User;

import java.util.ArrayList;
import java.util.List;

public class BookUserDAO {

    public BookUserDAO() {
    }

    public void createUser(User user, Book book){
        List<User>users = new ArrayList<>();
        List<Book>books = new ArrayList<>();
        users.add(user);
        books.add(book);
        book.setUsers(users);
        user.setBooks(books);
//сохранить изменения в базу данных + эксепшены
    }

    public void loadUsersByName(String userName){
        List<User>users = new ArrayList<>();
        if(users.size()==0){
            //логировать то что ниже
            //юзеры не найдены
        }
        for (User user:users){
            //логировать то что ниже
            user.getName();
            for (Book book: user.getBooks()){
                //логировать то что ниже
                book.getTitle();
            }
        }
    }

}
