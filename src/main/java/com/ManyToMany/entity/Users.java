package com.ManyToMany.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id")
    private int userId;
    @Column(name = "user_name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @ManyToMany(cascade = CascadeType.ALL)

    @JoinTable(name = "users_of_cars",
            joinColumns = @JoinColumn(name = "user_Id"),
            inverseJoinColumns = @JoinColumn(name = "car_Id")

    )

    private Set<Cars> carsSet = new HashSet<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Cars> getCarsSet() {
        return carsSet;
    }

    public void setCarsSet(Set<Cars> carsSet) {
        this.carsSet = carsSet;
    }
}
