package com.dan.examples.championship;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Runner {

    private static final Random random = new Random();

    public static void main(String[] args) {

        var teams = List.of(
                new Team(1, "Team1", "Moscow"),
                new Team(2, "Team2", "Moscow"),
                new Team(3, "Team3", "Kazan"),
                new Team(4, "Team4", "Ufa"),
                new Team(5, "Team5", "St. Petersburg"),
                new Team(6, "Team6", "St. Petersburg"),
                new Team(7, "Team7", "Moscow"),
                new Team(8, "Team8", "Sochi"),
                new Team(9, "Team9", "Ekaterinburg"),
                new Team(10, "Team10", "Samara")
        );

        var gameList = doGameList(teams);

        teams
                .stream()
                .collect(Collectors.toMap(Function.identity(), Team::getTableScore, (t1, t2) -> t1, TreeMap::new))
                .forEach((k, v) -> System.out.println(k.getName() + " with score " + v));
    }

    public static List<Game> doGameList(List<Team> teams) {

        List<Game> games = new ArrayList<>(teams.size());

        for (int i = 0; i < teams.size(); i++) {
            for (int j = 1; j < teams.size() - 1; j++) {
                Game game = new Game(teams.get(i), teams.get(j),
                        scoreGenerator(),
                        scoreGenerator());

                setWinnerLoser(teams, i, j, game);

                games.add(game);

            }
        }
        return games;
    }

    private static void setWinnerLoser(List<Team> teams, int i, int j, Game game) {
        if (game.getHomeScore() > game.getVisitorScore()) {
            teams.get(i).increment(2);
        }
        if (game.getVisitorScore() > game.getHomeScore()) {
            teams.get(j).increment(2);
        } else {
            teams.get(i).increment(1);
            teams.get(j).increment(1);
        }
    }

    private static int scoreGenerator() {
        return random.nextInt(5);
    }

}

class Game {

    private final Team home;
    private final Team visitor;
    private final int homeScore;
    private final int visitorScore;

    public Game(Team home, Team visitor, int homeScore, int visitorScore) {
        this.home = home;
        this.visitor = visitor;
        this.homeScore = homeScore;
        this.visitorScore = visitorScore;
    }


    public int getHomeScore() {
        return homeScore;
    }

    public int getVisitorScore() {
        return visitorScore;
    }


    @Override
    public String toString() {
        return "Game{" +
                "home=" + home +
                ", visitor=" + visitor +
                ", homeScore=" + homeScore +
                ", visitorScore=" + visitorScore +
                '}';
    }
}

class Team implements Comparable<Team> {

    private final int id;
    private final String name;
    private final String from;
    private int tableScore;

    public Team(Integer id, String name, String from) {
        this.id = id;
        this.name = name;
        this.from = from;
    }

    public String getName() {
        return name;
    }

    public void increment(int score) {
        this.tableScore += score;
    }

    public int getTableScore() {
        return tableScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (id != team.id) return false;
        if (tableScore != team.tableScore) return false;
        if (!Objects.equals(name, team.name)) return false;
        return Objects.equals(from, team.from);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + tableScore;
        return result;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", from='" + from + '\'' +
                ", tableScore=" + tableScore +
                '}';
    }

    @Override
    public int compareTo(@NotNull Team o) {
        return -Integer.compare(this.tableScore, o.tableScore);
    }
}



