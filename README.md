# Weather-api-service-public microservice application
Develop, test and deploy a microservice to show the output of a city's (to be taken as an input parameter)
next 3 days high and low temperatures.
1. If rain is predicted in next 3 days or temperature goes above 40 degree Celsius then mention 'Carry umbrella'
   or 'Use sunscreen lotion' respectively in the output, for that day.
2. In case of high winds (i.e.,) Wind > 10mph, mention “It’s too windy, watch out!”
3. In case of Thunderstorms, mention “Don’t step out! A Storm is brewing!”
4. End user should be able to view results by changing the input parameters
5. The service should be accessible via web browser.
6. TODO The solution should support offline mode with toggles
7. TODO The service should return relevant results as expected, even while the underlying dependencies (Ex: Public API) are not available!

## API Data Sources
    APIs
    https://api.openweathermap.org/data/2.5/forecast?q=london&appid=apikey&cnt=10
    Documentation: https://openweathermap.org/api
    https://openweathermap.org/weather-conditions#Weather-Condition-Codes-2

## TODO NFRs
    • Demonstrate SOLID, 12 Factor and HATEOAS principles, Design Patterns in the design and implementation
    • Demonstrate Performance, Optimization & Security aspects
    • Demonstrate Production readiness of the code
    • Demonstrate TDD & BDD & Quality aspects
    • Demonstrate sensitive information used in the Micro Services such as API keys are protected / encrypted

## TODO Documentation
    • Include the open-API spec./Swagger to be part of the code. Should be able to view API via swagger (Documentation to explain the purpose of the API along with Error codes that the service consumers & client must be aware of!)
    • Create a README.md file in the repository and explain the design and implementation approach
    • In the README, add a sequence diagram or flowchart created using draw.io – https://www.draw.io
    • Mention the design patterns used in the code

## TODO Build & Deploy
    CI
    • Build CI/CD pipeline for your project(s); Pipeline scripts need to be part of the codebase;
    • Ensure the Jenkins job config., scripts are a part of the project sources
    CD
    • Demonstrate the service deployment using a Docker container (Create a docker image and publish service locally)
    • Ensure the docker files are a part of the project sources

