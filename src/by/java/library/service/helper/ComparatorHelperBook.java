package library.service.helper;

import library.bean.Book;

import java.util.Comparator;

public class ComparatorHelperBook implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getId()-o2.getId();
    }
}
