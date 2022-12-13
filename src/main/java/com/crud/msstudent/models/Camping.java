package com.crud.msstudent.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "camping")
public class Camping implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_camping;

    private String description;

    private int nbr_etoille;

    private int nbr_place_dispo;

    private int nbr_place_reserve;

    private String prix;

    private String date_debut;

    private String date_fin;

    private String localisation;

    private int idOrganisateur;

    private int etat;


}
