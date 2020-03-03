package com.example.android.FinalProject;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class ShakeHelper implements SensorEventListener {
    public ShakeHelper(Context context){
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    }

    public void setOnShakeListener( OnShakeListener onShakeListener ){
        mOnShakeListener = onShakeListener;
    }

    public void onResume(){
        mSensorManager.registerListener(this,
                mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onPause(){
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();
        float[] values = event.values;
        if (sensorType == Sensor.TYPE_ACCELEROMETER){
            if ((Math.abs(values[0]) > SENSOR_VALUE || Math.abs(values[1]) > SENSOR_VALUE || Math.abs(values[2]) > SENSOR_VALUE)){
                if( null != mOnShakeListener ){
                    mOnShakeListener.onShake( );
                }
            }
        }
    }

    public interface OnShakeListener{
        public void onShake();
    }

    private SensorManager mSensorManager = null;
    private OnShakeListener mOnShakeListener = null;
    private static final int SENSOR_VALUE = 14;
}
