package com.example.scotty.indyassign4_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "wordList.db";
    private static final String TABLE_NAME = "wordPairs";
    private static final String COLUMN_WORD = "word";
    private static final String COLUMN_ANTONYM = "antonym";
    private SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table wordPairs (word string not null , auto_increment , antonym not null)";

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME , null , DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;

    }

    public void insertWord(Contact c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from wordPairs";
        Cursor cursor = db.rawQuery(query, null);


        values.put(COLUMN_WORD , c.getWord());
        values.put(COLUMN_ANTONYM , c.getAntonym());

        db.insert(TABLE_NAME , null , values);

        db.close();
    }

    public String searchWord(String word){
        db = this.getReadableDatabase();
        String query = "select word, antonym from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                b = cursor.getString(1);

                if(a.equals(word)){
                    b = cursor.getString(1);
                }
                else if(b.equals(word)){
                    a = cursor.getString(0);
                    b = a;
                }
                else{
                    b = "not found";
                }
            }while(cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " +TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
