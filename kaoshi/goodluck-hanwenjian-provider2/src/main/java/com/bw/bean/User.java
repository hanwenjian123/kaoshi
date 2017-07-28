package com.bw.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by ${hanwenjian} on 2017/7/28.
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "uid")
    private int uid;

    @Column(name = "uname")
    private String uname;

    @Column(name = "upwd")
    private String upwd;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "tou")
    private String tou;

    @Column(name = "hobby")
    private String hobby;

}
