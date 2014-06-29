package com.edu.udea.compumovil.grupo6.yamba7;

import android.content.Context; 
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
// clase que crea una tabla en la base de datos que se utiliza en Android
public class DbHelper extends SQLiteOpenHelper { //
	private static final String TAG = DbHelper.class.getSimpleName();
	
	public DbHelper(Context context) {
		super(context, StatusContract.DB_NAME, null, StatusContract.DB_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// para crear la tabla saca los parametros definidos en la clase StatusContract
		String sql = String.format("create table %s (%s int primary key, %s text,%s text, %s int)",
		StatusContract.TABLE,
		StatusContract.Column.ID,
		StatusContract.Column.USER,
		StatusContract.Column.MESSAGE,
		StatusContract.Column.CREATED_AT);

		Log.d(TAG, "onCreate with SQL: "+sql);
		db.execSQL(sql); 
	}
	
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists " + StatusContract.TABLE);
		onCreate(db);
	}
}
	
