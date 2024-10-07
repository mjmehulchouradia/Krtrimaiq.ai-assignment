package com.krtrimaIQ.assignment.mainPKG.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krtrimaIQ.assignment.mainPKG.Model.Author;


@Repository

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
