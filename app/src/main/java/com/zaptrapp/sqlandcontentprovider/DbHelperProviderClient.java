/**********************************************************************************************************************************************************************
****** AUTO GENERATED FILE BY ANDROID SQLITE HELPER SCRIPT BY FEDERICO PAOLINELLI. ANY CHANGE WILL BE WIPED OUT IF THE SCRIPT IS PROCESSED AGAIN. *******
**********************************************************************************************************************************************************************/
package com.zaptrapp.sqlandcontentprovider;


import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class DbHelperProviderClient{


    // ------------- AMOUNTDATABASE_HELPERS ------------
    public static Uri addAmountDatabase (String Name, 
                                Integer Amount, 
                                String ShortDesc, 
                                Context c) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelperProvider.AMOUNTDATABASE_NAME_COLUMN, Name);
        contentValues.put(DbHelperProvider.AMOUNTDATABASE_AMOUNT_COLUMN, Amount);
        contentValues.put(DbHelperProvider.AMOUNTDATABASE_SHORTDESC_COLUMN, ShortDesc);
        ContentResolver cr = c.getContentResolver();
        return cr.insert(DbHelperProvider.AMOUNTDATABASE_URI, contentValues);
    }

    public static int removeAmountDatabase(long rowIndex, Context c){
        ContentResolver cr = c.getContentResolver();
        Uri rowAddress = ContentUris.withAppendedId(DbHelperProvider.AMOUNTDATABASE_URI, rowIndex);
        return cr.delete(rowAddress, null, null);
    }

    public static int removeAllAmountDatabase(Context c){
        ContentResolver cr = c.getContentResolver();
        return cr.delete(DbHelperProvider.AMOUNTDATABASE_URI, null, null);
    }

    public static Cursor getAllAmountDatabase(Context c){
    	ContentResolver cr = c.getContentResolver();
        String[] resultColumns = new String[] {
                         DbHelperProvider.ROW_ID,
                         DbHelperProvider.AMOUNTDATABASE_NAME_COLUMN,
                         DbHelperProvider.AMOUNTDATABASE_AMOUNT_COLUMN,
                         DbHelperProvider.AMOUNTDATABASE_SHORTDESC_COLUMN
                         };

        Cursor resultCursor = cr.query(DbHelperProvider.AMOUNTDATABASE_URI, resultColumns, null, null, null);
        return resultCursor;
    }

    public static Cursor getAmountDatabase(long rowId, Context c){
    	ContentResolver cr = c.getContentResolver();
        String[] resultColumns = new String[] {
                         DbHelperProvider.ROW_ID,
                         DbHelperProvider.AMOUNTDATABASE_NAME_COLUMN,
                         DbHelperProvider.AMOUNTDATABASE_AMOUNT_COLUMN,
                         DbHelperProvider.AMOUNTDATABASE_SHORTDESC_COLUMN
                         };

        Uri rowAddress = ContentUris.withAppendedId(DbHelperProvider.AMOUNTDATABASE_URI, rowId);
        String where = null;    
        String whereArgs[] = null;
        String order = null;
    
        Cursor resultCursor = cr.query(rowAddress, resultColumns, where, whereArgs, order);
        return resultCursor;
    }

    public static int updateAmountDatabase (int rowId, 
                                   String Name,
                                   Integer Amount,
                                   String ShortDesc,
                                   Context c) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelperProvider.AMOUNTDATABASE_NAME_COLUMN, Name);
        contentValues.put(DbHelperProvider.AMOUNTDATABASE_AMOUNT_COLUMN, Amount);
        contentValues.put(DbHelperProvider.AMOUNTDATABASE_SHORTDESC_COLUMN, ShortDesc);
        Uri rowAddress = ContentUris.withAppendedId(DbHelperProvider.AMOUNTDATABASE_URI, rowId);

        ContentResolver cr = c.getContentResolver();
        int updatedRowCount = cr.update(rowAddress, contentValues, null, null);
        return updatedRowCount;
    }
    
}
