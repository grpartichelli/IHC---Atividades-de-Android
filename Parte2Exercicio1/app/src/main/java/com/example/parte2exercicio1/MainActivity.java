package com.example.parte2exercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor light;
    TextView lightTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lightTextView = findViewById(R.id.lightTextView);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if(light != null) {
            sensorManager.registerListener(MainActivity.this, light, SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            lightTextView.setText("Sensor de luz não existe.");
        }
    }


    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if(sensor.getType() == Sensor.TYPE_LIGHT)
        {
            lightTextView.setText("Intensidade de Luz: " + event.values[0]);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

}