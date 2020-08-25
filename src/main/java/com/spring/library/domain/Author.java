package com.spring.library.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "author", schema = "public")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class Author {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private Date birthday;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> books;

    @Override
    public String toString() {
        return name;
    }

}
