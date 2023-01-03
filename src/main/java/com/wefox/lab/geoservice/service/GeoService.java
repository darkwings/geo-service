package com.wefox.lab.geoservice.service;

import com.wefox.lab.geoservice.model.Country;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class GeoService {

    /**
     * Super basic implementation with the filter per language in place. Evaluate a join
     *
     * @param lang   the language
     * @param offset the offset
     * @param limit  the limit
     * @return a list of {@link CountryView}s, with names resolved in the requested language
     */
    public Uni<List<CountryView>> countries(String lang, int offset, int limit) {
        Objects.requireNonNull(lang, "lang cannot be null");
        return Country.listAll().map(l -> {
            var list = new ArrayList<CountryView>();
            l.forEach(c -> {
                var country = (Country) c;
                country.getNames().stream().filter(d -> d.getLanguageId().equals(lang))
                        .findFirst().ifPresent(localizedData ->
                                list.add(new CountryView(country.getCountryId(),
                                        localizedData.getData(),
                                        country.getPhoneCode())));
            });
            return list;
        });
    }
}
