# Premium-Pokemon

Exposes a rest endpoints for queries in https://rapidapi.com/theapiguy/api/free-nba/endpoints and a mysql or h2 database running in parallelly

## Building

    ```sh
    $ mvn assembly:single
    ```
## Testing
    
    ```sh
    $ mvn test
    ```

   - root: api/nbadb
   - GET  "/" -> Intructions
   - GET  "/date/{date}" with yyyy-MM-dd format searches for games the date provided;
   - GET  "/game/{gameId}" searches for games with id provided;
   - POST "comments/{gameId}" Creates a new comment for the game with the id provided;
   - PUT  "comments/{commentId}" Edits the comment with the provided comment id;
   - DELETE "comments/{commentId}" Deletes a comment with the provided comment id;

## How to run

After building the project :
    ```sh
    $ cd target
    $ java -jar pokemon.jar
    ```

## Usage

Console will ask for a string input with directions (N,S,E,O), which correspond to cardinal points, 
after the user inputs a string it will calculate how many pokemons Ash caught.

examples
```sh
$ Please input a string of Movements
$ NS
$ 2
```
