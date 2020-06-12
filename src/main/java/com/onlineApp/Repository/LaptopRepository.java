//package com.onlineApp.Repository;
//
//import com.onlineApp.Model.Laptop;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//import java.util.List;
//
//public interface LaptopRepository extends CrudRepository<Laptop, Long> {
////    List<Laptop> findAllLaptopByCustomerId(long id);
//
//    @Query("select laptop from Laptop laptop where laptop.customer.id = ?1")
//    List<Laptop> findAllLaptopByUserId(long id);
//}
