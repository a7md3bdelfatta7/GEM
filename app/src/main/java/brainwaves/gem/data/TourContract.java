package brainwaves.gem.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;

/**
 * Created by Ahmed on 1/29/2018.
 */

public class TourContract {

    private SQLiteDatabase mDb;
    public class TourEntry implements BaseColumns {
        public static final String TABLE_NAME = "tour";
        public static final String COLUMN_TOUR_NAME = "tourName";
        public static final String COLUMN_USER_ID = "userId";
    }



    Context context;
    public TourContract(Context context){
        this.context=context;
        GemDbHelper dbHelper = new GemDbHelper(context);
        mDb = dbHelper.getWritableDatabase();
    }

    public long addNewTour(String tourName,ArrayList<String> tourArtifacts){

        tourName=tourName.toUpperCase();
        ContentValues cv = new ContentValues();
        cv.put(TourEntry.COLUMN_TOUR_NAME,tourName);
        cv.put(TourEntry.COLUMN_USER_ID,UserContract.userID);

        String tourId=String.valueOf(mDb.insert(TourEntry.TABLE_NAME, null, cv));

        mDb.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (String artifactId : tourArtifacts) {
                values.put("tour_id", tourId);
                values.put("artifact_id",artifactId);
                mDb.insert("tourArtifacts", null, values);
            }
            mDb.setTransactionSuccessful();
        } finally {
            mDb.endTransaction();
        }

        return Long.parseLong(tourId);

    }

    public ArrayList<String> getAllTours(){

        String whereClause = ""+ TourEntry.COLUMN_USER_ID+" = ?";
        String[] whereArgs = new String[] {
                UserContract.userID
        };

        Cursor cursor=mDb.query(
                TourEntry.TABLE_NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );


        ArrayList<String> allTours =new ArrayList<String>();

        if(cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                allTours.add(cursor.getString(cursor.getColumnIndex(TourEntry.COLUMN_TOUR_NAME)));
            }
        }
        return allTours;

    }


    public boolean tourNameExist(String tourName){

        tourName=tourName.toUpperCase();
        String whereClause = ""+ TourEntry.COLUMN_USER_ID+" = ? and "+TourEntry.COLUMN_TOUR_NAME+" = ?";
        String[] whereArgs = new String[] {
                UserContract.userID,
                tourName
        };

        Cursor cursor=mDb.query(
                TourEntry.TABLE_NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        if(cursor.getCount()>0) {
            return true;
        }
        return false;
    }

    public String getTourByName(String tourName){
        tourName=tourName.toUpperCase();
        String whereClause = ""+ TourEntry.COLUMN_USER_ID+" = ? and "+TourEntry.COLUMN_TOUR_NAME+" = ?";
        String[] whereArgs = new String[] {
                UserContract.userID,
                tourName
        };

        Cursor cursor=mDb.query(
                TourEntry.TABLE_NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );


        String tourId="";
        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            tourId=cursor.getString(cursor.getColumnIndex(TourEntry._ID));

        }
        return tourId;
    }


    public ArrayList<String> getTourArtifacts(String tourId){

        String whereClause = "tour_id = ?";
        String[] whereArgs = new String[] {
                tourId
        };

        Cursor cursor=mDb.query(
                "tourArtifacts",
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );


        ArrayList<String> tourArtifacts =new ArrayList<String>();
        if(cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                tourArtifacts.add(cursor.getString(cursor.getColumnIndex("artifact_id")));
            }
        }
        return tourArtifacts;

    }





}
