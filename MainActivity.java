package com.bazutz.myfirstapp;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final SensorManager sman = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = sman.getSensorList(Sensor.TYPE_ALL);
        String[] strings = new String[sensors.size()];
        int i = 0;
        for(Sensor sensor:sensors) {
          StringBuilder s = new StringBuilder(sensor.getName());
          s.append(", Type ").append(sensor.getStringType())
           .append(", Power ").append(sensor.getPower()).append(" mA");
          strings[i++] = new String(s.toString());
        }
        ArrayAdapter<String> adapter =
          new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings);
        final ListView listview = (ListView)findViewById(R.id.listview);
        listview.setAdapter(adapter);
    }
}
