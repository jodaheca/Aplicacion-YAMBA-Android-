package com.edu.udea.compumovil.grupo6.yamba7;

import android.app.Activity;
import android.os.Bundle;
public class DetailsActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Check if this activity was created before
		if (savedInstanceState == null) { 
			// Create a fragment
			DetailsFragment fragment = new DetailsFragment(); 
			getFragmentManager().beginTransaction().add(android.R.id.content, fragment,fragment.getClass().getSimpleName()).commit(); 
		}
	}
}
