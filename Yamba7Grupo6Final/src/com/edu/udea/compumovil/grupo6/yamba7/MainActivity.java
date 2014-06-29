package com.edu.udea.compumovil.grupo6.yamba7;

import com.edu.udea.compumovil.grupo6.yamba7.R;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.os.Build;
// Actividad Principal, es la que se carga al iniciar la plicacion
public class MainActivity extends Activity {
    
	// primer metodo que se ejecuta en toda actividad 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// por medio de esta instruccion se carga la vista en xml para mostrar en la pantalla
		setContentView(R.layout.activity_main);
		
		Log.d("mainActivity","entró");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// esta instuccion carga el menu de la aplicacion que esta en el xml main (en caso de tener un menu)
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	// metodo que permite leer a que elemento del menu se le dio clic.
	public boolean onOptionsItemSelected(MenuItem item) {
		// obtiene el evento que indica que se presiono.
		switch (item.getItemId()) { 
		 // en caso de presionar en configuracion inicia la actividad correspondiente
			case R.id.action_settings:
				startActivity(new Intent(this, SettingsActivity.class)); 
				return true; //
			case R.id.action_tweet:
				startActivity(new Intent(this, StatusActivity.class)); //"com.edu.udea.compumovil.grupo6.yamba3.action.tweet"));
				return true;
			case R.id.action_refresh:
				startService(new Intent(this,RefreshService.class));
				return true;
			case R.id.action_purge:
				int rows = getContentResolver().delete(StatusContract.CONTENT_URI, null, null);
				Toast.makeText(this, "Deleted "+rows+" rows",
				Toast.LENGTH_LONG).show();
				return true;	
			default:
				return false;
		}
	}



}
