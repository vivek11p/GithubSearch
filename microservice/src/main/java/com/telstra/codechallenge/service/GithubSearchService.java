package com.telstra.codechallenge.service;

import com.telstra.codechallenge.exceptions.ApplicationException;
import com.telstra.codechallenge.exceptions.InvalidRequestException;
import com.telstra.codechallenge.models.GithubSearchOldestAccountsResponse;
import com.telstra.codechallenge.models.GithubSearchLatestReposResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class GithubSearchService {

    @Value("${githubSearch.base.url}")
    private String githubSearchBaseUrl;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private RestTemplate restTemplate;

    public GithubSearchLatestReposResponse getGithubSearchLatest(String count) throws Exception{
        if(Integer.parseInt(count)>100)
        {
            throw new InvalidRequestException("The number of repositories to return should be equal to or less than 100");
        }
        String date = getLastWeekDate();
        try{
            GithubSearchLatestReposResponse res = restTemplate.getForObject(String.format("%s/repositories?q=created:>%s&sort=stars&order=desc&per_page=%s",githubSearchBaseUrl,date,count), GithubSearchLatestReposResponse.class);
            return res;
        }catch (Exception aex){
            throw new ApplicationException("Error occured while fetching data from Github Api Service. Please try again after some time");
        }
    }

    public GithubSearchOldestAccountsResponse getGithubSearchOldest(String count) throws Exception{
        if(Integer.parseInt(count)>100)
        {
            throw new InvalidRequestException("The number of accounts to return should be equal to or less than 100");
        }
        try{
            GithubSearchOldestAccountsResponse res = restTemplate.getForObject(String.format("%s/users?q=followers:0&sort=joined&order=asc&per_page=%s",githubSearchBaseUrl,count), GithubSearchOldestAccountsResponse.class);
            return res;
        }catch (Exception aex){
            throw new ApplicationException("Error occured while fetching data from Github Api Service.Please try again after some time");
        }
    }

    private String getLastWeekDate(){
        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDateTime now = LocalDateTime.now();
        return now.minusDays(7).format(format);
    }
}
