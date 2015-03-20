package com.crendal.m.mydvdshelf.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.crendal.m.mydvdshelf.Entities.DVD;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Mara on 20/03/2015.
 */
public class DBManager {

    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public  DBManager(Context c) { context = c; }

    public DBManager open() throws SQLException
    {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() { dbHelper.close(); }

    public void insert(DVD newDvd)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.TITLE, newDvd.getTitle());
        contentValues.put(DatabaseHelper.RELEASE_DATE, newDvd.getDate());
        contentValues.put(DatabaseHelper.GENRE, newDvd.getGenre());
        contentValues.put(DatabaseHelper.PRODUCTEUR, newDvd.getProducteur());
        contentValues.put(DatabaseHelper.IMG_PATH, newDvd.getImage_Path());
        database.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
    }

    public void insert(String title, String date, String genre, String producteur, String synopsys, String img_path )
    {
        DVD dvdToAdd = new DVD(title, synopsys, date, genre, producteur, img_path);
        this.insert(dvdToAdd);
    }

    public void delete (long _id)
    {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + " = " + _id, null);
    }

    public ArrayList<DVD> getFilms()
    {
        ArrayList<DVD> myDVDs = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME, null);
        if(cursor != null)
        {
            if (cursor.moveToFirst())
            {
                do {
                    int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper._ID));
                    String title = cursor.getString(cursor.getColumnIndex(DatabaseHelper.TITLE));
                    String synopsys = cursor.getString(cursor.getColumnIndex(DatabaseHelper.SYNOPSYS));
                    String date = cursor.getString(cursor.getColumnIndex(DatabaseHelper.RELEASE_DATE));
                    String genre = cursor.getString(cursor.getColumnIndex(DatabaseHelper.GENRE));
                    String producteur = cursor.getString(cursor.getColumnIndex(DatabaseHelper.PRODUCTEUR));
                    String image_path = cursor.getString(cursor.getColumnIndex(DatabaseHelper.IMG_PATH));
                    myDVDs.add(new DVD(title, synopsys, date, genre, producteur, image_path));
                } while (cursor.moveToNext());
            }
        }
        return myDVDs;
    }

    public DVD getFilm(long _id)
    {
        DVD myDVD = null;

        Cursor cursor = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE _id = " + _id, null);
        if(cursor != null)
        {
            if (cursor.moveToFirst())
            {
                int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper._ID));
                String title = cursor.getString(cursor.getColumnIndex(DatabaseHelper.TITLE));
                String synopsys = cursor.getString(cursor.getColumnIndex(DatabaseHelper.SYNOPSYS));
                String date = cursor.getString(cursor.getColumnIndex(DatabaseHelper.RELEASE_DATE));
                String genre = cursor.getString(cursor.getColumnIndex(DatabaseHelper.GENRE));
                String producteur = cursor.getString(cursor.getColumnIndex(DatabaseHelper.PRODUCTEUR));
                String image_path = cursor.getString(cursor.getColumnIndex(DatabaseHelper.IMG_PATH));
                myDVD = new DVD(title, synopsys, date, genre, producteur, image_path);
            }
        }
        return myDVD;
    }

}
