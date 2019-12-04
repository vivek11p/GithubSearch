package com.telstra.codechallenge.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GithubSearchOldestAccountsItems {

    private int id;
    private String login;
    @JsonProperty("html_url")
    private String htmlUrl;

}
