package com.wefox.lab.geoservice.service;


import io.quarkus.test.Mock;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@Mock
@ApplicationScoped
public class MockGeoService extends GeoService {

    @Override
    public Uni<List<CountryView>> countries(String lang, int offset, int limit) {
        return Uni.createFrom().item(() ->
                List.of(new CountryView(
                        "it",
                                "italia", "39", false),
                        new CountryView("de",
                                "germania", "49", false)));
    }
}
