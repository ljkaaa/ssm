package ljk.service;

import ljk.controller.Code;
import ljk.dao.BookDao;
import ljk.exception.BusinessException;
import ljk.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    BookDao bookDao;

    public List<Book> selectAll(){
        return bookDao.selectAll();
    }
    public Book selectById(int id){
        return bookDao.selectById(id);
    }

    public void update(Book book){
        bookDao.update(book);
    }

    public void delete(int barCode){
        bookDao.delete(barCode);
    }

    public void insert(Book book) {
        bookDao.insert(book);
    }
}
