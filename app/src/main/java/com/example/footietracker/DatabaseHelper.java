package com.example.footietracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERVION =1;
    private static final String DATABASE_NAME = "MyFavourites.db";
    private static final String TABLE_NAME = "myFavourites";
    private static final String COL_1 = "TeamName";
    private static final String COL_2 = "League";
    private static final String COL_3 = "Wins";
    private static final String COL_4 = "Draws";
    private static final String COL_5 = "Losses";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERVION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(" +
                COL_1 + " Text NOT NULL, " +
                COL_2 + " Text NOT NULL, " +
                COL_3 + " Text NOT NULL, " +
                COL_4 + " Text NOT NULL, " +
                COL_5 + " Text NOT NULL " +");" ;
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table " + TABLE_NAME + ";" );
        this.onCreate(db);
    }

    public void addRecord(DatabaseReceiver databaseReceiver){
        ContentValues values= new ContentValues();
        values.put(COL_1,databaseReceiver.getTeamName());
        values.put(COL_2,databaseReceiver.getLeague());
        values.put(COL_3,databaseReceiver.getWins());
        values.put(COL_4,databaseReceiver.getDraws());
        values.put(COL_5,databaseReceiver.getLosses());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public Cursor getAllRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="Select * from " + TABLE_NAME +";";
        Cursor cursor = db.rawQuery(query,null);
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;

    }

    ArrayList<String> getTeamNames()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String tempName = "";
        ArrayList<String> names = new ArrayList<>();
        String query = "SELECT "+ COL_1 +" FROM "+TABLE_NAME;
        //Assume no duplicate titles
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        while(!(c.isAfterLast()))
        {
            tempName = c.getString(c.getColumnIndex(COL_1));
            names.add(tempName);
            c.moveToNext();
        }
        db.close();
        return names;
    }

    DatabaseReceiver getName(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        DatabaseReceiver Tname = new DatabaseReceiver();
        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+COL_1+" = ?",new String [] {name});
        c.moveToFirst();
        if(c.isNull(c.getColumnIndex(COL_1)))
        {
            db.close();
            return null;
        }
        Tname.setTeamName(c.getString(c.getColumnIndex(COL_1)));
        Tname.setLeague(c.getString(c.getColumnIndex(COL_2)));
        Tname.setWins(c.getString(c.getColumnIndex(COL_3)));
        Tname.setDraws(c.getString(c.getColumnIndex(COL_4)));
        Tname.setLosses(c.getString(c.getColumnIndex(COL_5)));
        db.close();
        return Tname;
    }

}
