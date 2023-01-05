package it.classic.lab.response;

import java.util.List;

public record Response<T> (T data, List<Link> links, Metadata metadata) {}
