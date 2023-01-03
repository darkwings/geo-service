package com.wefox.lab.geoservice;

import com.wefox.lab.geoservice.service.CountryView;
import com.wefox.lab.geoservice.service.GeoService;
import com.wefox.lab.response.Metadata;
import com.wefox.lab.response.Response;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Path("/geo")
@ApplicationScoped
public class GeoResource {

    @Inject
    GeoService geoService;

    @GET
    @Path("countries")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response<List<CountryView>>> countries(@QueryParam("lang") String lang,
                                                      @QueryParam("offset") int offset,
                                                      @QueryParam("limit") int limit) {
        var realLang = Optional.ofNullable(lang).orElse("it"); // TODO manage default language

        return geoService.countries(realLang, offset, limit)
                .map(list -> new Response<>(list,
                        emptyList(), // TODO
                        new Metadata(0, list.size()))); // TODO
    }
}
