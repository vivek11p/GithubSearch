package com.telstra.codechallenge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GithubSearchLatestReposResponse {

    private List<GithubSearchLatestReposItems> items;

}
