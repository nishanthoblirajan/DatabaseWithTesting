/**********************************************************************************************************************************************************************
****** AUTO GENERATED FILE BY ANDROID SQLITE HELPER SCRIPT BY FEDERICO PAOLINELLI. ANY CHANGE WILL BE WIPED OUT IF THE SCRIPT IS PROCESSED AGAIN. *******
**********************************************************************************************************************************************************************/
package com.zaptrapp.sqlandcontentprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelperDbHelper {
    private static final String TAG = "DbHelper";

    private static final String DATABASE_NAME = "DbHelper.db";
    private static final int DATABASE_VERSION = 1;


    // Variable to hold the database instance
    protected SQLiteDatabase mDb;
    // Context of the application using the database.
    private final Context mContext;
    // Database open/upgrade helper
    private DbHelper mDbHelper;
    
    public DbHelperDbHelper(Context context) {
        mContext = context;
        mDbHelper = new DbHelper(mContext, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    public DbHelperDbHelper open() throws SQLException { 
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }
                                                     
    public void close() {
        mDb.close();
    }

    public static final String ROW_ID = "_id";

    
    // -------------- AMOUNTDATABASE DEFINITIONS ------------
    public static final String AMOUNTDATABASE_TABLE = "AmountDatabase";
    
    public static final String AMOUNTDATABASE_NAME_COLUMN = "Name";
    public static final int AMOUNTDATABASE_NAME_COLUMN_POSITION = 1;
    
    public static final String AMOUNTDATABASE_AMOUNT_COLUMN = "Amount";
    public static final int AMOUNTDATABASE_AMOUNT_COLUMN_POSITION = 2;
    
    public static final String AMOUNTDATABASE_SHORTDESC_COLUMN = "ShortDesc";
    public static final int AMOUNTDATABASE_SHORTDESC_COLUMN_POSITION = 3;
    
    


    // -------- TABLES CREATION ----------

    
    // AmountDatabase CREATION 
    private static final String DATABASE_AMOUNTDATABASE_CREATE = "create table " + AMOUNTDATABASE_TABLE + " (" +
                                "_id integer primary key autoincrement, " +
                                AMOUNTDATABASE_NAME_COLUMN + " text, " +
                                AMOUNTDATABASE_AMOUNT_COLUMN + " integer, " +
                                AMOUNTDATABASE_SHORTDESC_COLUMN + " text" +
                                ")";
    

    
    // ----------------AmountDatabase HELPERS -------------------- 
    public long addAmountDatabase (String Name, Integer Amount, String ShortDesc) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AMOUNTDATABASE_NAME_COLUMN, Name);
        contentValues.put(AMOUNTDATABASE_AMOUNT_COLUMN, Amount);
        contentValues.put(AMOUNTDATABASE_SHORTDESC_COLUMN, ShortDesc);
        return mDb.insert(AMOUNTDATABASE_TABLE, null, contentValues);
    }

    public long updateAmountDatabase (long rowIndex,String Name, Integer Amount, String ShortDesc) {
        String where = ROW_ID + " = " + rowIndex;
        ContentValues contentValues = new ContentValues();
        contentValues.put(AMOUNTDATABASE_NAME_COLUMN, Name);
        contentValues.put(AMOUNTDATABASE_AMOUNT_COLUMN, Amount);
        contentValues.put(AMOUNTDATABASE_SHORTDESC_COLUMN, ShortDesc);
        return mDb.update(AMOUNTDATABASE_TABLE, contentValues, where, null);
    }

    public boolean removeAmountDatabase(long rowIndex){
        return mDb.delete(AMOUNTDATABASE_TABLE, ROW_ID + " = " + rowIndex, null) > 0;
    }

    public boolean removeAllAmountDatabase(){
        return mDb.delete(AMOUNTDATABASE_TABLE, null, null) > 0;
    }

    public Cursor getAllAmountDatabase(){
    	return mDb.query(AMOUNTDATABASE_TABLE, new String[] {
                         ROW_ID,
                         AMOUNTDATABASE_NAME_COLUMN,
                         AMOUNTDATABASE_AMOUNT_COLUMN,
                         AMOUNTDATABASE_SHORTDESC_COLUMN
                         }, null, null, null, null, null);
    }

    public Cursor getAmountDatabase(long rowIndex) {
        Cursor res = mDb.query(AMOUNTDATABASE_TABLE, new String[] {
                                ROW_ID,
                                AMOUNTDATABASE_NAME_COLUMN,
                                AMOUNTDATABASE_AMOUNT_COLUMN,
                                AMOUNTDATABASE_SHORTDESC_COLUMN
                                }, ROW_ID + " = " + rowIndex, null, null, null, null);

        if(res != null){
            res.moveToFirst();
        }
        return res;
    }
    

    private static class DbHelper extends SQLiteOpenHelper {
        public DbHelper(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        // Called when no database exists in disk and the helper class needs
        // to create a new one. 
        @Override
        public void onCreate(SQLiteDatabase db) {      
            db.execSQL(DATABASE_AMOUNTDATABASE_CREATE);
            
        }

        // Called when there is a database version mismatch meaning that the version
        // of the database on disk needs to be upgraded to the current version.
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Log the version upgrade.
            Log.w(TAG, "Upgrading from version " + 
                        oldVersion + " to " +
                        newVersion + ", which will destroy all old data");
            
            // Upgrade the existing database to conform to the new version. Multiple 
            // previous versions can be handled by comparing _oldVersion and _newVersion
            // values.

            // The simplest case is to drop the old table and create a new one.
            db.execSQL("DROP TABLE IF EXISTS " + AMOUNTDATABASE_TABLE + ";");
            
            // Create a new one.
            onCreate(db);
        }
    }
}

