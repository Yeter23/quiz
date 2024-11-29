package com.yeter.quiz.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity

@Data

@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
private Long  id;
@Column
@NotNull(message = "ad ad mutleqdir")
@NotBlank(message = "adi  bos qoymaq olmaz")
@Size(min = 2,max = 10,message = "adinizi dogru yazin")
private String username;
    @Column
    @NotNull(message = "soyad ad mutleqdir")
    @NotBlank(message = "soyadi  bos qoymaq olmaz")
    @Size(min = 2,max = 20,message = "soyadinizi dogru yazin")
private String usersurname;
@Column
@NotNull(message = "parol mutleqdir")
@NotBlank(message = "parolu bos qoymaq olmaz")
private String password;
@Column
@NotNull(message = "email mutleqdir")
@NotBlank(message = "emali bos qoymaq olmaz")
private String email;
@Column
private  boolean isAdmin;
    public Users(Long id, String username, String password, String email, boolean isAdmin) {
        super();
        this.id = id;
        this.username = username;
        this.usersurname=usersurname;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsersurname() {
        return usersurname;
    }

    public void setUsersurname(String usersurname) {
        this.usersurname = usersurname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Users() {
        super();
    }
}
