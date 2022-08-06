package ljk.dao;

import ljk.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {

    List<Book> selectAll();
    Book selectById(@Param("id") int id);
    void insert(Book book);

    void update(Book book);

    void delete(int barCode);
}
