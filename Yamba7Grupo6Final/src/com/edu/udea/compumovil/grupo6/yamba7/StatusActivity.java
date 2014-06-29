package com.edu.udea.compumovil.grupo6.yamba7;

import com.edu.udea.compumovil.grupo6.yamba7.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

// actividad que maneja la publicacion de un nuevo mensaje 
public class StatusActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	// este codigo muestra la vista de manera estatica 
	setContentView(R.layout.activity_status);
	if (savedInstanceState == null) { //
		// este codigo muestra la vista de manera dinamica
//		StatusFragment fragment = new StatusFragment(); 
//		StatusImagen fragmento = new StatusImagen(); 
//		getFragmentManager().beginTransaction().add(android.R.id.content, fragment,	fragment.getClass().getSimpleName()).add(android.R.id.content, fragmento,fragmento.getClass().getSimpleName()).commit(); 
//	
		 
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) { //
			case R.id.action_settings:
				startActivity(new Intent(this, SettingsActivity.class)); 
				return true; //
			case R.id.action_tweet:
				startActivity(new Intent(this, StatusActivity.class)); //"com.edu.udea.compumovil.grupo6.yamba3.action.tweet"));
				return true;
			case R.id.action_refresh:
				startService(new Intent(this,RefreshService.class));
				return true;
			default:
				return false;
		}
	}
}
