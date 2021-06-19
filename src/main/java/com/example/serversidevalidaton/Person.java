/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 6/19/2021
 *   Time: 5:22 AM
 *   File: Person.java
 */

package com.example.serversidevalidaton;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Person {

    @NotBlank(message = "this field cannot be blank")
    private String email;
    @NotBlank(message = "this field cannot be blank")
    @Size(min = 8, max = 15, message = "password must contain 8 to 15 character")
    private String password;
    @AssertTrue(message = "please check the checkbox")
    private boolean check;

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", check=" + check +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return isCheck() == person.isCheck() && Objects.equals(getEmail(), person.getEmail()) && Objects.equals(getPassword(), person.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPassword(), isCheck());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public Person() {
    }

    public Person(String email, String password, boolean check) {
        this.email = email;
        this.password = password;
        this.check = check;
    }
}