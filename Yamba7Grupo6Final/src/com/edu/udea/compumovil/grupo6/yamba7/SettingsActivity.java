
package com.edu.udea.compumovil.grupo6.yamba7;

import com.edu.udea.compumovil.grupo6.yamba7.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
// actividad encargada de administrar el menu de configuracion
public class SettingsActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Check whether this activity was created before
		if (savedInstanceState == null) {
		// Create a fragment
		SettingsFragment fragment = new SettingsFragment(); 
		getFragmentManager().beginTransaction().add(android.R.id.content, fragment,fragment.getClass().getSimpleName()).commit(); //
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		// Inflate the menu items to the action bar.
		getMenuInflater().inflate(R.menu.main, menu); //
		return true; //
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		switch (item.getItemId()) 
		{ //
			
			case R.id.action_tweet: startActivity(new Intent(this,StatusActivity.class));
			return true;
			
			case R.id.action_refresh: startService(new Intent(this,RefreshService.class));
			return true;
			
			default: return false;
		}
	}
}
