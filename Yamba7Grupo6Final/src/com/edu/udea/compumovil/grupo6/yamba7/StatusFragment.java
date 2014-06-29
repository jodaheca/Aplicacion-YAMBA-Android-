package com.edu.udea.compumovil.grupo6.yamba7;

import com.edu.udea.compumovil.grupo6.yamba7.R;
import com.marakana.android.yamba.clientlib.YambaClient;
import com.marakana.android.yamba.clientlib.YambaClientException;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//  fragmento que contiene el codigo necesario para publicar un nuevo mensaje
public class StatusFragment extends Fragment implements OnClickListener {
	SharedPreferences prefs;
	private static final String TAG = "StatusActivity";
	private EditText editEstado; 
	private Button btPublicar;
	private TextView textContador; 
	private int defaultTextColor; 
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 	Bundle savedInstanceState) {
			View vista = inflater.inflate(R.layout.fragment_status, container, false);
		
		
		editEstado = (EditText) vista.findViewById(R.id.editEstado); 
		btPublicar = (Button) vista.findViewById(R.id.editarEstado);
		textContador = (TextView) vista.findViewById(R.id.textCount); 
		
		btPublicar.setOnClickListener(this);
		
		defaultTextColor = textContador.getTextColors().getDefaultColor();
		//defaultTextColor= (Color.GREEN);
		
		editEstado.addTextChangedListener(new TextWatcher() { 
				@Override
				public void afterTextChanged(Editable s) { 

				int count = 140 - editEstado.length(); 
				textContador.setText(Integer.toString(count));
				textContador.setTextColor(Color.GREEN); 
				if (count < 10)
					textContador.setTextColor(Color.RED);
				else
					textContador.setTextColor(defaultTextColor);
				}@Override
				public void beforeTextChanged(CharSequence s, int start, int count, int after) { 
						}
			    @Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {
				}
				});
		return vista;
	}

	@SuppressLint("ShowToast")
	@Override
	public void onClick(View view) { 
	String status = editEstado.getText().toString(); 
	Log.d(TAG, "Publicaron el estado: " + status); 
	
	new PostTask().execute(status);
	
//	Toast toast1 = Toast.makeText(getApplicationContext(),
//                    "Mensaje Publicado", Toast.LENGTH_SHORT);
//	  toast1.show();
	}

	private final class PostTask extends AsyncTask<String, Void, String> { 
	@Override
	protected String doInBackground(String... params) { 
		
		try {
			SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity()); 
			String username = prefs.getString("username", ""); 
			String password = prefs.getString("password", "");
			String direccion = prefs.getString("servidor", "");
			
			if (TextUtils.isEmpty(username) ||TextUtils.isEmpty(password)) { 
				getActivity().startActivity(new Intent(getActivity(), SettingsActivity.class));
				return "Ingrese un usuario y contraseña para publicar";
			}
			
			YambaClient cloud = new YambaClient(username, password,direccion);
			
			cloud.postStatus(params[0]);
			return "Publicado exitosamente.";
		} catch (YambaClientException e) {
			e.printStackTrace();
			return "Error al intentar publicar.";
		}
	}
	
	@Override
	protected void onPostExecute(String result) {

	super.onPostExecute(result);
	Toast.makeText(StatusFragment.this.getActivity(), result, Toast.LENGTH_LONG).show();
	}
	}

	


}
