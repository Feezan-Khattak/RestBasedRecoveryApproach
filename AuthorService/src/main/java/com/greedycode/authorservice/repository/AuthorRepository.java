/**
 * COPYRIGHT. Vialogic Private Ltd 2022. ALL RIGHTS RESERVED.
 * This software is only to be used for the purpose of which it has been provided. No part of it is to be reproudced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer language in any way or for any other purposes whatsoever without the prior
 * written consent of Vialogic Private Ltd.
 */

package com.greedycode.authorservice.repository;

import com.greedycode.authorservice.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByAuthorName(String authorName);
}
