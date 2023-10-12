# matawan installation
## Prerequisite
This project has been developed using Java 21 and includes some functionalities that are not supported by previous versions. Please make sure that you have at least Java 19 installed on your computer (version 19 or higher is preferred).

## Installation
To set up this project, follow these steps:

1. Import it as a Maven project into your IDE and wait for it to be synchronized.
2. If you are using Eclipse, you should install the Lombok JAR to allow Lombok annotations to be interpreted.
3. Run it in your Integrated Development Environment (IDE).
4. After that, you can manipulate the API as needed.

## Usage
This application exposes three endpoints:

1. **GET /api/teams**: This endpoint is used to retrieve all teams in the database, along with the associated players. It accepts three main request parameters:
   - `page`: Indicates the page to display, with a default value of 1 (items per page: 3).
   - `sortBy`: Specifies the attribute for sorting the results, with possible values being NAME (default), BUDGET, ACRONYM.
   - `sortType`: Specifies the sorting type (ascending, ASC by default, or descending, DESC).

2. **POST /api/teams**: This endpoint allows you to add a new team to the database, either with or without players. You should provide a JSON object of the Team as a request parameter.

3. **GET /api/teams/search**: Use this endpoint to perform searches on the teams. It accepts a `keyword` request parameter, which is used to search for team names and acronyms.
