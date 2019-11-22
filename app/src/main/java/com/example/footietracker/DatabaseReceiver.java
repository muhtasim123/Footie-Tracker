package com.example.footietracker;

public class DatabaseReceiver {
    private String TeamName;
    private String League;
    private String Wins;
    private String Draws;
    private String Losses;

    public DatabaseReceiver(){};

    public DatabaseReceiver(String teamName, String league, String wins, String draws, String losses){
        this.TeamName = teamName;
        this.League = league;
        this.Wins = wins;
        this.Draws = draws;
        this.Losses = losses;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public String getLeague() {
        return League;
    }

    public void setLeague(String league) {
        League = league;
    }

    public String getWins() {
        return Wins;
    }

    public void setWins(String wins) {
        Wins = wins;
    }

    public String getDraws() {
        return Draws;
    }

    public void setDraws(String draws) {
        Draws = draws;
    }

    public String getLosses() {
        return Losses;
    }

    public void setLosses(String losses) {
        Losses = losses;
    }
}
