package net.simplifiedcoding.bottomnavigationexample.Helper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import net.simplifiedcoding.bottomnavigationexample.Model.DataModel;

import java.util.ArrayList;

/**
 * Created by csa on 3/1/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // database =name
    public static String DATABASE = "database.db";
    // table name
    public static String TABLE ="address";
    // colum name
    public static String HOUSE ="house";
    public static String ROADNAME ="roadname";
    public static String LANDMARK ="landmark";
    public static String CITY ="city";
    public static String STATE ="state";
    public static String PINCODE ="pincode";
    public static String RB ="rb";

    String br;


    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //  br= "CREATE TABLE mytable(name TEXT,company TEXT,city TEXT,country TEXT);";
        br = "CREATE TABLE "+TABLE+"("+HOUSE+ " Text, "+ROADNAME+ " Text, "+LANDMARK+ " Text, "+CITY+ " Text ,"+STATE+ " Text , "+PINCODE+ " Text ,"+RB+ " Text);";
        db.execSQL(br);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE+" ;");
        onCreate(db);
    }


    public void insertdata(String houseno,String roadname ,String landmark,String city,String state,String pincode,String rb){
        System.out.print("Hello "+br);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        contentValues.put(HOUSE, houseno);
        contentValues.put(ROADNAME, roadname);
        contentValues.put(LANDMARK,landmark);
        contentValues.put(CITY,city);
        contentValues.put(STATE,state);
        contentValues.put(PINCODE,pincode);
        contentValues.put(PINCODE,rb);

        db.insert(TABLE,null,contentValues);

    }
    public ArrayList<DataModel> getdata(){

        ArrayList<DataModel> data=new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE+" ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        DataModel dataModel = null;
        while (cursor.moveToNext()) {
            dataModel= new DataModel();
            String name = cursor.getString(cursor.getColumnIndexOrThrow("house"));
            String company = cursor.getString(cursor.getColumnIndexOrThrow("roadname"));
            String landmark = cursor.getString(cursor.getColumnIndexOrThrow("landmark"));
            String city = cursor.getString(cursor.getColumnIndexOrThrow("city"));
            String state = cursor.getString(cursor.getColumnIndexOrThrow("state"));
            String pincode = cursor.getString(cursor.getColumnIndexOrThrow("pincode"));
            String rb12 = cursor.getString(cursor.getColumnIndexOrThrow("rb"));

            dataModel.setHouse(name);
            dataModel.setLandmark(company);
            dataModel.setRoadname(landmark);
            dataModel.setCity(city);
            dataModel.setState(state);
            dataModel.setPincode(pincode);
            dataModel.setRp(rb12);

            stringBuffer.append(dataModel);

            data.add(dataModel);
        }
        for (DataModel mo:data ) {
            Log.i("Hellomo",""+mo.getCity());
        }
        return data;
    }

   /* public int deleteConformOrderData(){
        SQLiteDatabase db=getWritableDatabase();
        int count= db.delete(TABLE,null,null);
        db.close();
        return count;
    }*/

}