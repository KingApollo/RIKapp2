package dk.ucn.datamatiker.rikapp;
 
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class MySQLiteHelper extends SQLiteOpenHelper {
 
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MaalingDB";
    
    private static final String Maaling_Table_Name = "Maaling";
    private static final String Maaling_Collum_ID = "ID";
    private static final String Maaling_Collum_Time = "Time";
    private static final String Maaling_Collum_Date = "Date";
    private static final String Maaling_Collum_Ml = "Ml";
    private static final String Maaling_Collum_Note = "Note";
    
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }	
 
    @Override
    public void onCreate(SQLiteDatabase db) {
    	String CREATE_MAALING_TABLE = "CREATE TABLE " + Maaling_Table_Name + " (" + Maaling_Collum_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
    	+ Maaling_Collum_Time + " TEXT NOT NULL, " + Maaling_Collum_Date + " TEXT NOT NULL, " + Maaling_Collum_Ml + " INTEGER NOT NULL, " 
    	+ Maaling_Collum_Note + " TEXT)";
        // create table
        db.execSQL(CREATE_MAALING_TABLE);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS Maaling");
 
        // create fresh books table
        this.onCreate(db);
    }
 
    public void insertMaaling(Maaling m)
    {
    	SQLiteDatabase db = this.getWritableDatabase();
    	
    	try{
        ContentValues contentValues = new ContentValues(); 
    	contentValues.put("Time", m.getTime());
    	contentValues.put("Date", m.getDate());
    	contentValues.put("Ml", m.getMl());
    	contentValues.put("Note", m.getNote());
    	db.insert("Maaling", null , contentValues);
    	}
    	catch(android.database.sqlite.SQLiteException ex){
    	}
    }
    
    public Maaling getMaaling(int id)
    {
    	Maaling m = new Maaling();
    	SQLiteDatabase db = this.getReadableDatabase();
    	Cursor c = db.rawQuery("select ID, Time, Date, Ml, Note from Maaling where ID="+id, null);
    	if(c.moveToFirst())
    	{
    		while(c.isAfterLast() == false){
    			int ID = Integer.parseInt(c.getString(c.getColumnIndex("ID")));
    			String Time = c.getString(c.getColumnIndex("Time"));
    			String Date = c.getString(c.getColumnIndex("Date"));
    			int Ml = Integer.parseInt(c.getString(c.getColumnIndex("Ml")));
    			String Note = c.getString(c.getColumnIndex("Note"));
    			m = new Maaling(ID, Time,Date,Ml,Note);
    			c.moveToNext();
    		}
    	}
    	return m;
    }
    
    public ArrayList<Maaling> getAllMaalinger()
    {
    	ArrayList<Maaling> mList = new ArrayList<Maaling>();
    	Maaling m;
    	SQLiteDatabase db = this.getReadableDatabase();
    	Cursor c = db.rawQuery("select ID, Time, Date, Ml, Note from Maaling", null);
    	if(c != null){
    		if(c.moveToFirst()){
    			while (c.isAfterLast() == false) {
    				int ID = Integer.parseInt(c.getString(c.getColumnIndex("ID")));
    				String Time = c.getString(c.getColumnIndex("Time"));
        			String Date = c.getString(c.getColumnIndex("Date"));
        			int Ml = Integer.parseInt(c.getString(c.getColumnIndex("Ml")));
        			String Note = c.getString(c.getColumnIndex("Note"));
        			m = new Maaling(ID, Time,Date,Ml,Note);
        			mList.add(m);
        			c.moveToNext();
    			}
    		}
    	}
    	return mList;
    }
}