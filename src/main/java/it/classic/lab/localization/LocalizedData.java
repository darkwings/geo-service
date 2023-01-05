package it.classic.lab.localization;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Cacheable
@Table(name = "localized_data")
public class LocalizedData extends PanacheEntity {

    @Column(name = "language_id")
    private String languageId; // SupportedLanguage?

    @Column(name = "data")
    private String data;

    public LocalizedData() {
    }

    public LocalizedData(String languageId, String data) {
        this.languageId = languageId;
        this.data = data;
    }

    public String getLanguageId() {
        return languageId;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "LocalizedData{" +
                "languageId='" + languageId + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
