package com.example.warappv1.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.util.Log;

/**
 * Listing 5-11: Implementing a Broadcast Receiver
 */
public class LifeformDetectedReceiver extends BroadcastReceiver {

    public final static String EXTRA_LIFEFORM_NAME
            = "EXTRA_LIFEFORM_NAME";
    public final static String EXTRA_LATITUDE = "EXTRA_LATITUDE";
    public final static String EXTRA_LONGITUDE = "EXTRA_LONGITUDE";

    public static final String
            ACTION_BURN = "com.techhue.alien.action.BURN_IT_WITH_FIRE";

    public static final String
            NEW_LIFEFORM = "com.techhue.alien.action.NEW_LIFEFORM";
    public static final String EXTRA_IMAGE_URI = "EXTRA_IMAGE_URI";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        // Get the lifeform details from the intent.
        Log.d(EXTRA_LIFEFORM_NAME, "onReceive");
        Uri data = intent.getData();
        String type = intent.getStringExtra(EXTRA_LIFEFORM_NAME);
        double lat = intent.getDoubleExtra(EXTRA_LATITUDE, 0);
        double lng = intent.getDoubleExtra(EXTRA_LONGITUDE, 0);
        Uri imageUri = intent.getParcelableExtra(EXTRA_IMAGE_URI);
        Location loc = new Location("gps");
        loc.setLatitude(lat);
        loc.setLongitude(lng);
        if (type.equals("facehugger"))
        {
            Intent startIntent = new Intent(ACTION_BURN, data);
            startIntent.putExtra(EXTRA_LATITUDE, lat);
            startIntent.putExtra(EXTRA_LONGITUDE, lng);
            Log.i("sendDataToServer: ","sent"+imageUri.getPath());
        }
    }
}
