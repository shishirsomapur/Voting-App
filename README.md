# Voting Application

## Overview
This Voting Application allows multiple users to enter candidates, cast votes, and retrieve information about votes and winners. It utilizes local variables to store data, simulating a database. The application provides a RESTful API that handles concurrent requests from multiple users.

## Features Implemented
1. **Enter Candidate**
    - **Endpoint**: `POST /entercandidate`
    - **Parameters**:
        - `name` (String): The name of the candidate to be added.
    - **Functionality**: Adds a candidate to the system with an initial vote count of 0. If the candidate already exists, a message is returned indicating that.

2. **Cast Vote**
    - **Endpoint**: `PUT /castvote`
    - **Parameters**:
        - `name` (String): The name of the candidate to vote for.
    - **Functionality**: Increments the vote count for the specified candidate. If the candidate does not exist, an error message is returned.

3. **Count Vote**
    - **Endpoint**: `GET /countvote`
    - **Parameters**:
        - `name` (String): The name of the candidate whose votes are to be counted.
    - **Functionality**: Returns the current vote count for the specified candidate. If the candidate does not exist, an error message is returned.

4. **List Votes**
    - **Endpoint**: `GET /listvote`
    - **Functionality**: Returns a JSON representation of all candidates and their corresponding vote counts. If there are no candidates, an appropriate message is returned.

5. **Get Winner**
    - **Endpoint**: `GET /getwinner`
    - **Functionality**: Returns the name of the candidate with the highest number of votes. If there are no candidates, an appropriate message is returned.

## Usage Guide

### Prerequisites
- Ensure you have Java installed.
- Make sure you have Maven configured for dependency management.

### Running the Application
1. Clone the repository or download the project files.
2. Navigate to the project directory in your terminal.
3. Compile and run the application using:
   ```bash
   mvn clean install
   mvn spring-boot:run
