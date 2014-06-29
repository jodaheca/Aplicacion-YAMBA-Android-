package com.edu.udea.compumovil.grupo6.yamba7;

import java.util.List;

import com.marakana.android.yamba.clientlib.YambaClient;
import com.marakana.android.yamba.clientlib.YambaClient.Status;
import com.marakana.android.yamba.clientlib.YambaClientException;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
 // Inten Service que se encarga de actualizar la informacion de la base de datos, toma los ultimos 
 // mensajes publicados en la pagina y los trae hasta la base de datos que utiliza la aplicacion
public class RefreshService extends IntentService{
	static final String TAG = "RefreshService";
	
	public RefreshService() { //
		super(TAG);
		}
	
	@Override
	public void onCreate() { //
	super.onCreate();
	Log.d(TAG, "Servicio Creado");
	}
	
	@Override
	protected void onHandleIntent(Intent intent) { //
		Log.d(TAG, "Servicio en ejecucion ");
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this); //
				final String username = prefs.getString("username", "");
				final String password = prefs.getString("password", "");
				if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
					//
					Toast.makeText(this,"Por favor actualice su usuario y contraseña",Toast.LENGTH_LONG).show();
					return;
				}
				Log.d(TAG, "onStarted");
//				DbHelper dbHelper = new DbHelper(this); //
//				SQLiteDatabase db = dbHelper.getWritableDatabase(); 
				ContentValues values = new ContentValues();
				YambaClient cloud = new YambaClient(username, password); //
				try {
					int count = 0;
					// toma las ultimas 20 publicaciones de la pagina
				List<Status> timeline = cloud.getTimeline(20); //
				for (Status status : timeline) { 
					values.clear(); //
					values.put(StatusContract.Column.ID, status.getId());
					values.put(StatusContract.Column.USER,status.getUser());
					values.put(StatusContract.Column.MESSAGE,status.getMessage());
					values.put(StatusContract.Column.CREATED_AT, status.getCreatedAt().getTime());
//					db.insertWithOnConflict(StatusContract.TABLE, null, values,SQLiteDatabase.CONFLICT_IGNORE);
					
					Uri uri = getContentResolver().insert(StatusContract.CONTENT_URI, values); //
							if (uri != null) {
							count ++; 
							Log.d(TAG,String.format("%s: %s", status.getUser(),status.getMessage()));
							}
							
				}
				
				if (count > 0) {
					sendBroadcast(new Intent("com.edu.udea.compumovil.grupo6.yamba7.action.NEW_STATUSES").putExtra("count", count)); //
				}
				
				} catch (YambaClientException e) { //
				Log.e(TAG, "Error en el tiempo de actualización.", e);
				e.printStackTrace();
				}
				return;
		}
	
	@Override
	public void onDestroy() { //
	super.onDestroy();
	Log.d(TAG, "Servicio destruido");
	}

}
