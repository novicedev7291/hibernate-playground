package com.example.model.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="profile",
        uniqueConstraints = @UniqueConstraint(columnNames = "discordId")
)
public class Profile implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProfile;
    private Date birthday;
    private String discordId;
    private String description;
    @ElementCollection(fetch= FetchType.EAGER)
    private Set<String> spokenLanguages = new LinkedHashSet<String>();

    @OneToOne(mappedBy="profile")
    private UserDetail userDetail;


}