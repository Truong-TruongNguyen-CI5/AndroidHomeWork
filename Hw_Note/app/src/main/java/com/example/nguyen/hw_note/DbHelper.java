package com.example.nguyen.hw_note;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DUC on 10/26/2016.
 */

public class DbHelper extends SQLiteAssetHelper {

    private final static String DB_NAME = "note.db";
    private final static int DB_VERSION = 1;
    private static final String NOTE_TABLE_NAME = "tbl_note";
    private static final String NOTE_COLUMN_TITLE = "title";
    private static final String NOTE_COLUMN_CONTENT = "content";
    private static final String NOTE_COLUMN_ID = "id";
    private static final String NOTE_COLUMN_TIME = "time_created";
    private static final String[] NOTE_COLUMNS =
            new String[]{
                    NOTE_COLUMN_ID,
                    NOTE_COLUMN_TITLE,
                    NOTE_COLUMN_CONTENT,
                    NOTE_COLUMN_TIME
            };

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    private static DbHelper instance;
    public static DbHelper getInstance(){
        return  instance;
    }

    public void insert(Note note){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NOTE_COLUMN_TITLE,note.getTitle());
        contentValues.put(NOTE_COLUMN_CONTENT,note.getContent());
        contentValues.put(NOTE_COLUMN_CONTENT,note.getTime_created());
        long id = db.insert(NOTE_TABLE_NAME,null,contentValues);
        note.setId((int)id);
        db.close();
    }

    public List<Note>selectAllQuote(){
        ArrayList<Note> noteList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(NOTE_TABLE_NAME, NOTE_COLUMNS, null
                ,null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()){
            noteList.add(createNote(cursor));
        }
        cursor.close();;
        db.close();
        return  noteList;
    }

    private Note createNote(Cursor cursor){
        int id = cursor.getInt(cursor.getColumnIndex(NOTE_COLUMN_ID));
        String title = cursor.getString(cursor.getColumnIndex(NOTE_COLUMN_TITLE));
        String content = cursor.getString(cursor.getColumnIndex(NOTE_COLUMN_CONTENT));
        String time_created = cursor.getString(cursor.getColumnIndex(NOTE_COLUMN_TIME));
        Note note = new Note(id, title, content, time_created);
        return note;
    }

    public void clearAllNote(){
        SQLiteDatabase db = getReadableDatabase();
        db.delete(NOTE_TABLE_NAME, null, null);
    }

    public Note selectRandomNote(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(NOTE_TABLE_NAME, NOTE_COLUMNS, null
                ,null,
                null,
                null,
                "RANDOM()",
                "1");
        if(cursor.moveToNext()){
            return  createNote(cursor);
        }
        return null;

    }
    public void update(Note note) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NOTE_COLUMN_TITLE, note.getTitle());
        contentValues.put(NOTE_COLUMN_CONTENT, note.getContent());
        contentValues.put(NOTE_COLUMN_TIME, note.getTime_created());

        db.update(
                NOTE_TABLE_NAME,
                contentValues,
                NOTE_COLUMN_ID + "=" + note.getId(),
                null
        );
        db.close();
    }

    public void delete(Note note) {
        //delete by ID
        SQLiteDatabase db = getWritableDatabase();
        db.delete(
                NOTE_TABLE_NAME,
                NOTE_COLUMN_ID + "=" + note.getId(),
                null
        );
    }

    public static void init(Context context){
        instance = new DbHelper(context);
    }


}
