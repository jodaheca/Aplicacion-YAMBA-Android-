package com.edu.udea.compumovil.grupo6.yamba7;

import android.provider.BaseColumns;
import android.net.Uri;

// clase que contiene las propiedades de la base de datos que se va a crear para la aplicacion, en este caso con una sola tabla
public class StatusContract {

	// constantes de especificacion de la db
	public static final String DB_NAME = "timeline.db";
	public static final int DB_VERSION = 1;
	public static final String TABLE = "status";

	public static final String AUTHORITY = "com.edu.udea.compumovil.grupo6.yamba7.StatusProvider";
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
			+ "/" + TABLE);
	public static final int STATUS_ITEM = 1;
	public static final int STATUS_DIR = 2;
	public static final String STATUS_TYPE_ITEM = "vnd.android.cursor.item/vnd.com.edu.udea.compumovil.grupo6.yamba7.provider.status";
	public static final String STATUS_TYPE_DIR = "vnd.android.cursor.dir/vnd.com.edu.udea.compumovil.grupo6.yamba7.provider.status";

	public static final String DEFAULT_SORT = Column.CREATED_AT + " DESC";

	public class Column {
		public static final String ID = BaseColumns._ID;
		public static final String USER = "user";
		public static final String MESSAGE = "message";
		public static final String CREATED_AT = "created_at";
	}
}
