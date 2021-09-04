package com.example.parte1exercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager mSensorManager;
    Sensor mAccelerometer;

    EditText sensorX;
    EditText sensorY;
    EditText sensorZ;

    float sensorValueX;
    float sensorValueY;
    float sensorValueZ;

    Double movementThreshold = 15.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorX = findViewById(R.id.sensorX);
        sensorY = findViewById(R.id.sensorY);
        sensorZ = findViewById(R.id.sensorZ);
    }

    private void goToActivity2() {
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener( this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()== Sensor.TYPE_ACCELEROMETER) {

            if (hasAccelerated(sensorValueX, event.values[0]) || hasAccelerated(sensorValueY, event.values[1]) ||  hasAccelerated(sensorValueZ, event.values[2]) ) {
                goToActivity2();
            }


            sensorValueX = event.values[0];
            sensorValueY= event.values[1];
            sensorValueZ = event.values[2];


            sensorX.setText(Float.toString(sensorValueX));
            sensorY.setText(Float.toString(sensorValueY));
            sensorZ.setText(Float.toString(sensorValueZ));
        }
    }

    public boolean hasAccelerated(float oldSensor, float newSensor) {
        return oldSensor + movementThreshold < newSensor;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
    }
}