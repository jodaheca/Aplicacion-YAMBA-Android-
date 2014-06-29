package com.edu.udea.compumovil.grupo6.yamba7;

import com.edu.udea.compumovil.grupo6.yamba7.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
// contiene la imagen que se muestra  al momento de hacer una nueva publicacion
public class StatusImagen extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 	Bundle savedInstanceState) {
			View vista = inflater.inflate(R.layout.fragment_imagen, container, false);
			return vista;
	}

}
