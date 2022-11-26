/**
 * COPYRIGHT. Vialogic Private Ltd 2022. ALL RIGHTS RESERVED.
 * This software is only to be used for the purpose of which it has been provided. No part of it is to be reproudced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer language in any way or for any other purposes whatsoever without the prior
 * written consent of Vialogic Private Ltd.
 */


package com.greedycode.authorservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "author")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Author {

    @Id
    private Long authorId;
    private String authorName;
    private Long bookCount;
    private String authorAddress;
}
