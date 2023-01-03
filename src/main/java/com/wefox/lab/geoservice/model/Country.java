package com.wefox.lab.geoservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wefox.lab.localization.LocalizedData;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Cacheable
public class Country extends PanacheEntity {


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "country_localization",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "local_id")
    )
    private Set<LocalizedData> names;

    /**
     * The ISO code of the country
     */
    @Column(name = "country_id", length = 10, unique = true)
    @JsonProperty("country_id")
    private String countryId;

    /**
     * The phone code
     */
    @Column(name = "phone_code", length = 5)
    @JsonProperty("phone_code")
    private String phoneCode;

    @JsonProperty
    private boolean deleted;

    public Country() {
    }

    public Country(Set<LocalizedData> names, String countryId, String phoneCode) {
        this.names = names;
        this.countryId = countryId;
        this.phoneCode = phoneCode;
    }

    public Set<LocalizedData> getNames() {
        return names;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
