package com.edu.udea.compumovil.grupo6.yamba7;
 // fragmento que contiene el cosigo necesario para manejar el menu de configuraciones
import com.edu.udea.compumovil.grupo6.yamba7.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class SettingsFragment extends PreferenceFragment implements OnSharedPreferenceChangeListener { 
	private SharedPreferences prefs;
	
	@Override
	public void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings); 
	}
	@Override
	public void onStart() {
		super.onStart();
		prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
		prefs.registerOnSharedPreferenceChangeListener(this);
	}
	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
	
	
}
}