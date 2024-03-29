package com.edu.udea.compumovil.grupo6.yamba7;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// clase encargada de notificar al usuario que existen nuevos mensajes
public class NotificationReceiver extends BroadcastReceiver { //
	public static final int NOTIFICATION_ID = 42;

	@Override
	public void onReceive(Context context, Intent intent) { //
		NotificationManager notificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE); //
		int count = intent.getIntExtra("count", 0); //
		PendingIntent operation = PendingIntent.getActivity(context, -1,new Intent(context, MainActivity.class),PendingIntent.FLAG_ONE_SHOT); //
		Notification notification = new Notification.Builder(context)
				.setContentTitle("Nuevos Comentarios!")
				.setContentText("Tu tienes " + count + " nuevos comentarios")
				.setSmallIcon(android.R.drawable.sym_action_email)
				.setContentIntent(operation).setAutoCancel(true)
				.getNotification(); //
		notificationManager.notify(NOTIFICATION_ID, notification); //
	}
}
