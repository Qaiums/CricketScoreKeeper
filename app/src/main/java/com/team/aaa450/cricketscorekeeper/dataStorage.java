package com.team.aaa450.cricketscorekeeper;

import com.team.aaa450.cricketscorekeeper.contractClass;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Qaium on 2/26/2016.
 */



public class dataStorage extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "cricketScoreKeeper.db";

    public dataStorage(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(contractClass.sqlQueries.team_score_table_creation_query);
        db.execSQL(contractClass.sqlQueries.player_score_table_creation_query);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(contractClass.sqlQueries.team_score_table_deletion_query);
        db.execSQL(contractClass.sqlQueries.player_score_table_deletion_query);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}