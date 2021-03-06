package com.crendal.m.mydvdshelf.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mara on 13/03/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "DVD";

    public static final String _ID = "_id";
    public static final String TITLE = "title";
    public static final String RELEASE_DATE = "relase_date";
    public static final String GENRE = "genre";
    public static final String IMG_PATH = "img_path";
    public static final String PRODUCTEUR = "producteur";
    public static final String SYNOPSYS = "synopsys";

    static final String DB_NAME = "DVDS.DB";

    static final int DB_VERSION = 1;

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TITLE + " TEXT NOT NULL,"
            + RELEASE_DATE + " TEXT,"
            + GENRE + " TEXT,"
            + IMG_PATH + " TEXT,"
            + PRODUCTEUR + "TEXT,"
            + SYNOPSYS + "TEXT);";

    public DatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

