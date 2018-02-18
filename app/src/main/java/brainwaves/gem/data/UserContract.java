package brainwaves.gem.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import brainwaves.gem.R;

/**
 * Created by Ahmed on 1/24/2018.
 */

public class UserContract {

    private SQLiteDatabase mDb;
    public static String userID="";
    public static String userName="";
    public static String password="";
    public static String fullName="";
    public static String birthDate="";
    public static String nationality="";
    public static String currency_index ="";

    Context context;
    public UserContract(Context context){
        this.context=context;
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
        public static final String COLUMN_CURRENCY = "currency_index";
    }

    public boolean login(String userName, String password){
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
            userID=cursor.getString(cursor.getColumnIndex(UserEntry._ID));
            userName=cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_USER_NAME));
            password=cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_PASSWORD));
            fullName=cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_Full_NAME));
            birthDate=cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_BIRTH_DAY));
            nationality=cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_NATIONALITY));
            currency_index =cursor.getString(cursor.getColumnIndex(UserEntry.COLUMN_CURRENCY));
            saveSharedPreferences();
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
        cv.put(UserEntry.COLUMN_CURRENCY,context.getResources().getString(R.string.default_currency_index));

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


    public int editUser(){
     //   saveSharedPreferences();
        ContentValues cv = new ContentValues();
        cv.put(UserEntry.COLUMN_Full_NAME, fullName);
        cv.put(UserEntry.COLUMN_BIRTH_DAY, birthDate);
        cv.put(UserEntry.COLUMN_NATIONALITY, nationality);
        cv.put(UserEntry.COLUMN_CURRENCY, currency_index);

        String whereClause = ""+UserEntry._ID+" = ?";
        String[] whereArgs = new String[] {
                userID
        };

        return mDb.update(UserEntry.TABLE_NAME,cv,whereClause,whereArgs);

    }

    public void saveSharedPreferences(){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getResources().
                getString(R.string.gem_pref_key),Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(context.getResources().getString(R.string.logged_in_key),true);
        editor.putString(context.getResources().getString(R.string.currency_index_key), currency_index);
        editor.putString(context.getResources().getString(R.string.user_name_key),userName);
        editor.putString(context.getResources().getString(R.string.user_id_key),userID);
        editor.putString(context.getResources().getString(R.string.full_name_key),fullName);
        editor.putString(context.getResources().getString(R.string.birth_date_key),birthDate);
        editor.putString(context.getResources().getString(R.string.nationality_key),nationality);
        editor.commit();
    }

    public void loadSharedPreferences(){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getResources().
                getString(R.string.gem_pref_key),Context.MODE_PRIVATE);
        userID=sharedPref.getString(context.getResources().getString(R.string.user_id_key),userID);
        userName=sharedPref.getString(context.getResources().getString(R.string.user_name_key),userName);
        fullName=sharedPref.getString(context.getResources().getString(R.string.full_name_key),fullName);
        birthDate=sharedPref.getString(context.getResources().getString(R.string.birth_date_key),birthDate);
        nationality=sharedPref.getString(context.getResources().getString(R.string.nationality_key),nationality);
        currency_index =sharedPref.getString(context.getResources().getString(R.string.currency_index_key),
                context.getResources().getString(R.string.default_currency_index));
    }

    public void deleteSharedPreference(){
        SharedPreferences preferences = context.getSharedPreferences(context.getResources().getString(R.string.gem_pref_key),
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }






}
