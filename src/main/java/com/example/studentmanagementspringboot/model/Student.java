package com.example.studentmanagementspringboot.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String phone;

    private String img;

    @ManyToOne
    @JoinColumn(name = "classes_id")
    private Classes classes;

    public Student() {
    }

    public Student(String name, String address, String phone, String img, Classes classes) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.img = img;
        this.classes = classes;
    }

    public Student(Long id, String name, String address, String phone, String img, Classes classes) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.img = img;
        this.classes = classes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
