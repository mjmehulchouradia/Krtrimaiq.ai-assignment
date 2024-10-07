package com.krtrimaIQ.assignment.mainPKG.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krtrimaIQ.assignment.mainPKG.Model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
