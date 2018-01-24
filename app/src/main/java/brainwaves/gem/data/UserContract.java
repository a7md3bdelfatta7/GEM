package brainwaves.gem.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Ahmed on 1/24/2018.
 */

public class UserContract {

    private SQLiteDatabase mDb;
    public static String userName="";
    public static String password="";
    public static String fullName="";
    public static String birthDate="";
    public static String nationality="";


    public UserContract(Context context){
        GemDbHelper dbHelper = new GemDbHelper(context);
        mDb = dbHelper.getWritableDatabase();
    }

    public class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_USER_NAME = "userName";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_Full_NAME = "fullName";
        public static final String COLUMN_BIRTH_DAY = "birthDay";
        public static final String COLUMN_NATIONALITY = "nationality";

    }

    public boolean isExist(String userName,String password){



        String whereClause = ""+UserEntry.COLUMN_USER_NAME+" = ? AND "+UserEntry.COLUMN_PASSWORD+" = ?";
        String[] whereArgs = new String[] {
                userName,
                password
        };

        Cursor cursor=mDb.query(
                UserEntry.TABLE_NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        if(cursor.moveToFirst()){
            userName=cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_USER_NAME));
            password=cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_PASSWORD));
            fullName=cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_Full_NAME));
            birthDate=cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_BIRTH_DAY));
            nationality=cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_NATIONALITY));
            return true;
        }
        return false;
    }
    public long addNewUser(String userName,String password,String fullName,String birthDate,String nationality){

        ContentValues cv = new ContentValues();
        cv.put(UserEntry.COLUMN_USER_NAME, userName);
        cv.put(UserEntry.COLUMN_PASSWORD, password);
        cv.put(UserEntry.COLUMN_Full_NAME, fullName);
        cv.put(UserEntry.COLUMN_BIRTH_DAY, birthDate);
        cv.put(UserEntry.COLUMN_NATIONALITY, nationality);

        return mDb.insert(UserEntry.TABLE_NAME, null, cv);

    }

    public boolean isUserNameExist(String userName){



        String whereClause = ""+UserEntry.COLUMN_USER_NAME+" = ?";
        String[] whereArgs = new String[] {
                userName
        };

        Cursor cursor=mDb.query(
                UserEntry.TABLE_NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        if(cursor.moveToFirst()){
            return true;
        }
        return false;
    }



}
