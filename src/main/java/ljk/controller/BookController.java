package ljk.controller;


import ljk.pojo.Book;
import ljk.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ljk.controller.Code.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public Result selectAll(){
        List<Book> books = bookService.selectAll();
        int code = books != null? SELECT_OK : SELECT_ERR;
        String msg = code == SELECT_ERR? "查询失败，请再次尝试" : "";
        return new Result(code,books,msg);
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable int id){
        Book book = bookService.selectById(id);
        int code = book != null? SELECT_OK : SELECT_ERR;
        String msg = code == SELECT_ERR? "查询失败，请再次尝试" : "";
        return new Result(code,book,msg);
    }

    @PutMapping
    public Result update(@RequestBody Book book){
        bookService.update(book);
        return new Result(UPDATE_OK,null,"ok");
    }

    @DeleteMapping("/{id}")
    public Result Delete(@PathVariable int id){
        bookService.delete(id);
        return new Result(UPDATE_OK,null,"ok");
    }
}
