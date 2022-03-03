package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String lines = "";
        try (BufferedReader br = new BufferedReader(new FileReader("pokemoniKoda.txt"))) {


            String s;
            while ((s = br.readLine()) != null) {
                lines += s + "\n";
            }
        } catch (Exception e) {
            System.out.println("Chyba při čtení ze souboru.");
        }

        String[] line = lines.split("\n");

        var pokemoni = Arrays.stream(lines.split("\n")).map(radka -> {
            String[] splitLine = radka.split(",");
            Pokemon pokemon = new Pokemon(



            splitLine[1],
                    splitLine[2],
                    splitLine[3],
                    Integer.parseInt(splitLine[5])
                    ,
                    Integer.parseInt(splitLine[11]),
                    Boolean.parseBoolean(splitLine[12]),
                    Integer.parseInt(splitLine[6])
            );

            return pokemon;
        }).collect(Collectors.toList());

        var average = pokemoni.stream()
                .filter(pokemon -> pokemon.getGenerace() == 1)
                .mapToInt(pokemon -> pokemon.getAttack())
                .average();

        System.out.println(average);

        var generaceDva = pokemoni.stream()
                .filter(pokemon -> pokemon.getGenerace() == 2)
                .filter(pokemon -> pokemon.isLegendarni())
                .map(pokemon -> pokemon.getName()).collect(Collectors.joining());

        System.out.println(generaceDva);

        System.out.println("MAX HP:" + pokemoni.stream().filter(pokemon -> pokemon.getGenerace() == 1).max((o1, o2) -> o1.getHP() - o2.getHP()).get().getHP());

    }
}
