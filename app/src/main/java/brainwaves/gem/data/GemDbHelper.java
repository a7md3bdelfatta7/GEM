package brainwaves.gem.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import  brainwaves.gem.data.UserContract.UserEntry;
import  brainwaves.gem.data.ArtifactsContract.ArtifactEntry;
import  brainwaves.gem.data.TourContract.TourEntry;


/**
 * Created by Ahmed on 1/24/2018.
 */

public class GemDbHelper extends SQLiteOpenHelper {

    private static  final String DB_NAME="gem.db";
    Context context;
    // If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 2;

    public GemDbHelper(Context context) {
        super(context, DB_NAME,null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // Create a table to hold waitlist data
         String SQL_CREATE_USER_TABLE = "CREATE TABLE " + UserEntry.TABLE_NAME + " (" +
                UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                UserEntry.COLUMN_USER_NAME + " TEXT NOT NULL, " +
                UserEntry.COLUMN_PASSWORD + " TEXT NOT NULL, " +
                UserEntry.COLUMN_Full_NAME + " TEXT NOT NULL, " +
                UserEntry.COLUMN_BIRTH_DAY + " TEXT NOT NULL, " +
                 UserEntry.COLUMN_NATIONALITY + " TEXT NOT NULL," +
                 UserEntry.COLUMN_CURRENCY + " TEXT NOT NULL" +

                "); ";

        String SQL_CREATE_ARTIFACT_TABLE ="CREATE TABLE "+ ArtifactEntry.TABLE_NAME+ " ("+
                ArtifactEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ArtifactEntry.COLUMN_USER_ID + " TEXT NOT NULL, " +
                ArtifactEntry.COLUMN_ARTIFACT_ID + " TEXT NOT NULL" +
                "); ";

        String SQL_CREATE_TOUR_TABLE ="CREATE TABLE "+ TourEntry.TABLE_NAME+ " ("+
                TourEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TourEntry.COLUMN_TOUR_NAME + " TEXT NOT NULL, " +
                TourEntry.COLUMN_USER_ID + " TEXT NOT NULL" +

                "); ";

        String SQL_CREATE_TOUR_ARTIFACTS_TABLE ="CREATE TABLE tourArtifacts ("+
                 "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                 "tour_id TEXT NOT NULL, " +
                 "artifact_id TEXT NOT NULL" +
                "); ";

        String SQL_CREATE_FAVOURITE_TABLE ="CREATE TABLE "+ ArtifactsFavourite.FavouriteEntry.TABLE_NAME+ " ("+
                ArtifactEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ArtifactEntry.COLUMN_USER_ID + " TEXT NOT NULL, " +
                ArtifactEntry.COLUMN_ARTIFACT_ID + " TEXT NOT NULL" +
                "); ";


        sqLiteDatabase.execSQL(SQL_CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_ARTIFACT_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_TOUR_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_TOUR_ARTIFACTS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_FAVOURITE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    this.context.deleteDatabase(GemDbHelper.DB_NAME);




    }
}
