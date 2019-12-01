package com.example.footietracker;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface FootballApi {
    @Headers("X-RapidAPI-Key:0b8f6761bba462b1d96fd43fa237fe74")
    @GET("leagueTable/{league_id}")
    Call<List<Standings>> getStandings(@Path("league_id") int leagueID);
}
