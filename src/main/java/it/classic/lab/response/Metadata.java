package it.classic.lab.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Metadata (@JsonProperty("current_offset") int currentOffset,
                        @JsonProperty("total_count") int totalCount){}
