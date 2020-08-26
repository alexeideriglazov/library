package com.spring.library.spring.repository;

import com.spring.library.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByNameContainingIgnoreCaseOrAuthorNameContainingIgnoreCaseOrderByName(String bookName, String authorName);

    Page<Book> findByNameContainingIgnoreCaseOrAuthorNameContainingIgnoreCaseOrderByName(String bookName, String authorName, Pageable pageable);

    @Query("select new com.spring.library.domain.Book(b.id, b.name, b.pageCount, b.isbn, b.genre, b.author, b.publisher, b.publishYear, b.image, b.descr, b.viewCount, b.totalRating, b.totalVoteCount, b.avgRating) from Book b")
    Page<Book> findAllWithoutContent(Pageable pageable);

    @Modifying(clearAutomatically = true)
    @Query("update Book b set b.content=:content where b.id=:id")
    void updateContent(@Param("content") byte[] content, @Param("id") int id);

    //for top list books we need only to show image
    @Query("select new com.spring.library.domain.Book(b.id, b.image) from Book b")
    List<Book> findTopBooks(Pageable pageable);

    //search by genre
    @Query("select new com.spring.library.domain.Book(b.id, b.name, b.pageCount, b.isbn, b.genre, b.author, b.publisher, b.publishYear, b.image, b.descr, b.viewCount, b.totalRating, b.totalVoteCount, b.avgRating) from Book b where b.genre.id=:genreId")
    Page<Book> findByGenre(@Param("genreId") int genreId, Pageable pageable);

    //get content by book id
    @Query("select b.content from Book b where b.id=:id")
    byte[] getContent(@Param("id") int id);

    @Modifying
    @Query("update Book b set b.viewCount=:viewCount where b.id =:id")
    void updateViewCount(@Param("viewCount") int viewCount, @Param("id") int id);

    @Modifying
    @Query("update Book b set b.totalVoteCount=:totalVoteCount, b.totalRating=:totalRating, b.avgRating=:avgRating where b.id =:id")
    void updateRating(@Param("totalRating") int totalRating, @Param("totalVoteCount") int totalVoteCount, @Param("avgRating") int avgRating, @Param("id") int id);

}
