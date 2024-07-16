package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column
    private int age;

    public User() {}

    public User(String email, String name, String lastName, int age) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    @Override
    public String toString() {
        return "User [id = " + id + ", email = " + email + ", name = " + name + ", lastName = "
                + lastName + ", age = " + age + "]";
    }
}
