package com.crud.msstudent.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_user;
    
    @NotEmpty(message = "nom is required")
    private String nom;
    
    @NotEmpty(message = "prenom is required")
    private String prenom;

    private String cin;

    private String photo;

    private String email;

    private String motPasse;

    private String sex;

    private String date_naissance;

    private String tel;

    private String type_user;

}
