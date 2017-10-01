package com.zaptrapp.sqlandcontentprovider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.IsolatedContext;
import android.test.ProviderTestCase2;
import android.test.mock.MockContentResolver;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.zaptrapp.sqlandcontentprovider.R.id.amountET;
import static com.zaptrapp.sqlandcontentprovider.R.id.nameET;
import static com.zaptrapp.sqlandcontentprovider.R.id.shortDescET;

/**
 * Created by nishanth on 01/10/17.
 */


@RunWith(AndroidJUnit4.class)
public class ContentProviderTestClass extends ProviderTestCase2<DbHelperProvider> {


    @Before
    @Override
    public void setUp() throws Exception {
        setContext(InstrumentationRegistry.getTargetContext());
        super.setUp();
    }

    public ContentProviderTestClass() {
        super(DbHelperProvider.class, DbHelperProvider.AMOUNTDATABASE_URI.getAuthority());
    }

    @Test
    public void initial() {
        System.out.println("Test Running");

        System.out.println(DbHelperProvider.AMOUNTDATABASE_AMOUNT_COLUMN);
    }

    @Test
    public void testInsert() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelperProvider.AMOUNTDATABASE_NAME_COLUMN, "Name");
        contentValues.put(DbHelperProvider.AMOUNTDATABASE_AMOUNT_COLUMN, 100);
        contentValues.put(DbHelperProvider.AMOUNTDATABASE_SHORTDESC_COLUMN, "shortDesc");

        Uri uri = getMockContext().getContentResolver().insert(getProvider().AMOUNTDATABASE_URI, contentValues);
        assertNotNull(uri);
    }

    @Test
    public void testRemoveAll() {
        assertNotNull(DbHelperProviderClient.removeAllAmountDatabase(getMockContext()));
    }

}
