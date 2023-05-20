package com.example.noteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class dbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "myDatabase.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_USERS = "users";
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "pass";

    private static final String TABLE_NOTES = "notes";
    private static final String COLUMN_NOTE_ID = "note_id";
    private static final String COLUMN_NOTE_HEAD = "note_head";
    private static final String COLUMN_NOTE_BODY = "note_body";
    private static final String COLUMN_USER_ID_FK = "user_id";

    public dbHelper(@Nullable Context context) {
        super(context, "mydatabase", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createUsersTableQuery = "CREATE TABLE " + TABLE_USERS + "("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_USERNAME + " TEXT NOT NULL, "
                + COLUMN_PASSWORD + " TEXT NOT NULL"
                + ")";
        sqLiteDatabase.execSQL(createUsersTableQuery);


        String createNotesTableQuery = "CREATE TABLE " + TABLE_NOTES + "("
                + COLUMN_NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NOTE_HEAD + " TEXT NOT NULL, "
                + COLUMN_NOTE_BODY + " TEXT NOT NULL, "
                + COLUMN_USER_ID_FK + " INTEGER, "
                + "FOREIGN KEY (" + COLUMN_USER_ID_FK + ") REFERENCES " + TABLE_USERS + "(" + COLUMN_USER_ID + ")"
                + ")";
        sqLiteDatabase.execSQL(createNotesTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(sqLiteDatabase);

    }
    public void createUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);




        db.insert(TABLE_USERS, COLUMN_USERNAME, values);

        db.close();
    }
    public boolean isUserValid(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = ? AND " + COLUMN_PASSWORD + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{username, password});
        boolean result = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return result;
    }
    public List<Note> getNotesByUserId(int userId) {

        List<Note> notesList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {COLUMN_NOTE_HEAD, COLUMN_NOTE_BODY};
        String selection = COLUMN_USER_ID_FK + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};

        Cursor cursor = db.query(TABLE_NOTES, projection, selection, selectionArgs, null, null, null);


        if (cursor.moveToFirst()) {
            do {


                notesList.add(new Note(cursor.getString(0),cursor.getString(1)));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        System.out.println(notesList);
        return notesList;
    }


    public int getUserIdFromUsername(String refUsername) {
        int userId = -1; // Default value for user_id
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String[] projection = {COLUMN_USER_ID};
        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {refUsername};

        Cursor cursor = sqLiteDatabase.query(TABLE_USERS, projection, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            userId = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_USER_ID));
            cursor.close();
        }

        return userId;
    }

    public void addNote(String noteHead, String noteBody, int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NOTE_HEAD, noteHead);
        values.put(COLUMN_NOTE_BODY, noteBody);
        System.out.println(noteHead + noteBody);
        values.put(COLUMN_USER_ID_FK, id);


        // Inserting row
        db.insert(TABLE_NOTES, null, values);
        db.close(); // Closing database connection
    }


    //todo not silme
    public String getNoteId(String head){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String[] projection = {COLUMN_NOTE_ID};
        String selection = COLUMN_NOTE_HEAD + " = ?";
        String[] selectionArgs = {head};

        Cursor cursor = sqLiteDatabase.query(TABLE_NOTES, projection, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
           return cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOTE_ID));
        }
        return null;

    }
    public boolean deleteTitle(String id)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
         return sqLiteDatabase.delete(TABLE_NOTES, COLUMN_NOTE_ID + "=" + id, null) > 0;
    }






}
