package com.wujun.boot.controller;

import com.wujun.boot.domain.Book;
import com.wujun.boot.repository.BookRepository;
import com.wujun.common.responses.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Jun.Wu
 * @Date: 2020/6/4 14:44
 * @Description:
 */
@RestController
@RequestMapping("/v1/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping()
    public ApiResult<String> saveBook(@RequestBody Book book){
        return ApiResult.success(bookRepository.saveObj(book));
    }

    @GetMapping("/all")
    public ApiResult<List<Book>> findAll(){
        return ApiResult.success(bookRepository.findAll());
    }

    @GetMapping("/{id}")
    public ApiResult<Book> findOne(@PathVariable("id") String id){
        return ApiResult.success(bookRepository.findBookById(id));
    }

    @GetMapping("/name")
    public ApiResult<Book> findByName(@RequestParam("name") String name){
        return ApiResult.success(bookRepository.findBookByName(name));
    }

    @PutMapping()
    public ApiResult updateBook(@RequestBody Book book){
        return ApiResult.success(bookRepository.updateBook(book));
    }

    @DeleteMapping("/{id}")
    public ApiResult delById(@PathVariable("id") String id){
        return ApiResult.success(bookRepository.deleteBookById(id));
    }

    @GetMapping("/likes")
    public ApiResult<List<Book>> findByLikes(@RequestParam("search") String search){
        return ApiResult.success(bookRepository.findByLikes(search));
    }

}
