package com.team.aaa450.cricketscorekeeper;

import android.provider.BaseColumns;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class contractClass {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public contractClass() {}

    /* Inner class that defines the table contents */
    public static abstract class tableColoumnNameDefinitions implements BaseColumns {
        public static final String team_score_table = "team_score_table";
        public static final String match_id = "match_id";
        public static final String reference_id = "reference_id";
        public static final String date = "date";
        public static final String team_name = "team_name";
        public static final String team_score = "team_score";
        public static final String total_extra_run = "total_extra_run";
        public static final String wide_runs = "wide";
        public static final String no_runs = "no";
        public static final String bye_runs = "bye";
        public static final String player_score_table = "player_score_table";
        public static final String player_name = "player_name";
        public static final String score = "score";
        public static final String balls_played = "balls_played";
    }

    public static class sqlQueries{
        public static final String TEXT_TYPE = " TEXT";
        public static final String COMMA_SEP = ",";
        public static final String BRACKET_BEGIN = "( ";
        public static final String BRACKET_END = " )";
        public static final String DATE_TYPE = " datetime default current_timestamp ";
        public static final String INTEGER_TYPE = " INTEGER ";
        public static final String team_score_table_creation_query =
                "CREATE TABLE IF NOT EXISTS " + tableColoumnNameDefinitions.team_score_table + " (" +
                        tableColoumnNameDefinitions.match_id + " INTEGER PRIMARY KEY autoincrement," +
                        tableColoumnNameDefinitions.reference_id + INTEGER_TYPE + COMMA_SEP +
                        tableColoumnNameDefinitions.date + DATE_TYPE + COMMA_SEP +
                        tableColoumnNameDefinitions.team_name + TEXT_TYPE + COMMA_SEP +
                        tableColoumnNameDefinitions.team_score + INTEGER_TYPE + COMMA_SEP +
                        tableColoumnNameDefinitions.total_extra_run + INTEGER_TYPE + COMMA_SEP +
                        tableColoumnNameDefinitions.wide_runs + INTEGER_TYPE + COMMA_SEP +
                        tableColoumnNameDefinitions.no_runs + INTEGER_TYPE + COMMA_SEP +
                        tableColoumnNameDefinitions.bye_runs + INTEGER_TYPE + COMMA_SEP +
                " )";

        public static final String player_score_table_creation_query =
                "CREATE TABLE IF NOT EXISTS " + tableColoumnNameDefinitions.player_score_table+ " (" +
                        tableColoumnNameDefinitions.match_id + INTEGER_TYPE + COMMA_SEP +
                        tableColoumnNameDefinitions.team_name + TEXT_TYPE + COMMA_SEP +
                        tableColoumnNameDefinitions.player_name + TEXT_TYPE + COMMA_SEP +
                        tableColoumnNameDefinitions.score + INTEGER_TYPE + COMMA_SEP +
                        tableColoumnNameDefinitions.balls_played + INTEGER_TYPE + COMMA_SEP +
                        "foreign key "+BRACKET_BEGIN+tableColoumnNameDefinitions.match_id+BRACKET_END+" references "+
                                tableColoumnNameDefinitions.team_score_table+BRACKET_BEGIN+tableColoumnNameDefinitions.match_id+BRACKET_END+COMMA_SEP+
                        "primary key "+BRACKET_BEGIN+tableColoumnNameDefinitions.match_id+COMMA_SEP+tableColoumnNameDefinitions.team_name+BRACKET_END+
                        " )";

        public static final String team_score_table_deletion_query =
                "DROP TABLE IF EXISTS " + tableColoumnNameDefinitions.team_score_table;

        public static final String player_score_table_deletion_query =
                "DROP TABLE IF EXISTS " + tableColoumnNameDefinitions.player_score_table;

        public static final String team_score_table_entry_query_construct(BigInteger referenceId, String teamName, int teamScore,
                                                                          int teamExtraRuns, int wideRuns, int noRuns, int byeRuns){
            String query = new String("insert into "+tableColoumnNameDefinitions.team_score_table+ BRACKET_BEGIN+ tableColoumnNameDefinitions.reference_id+
                        COMMA_SEP+ tableColoumnNameDefinitions.team_name+ COMMA_SEP+ tableColoumnNameDefinitions.team_score+ COMMA_SEP+
                        tableColoumnNameDefinitions.total_extra_run+ COMMA_SEP+ tableColoumnNameDefinitions.wide_runs+ COMMA_SEP+
                        tableColoumnNameDefinitions.no_runs+ COMMA_SEP+ tableColoumnNameDefinitions.bye_runs+ BRACKET_END+ "values"+
                        BRACKET_BEGIN+ referenceId + COMMA_SEP + "\'" + teamName + "\'" + COMMA_SEP+ teamScore+ COMMA_SEP +
                        teamExtraRuns + COMMA_SEP + wideRuns + COMMA_SEP + noRuns + COMMA_SEP + byeRuns + BRACKET_END+ "\"");
            return query;
        }

        public static final String player_score_table_entry_query_construct(BigInteger referenceId , String teamName, String playerName , int playerScore,
                                                                            int playerTotalBallsPlayed){
            String query = new String("insert into "+tableColoumnNameDefinitions.player_score_table + BRACKET_BEGIN + tableColoumnNameDefinitions.match_id +
                        COMMA_SEP + tableColoumnNameDefinitions.team_name + COMMA_SEP + tableColoumnNameDefinitions.player_name + COMMA_SEP +
                        tableColoumnNameDefinitions.score + COMMA_SEP + tableColoumnNameDefinitions.balls_played + BRACKET_END +
                        " values" + BRACKET_BEGIN + BRACKET_BEGIN + "select " + tableColoumnNameDefinitions.match_id + " from "
                        + tableColoumnNameDefinitions.team_score_table + " where " + tableColoumnNameDefinitions.reference_id
                        + "=" + referenceId + BRACKET_END  + COMMA_SEP + "\'" + teamName + "\'" + COMMA_SEP + "\'" +
                        playerName + "\'" + playerScore + playerTotalBallsPlayed + BRACKET_END);
            return query;
        }
    }


    public static class specialReferenceNumberGenerator{
        public static BigInteger  referenceIdGenerator(){
            Date dNow = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("hhmmssddMMyyyy");
            String str = ""+ft.format(dNow);
            BigInteger bi = new BigInteger(str);
            return bi;
        }
    }
}