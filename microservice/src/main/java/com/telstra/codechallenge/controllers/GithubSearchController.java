package com.telstra.codechallenge.controllers;

import com.telstra.codechallenge.exceptions.ApplicationException;
import com.telstra.codechallenge.models.GithubSearchOldestAccountsResponse;
import com.telstra.codechallenge.models.GithubSearchLatestReposResponse;
import com.telstra.codechallenge.service.GithubSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GithubSearchController {

    @Autowired
    private GithubSearchService githubSearchService;

    @GetMapping("/githubSearch/latest")
    public ResponseEntity<GithubSearchLatestReposResponse> getLatestRepositories(@RequestParam(value = "count", defaultValue = "3")
                                                                                  String count) throws Exception {
       return new ResponseEntity<>(githubSearchService.getGithubSearchLatest(count), HttpStatus.OK);
    }

    @GetMapping("/githubSearch/oldest")
    public ResponseEntity<GithubSearchOldestAccountsResponse> getOldestRepositoriesWithZeroFollowers(@RequestParam(value = "count", defaultValue = "3")
                                                                              String count) throws Exception {
        return new ResponseEntity<>(githubSearchService.getGithubSearchOldest(count), HttpStatus.OK);
    }
}
