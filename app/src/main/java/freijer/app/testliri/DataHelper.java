package freijer.app.testliri;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TestLiririqqq";
    public static final String TABLE_NAME = "questionsqqq";

    public static final String KEY_ID = "_id";
    public static final String KEY_QUEST = "quest";


    Cursor cursor;
    SQLiteDatabase database;
    ContentValues contentValues = new ContentValues();
    String valueQuest;


    public String getValueQuest() {
        return valueQuest;
    }
    public void setValueQuest(String valueQuest) {
        this.valueQuest = valueQuest;
    }

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" + KEY_ID + "  integer primary key," + KEY_QUEST + " text" + ");");
    }

//    public void WriteDB(String quest){
//        database = this.getWritableDatabase();
//        contentValues.put(KEY_QUEST, quest);
//        database.insert(TABLE_NAME, null, contentValues);
//    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);
    }

    public void insertWord(int id, String word) {
        database = this.getWritableDatabase();
        contentValues.put(KEY_ID, id);
        contentValues.put(KEY_QUEST, word);
        database.insertOrThrow(TABLE_NAME, null, contentValues);
        database.close();
    }







    String upd = "3";
    public void UpdateDB(String quest){
        database = this.getWritableDatabase();
        contentValues.put(KEY_QUEST, quest);
        database.update(TABLE_NAME, contentValues, KEY_ID + "= ?" , new String[] {upd});
    }

    public void ReadDB(){
        database = this.getWritableDatabase();
        cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        boolean BB = cursor.moveToFirst();
        if (BB) {
            int idIndex = cursor.getColumnIndex(KEY_ID);
            int questIndex = cursor.getColumnIndex(KEY_QUEST);
            do {
                Log.d("myLogs1", "ID = " + cursor.getInt(idIndex) +
                        ", очки = " + cursor.getString(questIndex));
                setValueQuest(cursor.getString(cursor.getColumnIndex(KEY_QUEST)));
            } while (cursor.moveToNext());
        } else
            Log.d("myLogs","0 rows");
        cursor.close();

//        database = this.getWritableDatabase();
//        cursor = database.query(TABLE_NAME, new String[] {KEY_QUEST}, KEY_ID + "= ?", new String[] {String.valueOf(3)}, null, null, null);
//        cursor.moveToLast();
//        setValueQuest(cursor.getString(cursor.getColumnIndex(KEY_QUEST)));
//        cursor.close();
    }

    public void ReadDB_numeric(int  income){
        database = this.getWritableDatabase();
        cursor = database.query(TABLE_NAME, new String[] {KEY_QUEST}, KEY_ID + "= ?", new String[] {String.valueOf(income)}, null, null, null);
        cursor.moveToLast();
        setValueQuest(cursor.getString(cursor.getColumnIndex(KEY_QUEST)));
        cursor.close();
    }



    public void DeleteDB(){
        database = this.getWritableDatabase();
        database.delete(TABLE_NAME, null, null);
        database.close();
    }
}
