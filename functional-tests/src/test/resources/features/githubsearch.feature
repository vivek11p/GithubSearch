  Feature: As an api user I want to retrieve data from github api

    Scenario: Get a list of the highest starred repositories in the last week with default count value
      When I get the service uri githubSearch/latest
      Then the service uri returns status code 200
      And the content type is json
      And the body has json path $ of type object
      And the body has json path $.items of type array
      And the body has response size as 3
      And the body has json path $.items[0].html_url of type string
      And the body has json path $.items[0].watchers_count of type numeric
      And the body has json path $.items[0].language of type string
      And the body has json path $.items[0].description of type string
      And the body has json path $.items[0].name of type string

    Scenario: Get a list of the highest starred repositories in the last week with user defined count value
      When I get the service uri githubSearch/latest?count=4
      Then the service uri returns status code 200
      And the content type is json
      And the body has json path $ of type object
      And the body has json path $.items of type array
      And the body has response size as 4
      And the body has json path $.items[0].html_url of type string
      And the body has json path $.items[0].watchers_count of type numeric
      And the body has json path $.items[0].language of type string
      And the body has json path $.items[0].description of type string
      And the body has json path $.items[0].name of type string

    Scenario: Find the oldest accounts with zero followers with default count value
      When I get the service uri githubSearch/oldest
      Then the service uri returns status code 200
      And the content type is json
      And the body has json path $ of type object
      And the body has json path $.items of type array
      And the body has response size as 3
      And the body has json path $.items[0].html_url of type string
      And the body has json path $.items[0].id of type numeric
      And the body has json path $.items[0].login of type string

    Scenario: Get a list of the highest starred repositories in the last week with user defined count value
      When I get the service uri githubSearch/oldest?count=4
      Then the service uri returns status code 200
      And the content type is json
      And the body has json path $ of type object
      And the body has json path $.items of type array
      And the body has response size as 4
      And the body has json path $.items[0].html_url of type string
      And the body has json path $.items[0].id of type numeric
      And the body has json path $.items[0].login of type string
