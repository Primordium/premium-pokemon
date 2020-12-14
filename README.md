# Premium-Pokemon


## Building

    ```sh
    $ mvn assembly:single
    ```
## Testing
    
    ```sh
    $ mvn test
    ```

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
