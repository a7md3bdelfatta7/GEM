package brainwaves.gem.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;

/**
 * Created by AhmedMiohamed on 1/28/2018.
 */

public class ArtifactsFavourite {

    public static ArrayList<Integer> tourArtifatcs;
    private SQLiteDatabase mDb;

    public class FavouriteEntry implements BaseColumns {

        public static final String TABLE_NAME = "FAVOURITE_ARTIFACTS";
        public static final String COLUMN_USER_ID = "userId";
        public static final String COLUMN_ARTIFACT_ID = "artifactId";

    }

    Context context;
    public ArtifactsFavourite(Context context){
        this.context=context;
        GemDbHelper dbHelper = new GemDbHelper(context);
        mDb = dbHelper.getWritableDatabase();
    }

    public long addNewArtifact(String artifactId){

        ContentValues cv = new ContentValues();
        cv.put(FavouriteEntry.COLUMN_USER_ID,UserContract.userID);
        cv.put(FavouriteEntry.COLUMN_ARTIFACT_ID,artifactId);

        if(!this.artifactExist(artifactId)){
            return mDb.insert(FavouriteEntry.TABLE_NAME, null, cv);
        }else{
            return 0;
        }

    }



    public ArrayList<String> getSelectedArtifacts(){

        String whereClause = ""+ FavouriteEntry.COLUMN_USER_ID+" = ?";
        String[] whereArgs = new String[] {
                UserContract.userID
        };

        Cursor cursor=mDb.query(
                FavouriteEntry.TABLE_NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );


        ArrayList<String> selectedArtifacts=new ArrayList<String>();

        if(cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                selectedArtifacts.add(cursor.getString(cursor.getColumnIndex(FavouriteEntry.COLUMN_ARTIFACT_ID)));
            }
        }
        return selectedArtifacts;
    }

    public boolean artifactExist(String artifactId){

        String whereClause = ""+ FavouriteEntry.COLUMN_USER_ID+" = ? and "+ FavouriteEntry.COLUMN_ARTIFACT_ID+" = ?";
        String[] whereArgs = new String[] {
                UserContract.userID,
                artifactId
        };

        Cursor cursor=mDb.query(
                FavouriteEntry.TABLE_NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );


        ArrayList<String> selectedArtifacts=new ArrayList<String>();

        if(cursor.getCount()>0) {
           return true;
        }
        return false;
    }

    public int deleteArtifact(int artifactId){

        String table = FavouriteEntry.TABLE_NAME;
        String whereClause = FavouriteEntry.COLUMN_ARTIFACT_ID+"=?";
        String[] whereArgs = new String[] { String.valueOf(artifactId) };

        int returned=mDb.delete(table, whereClause, whereArgs);

        return returned;
    }


}
