package com.telstra.codechallenge.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GithubSearchLatestReposItems {

    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("watchers_count")
    private int watchersCount;
    private String language;
    private String description;
    private String name;

}
