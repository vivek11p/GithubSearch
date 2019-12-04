package com.telstra.codechallenge.models;

import lombok.Data;

import java.util.List;

@Data
public class GithubSearchOldestAccountsResponse {

    private List<GithubSearchOldestAccountsItems> items;

}
