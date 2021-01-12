package com.solodovnikov.model.entity;
import javax.persistence.*;

@Table(name = "guest")
@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "state_of_account")
    private Integer stateOfAccount;

    public Guest() {

    }

    public Guest(String firstName, String lastName, Integer stateOfAccount) {
        this(-1, firstName, lastName, stateOfAccount);
    }

    public Guest(Integer id, String firstName, String lastName, Integer stateOfAccount) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stateOfAccount = stateOfAccount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getStateOfAccount() {
        return stateOfAccount;
    }

    public void setStateOfAccount(Integer stateOfAccount) {
        this.stateOfAccount = stateOfAccount;
    }

    @Override
    public String toString() {
        return  "\n==========================" +
                "\nid=" + id + "\nfirstName=" + firstName + "\nlastName=" + lastName + "\nstateOfAccount=" + stateOfAccount;
    }
}