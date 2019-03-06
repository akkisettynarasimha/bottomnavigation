package net.simplifiedcoding.bottomnavigationexample.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import net.simplifiedcoding.bottomnavigationexample.Model.Cartmodel;

public class CartSqlite extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="jivir.db";
    public static final String TABLE_NAME="jivir";
    public static final String ITEM_NAME="NAME";
    public static final String COST="cost";
    public static final String IMAGE="IMAGE";
    public static final String QUANTITY="quantity";

    public CartSqlite( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(IMAGE BLOB,NAME TEXT,COST INTEGER,QUANTITY INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public boolean insertdata(String name,String cost,String image,String quantity)
    {

        SQLiteDatabase sqLiteDatabas=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ITEM_NAME,name);
        contentValues.put(COST,cost);
        contentValues.put(IMAGE,image);
        contentValues.put(QUANTITY,quantity);
        long result=sqLiteDatabas.insert(TABLE_NAME,null,contentValues);
     if (result==-1)
         return false;
     else
         return true;
    }
    public Cursor getdata()
    {
        SQLiteDatabase sqLiteDatabas=this.getWritableDatabase();

        Cursor res=sqLiteDatabas.rawQuery("select * from "+TABLE_NAME,null);
        return res;


    }
    public int getProfilesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

}
