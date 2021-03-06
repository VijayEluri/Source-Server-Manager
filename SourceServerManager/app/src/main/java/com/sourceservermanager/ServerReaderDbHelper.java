package com.sourceservermanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Matthew on 1/27/2016.
 */
public class ServerReaderDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Servers.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String TEXT_INTEGER = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ServerReaderContract.ServerEntry.TABLE_NAME + " (" +
                    ServerReaderContract.ServerEntry._ID + " INTEGER PRIMARY KEY," +
                    ServerReaderContract.ServerEntry.COLUMN_NAME_NICKNAME + TEXT_TYPE + COMMA_SEP +
                    ServerReaderContract.ServerEntry.COLUMN_NAME_HOST + TEXT_TYPE + COMMA_SEP +
                    ServerReaderContract.ServerEntry.COLUMN_NAME_PORT + TEXT_TYPE + COMMA_SEP +
                    ServerReaderContract.ServerEntry.COLUMN_NAME_PASSWORD + TEXT_TYPE +
            " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ServerReaderContract.ServerEntry.TABLE_NAME;

    public ServerReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}