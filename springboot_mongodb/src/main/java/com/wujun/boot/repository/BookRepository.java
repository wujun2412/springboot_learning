package com.wujun.boot.repository;

import com.mongodb.WriteResult;
import com.wujun.boot.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author: Jun.Wu
 * @Date: 2020/6/4 14:12
 * @Description:
 */
@Repository
public class BookRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存
     *
     * @param book
     * @return
     */
    public String saveObj(Book book) {
        Date now = new Date();
        book.setCreateTime(now);
        book.setUpdateTime(now);
        mongoTemplate.save(book);
        return "success";
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<Book> findAll() {
        List<Book> list = mongoTemplate.findAll(Book.class);
        return list;
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public Book findBookById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Book book = mongoTemplate.findOne(query, Book.class);
        return book;
    }

    /**
     * 根据name查询
     *
     * @param name
     * @return
     */
    public Book findBookByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        Book book = mongoTemplate.findOne(query, Book.class);
        return book;
    }

    /**
     * 更新对象
     * @param book
     * @return
     */
    public WriteResult updateBook(Book book) {
        Query query = new Query(Criteria.where("_id").is(book.getId()));
        Update update = new Update().set("publish", book.getPublish())
                .set("info", book.getInfo())
                .set("updateTime", new Date());
        // 更新查询返回结果集的第一条
        WriteResult result = mongoTemplate.updateFirst(query, update, Book.class);

        // 更新查询返回结果集的全部
        // mongoTemplate.updateMulti(query,update,Book.class);
        // 更新对象不存在则去添加
        // mongoTemplate.upsert(query, update,Book.class);
        return result;
    }

    /**
     * 删除对象
     * @param book
     * @return
     */
    public WriteResult deleteBook(Book book){
        WriteResult result = mongoTemplate.remove(book);
        return result;
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public WriteResult deleteBookById(String id){
        Book book = findBookById(id);
        WriteResult result = null;
        if (book != null){
            result= deleteBook(book);
        }
        return result;
    }

    /**
     * name 模糊查询
     * @param search
     * @return
     */
    public List<Book> findByLikes(String search){
        Query query = new Query();
        Pattern pattern = Pattern.compile("^.*" + search + ".*$" , Pattern.CASE_INSENSITIVE);
        Criteria criteria = Criteria.where("name").regex(pattern);
        query.addCriteria(criteria);
        List<Book> lists = mongoTemplate.findAllAndRemove(query, Book.class);
        return lists;
    }
}































