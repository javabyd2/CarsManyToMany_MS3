package com.ManyToMany.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Cars {
    @Override
    public String toString() {
        return "{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_Id")
    private int carId;
    @Column(name = "car_brand")
    private String brand;
    @Column(name = "year")
    private String year;
    @ManyToMany(mappedBy = "carsSet", cascade = CascadeType.ALL)
    Set<Users> usersSet = new HashSet<>();

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Set<Users> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(Set<Users> usersSet) {
        this.usersSet = usersSet;
    }
}
