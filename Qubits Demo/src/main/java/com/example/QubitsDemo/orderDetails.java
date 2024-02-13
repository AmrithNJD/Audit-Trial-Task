package com.example.QubitsDemo;


import jakarta.persistence.*;

@Entity
@Table(name = "coustomerDetailsT")
public class orderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }

    private int age;
    private String orderItem;
    @OneToOne(mappedBy = "id")
    private customerDetails orderid;

    public customerDetails getOrderid() {
        return orderid;
    }

    public void setOrderid(customerDetails orderid) {
        this.orderid = orderid;
    }
}
