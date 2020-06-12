//package com.onlineApp.Model;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//@Entity
//public class Laptop {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long laptopId;
//    @NotNull
//    @Size(min = 2, max = 12)
//    private String laptopName;
//    @ManyToOne
//    private Customer customer;
//
//}
