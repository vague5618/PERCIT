package com.example.jay.percit.Util;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;


import com.example.jay.percit.Controller.MusicStageActivity;
import com.example.jay.percit.Handler.MusicHandler;
import com.example.jay.percit.Thread.MusicplayerThread;
import com.example.jay.percit.Thread.SoundpoolThread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jay on 2015-07-31.
 */
public class BluetoothThread extends Thread implements Runnable {

    private final static String TAG = "BluetoothThread";

    private final String MY_UUID = "0000ffe1-0000-1000-8000-00805f9b34fb";
    //0000dfb1-0000-1000-8000-00805f9b34fb
    private final String LIST_NAME = "NAME";
    private final String LIST_UUID = "UUID";
    private final String mDeviceAddress = "F4:B8:5E:CC:26:56";
    private Context mContext;
    private BluetoothLeService mBluetoothLeService;
    private ArrayList<ArrayList<BluetoothGattCharacteristic>> mGattCharacteristics =
            new ArrayList<ArrayList<BluetoothGattCharacteristic>>();
    private boolean mConnected = false;
    private BluetoothGattCharacteristic mNotifyCharacteristic;
    MusicplayerThread musicplayerThread;
    SoundpoolThread soundpoolThread;

    public BluetoothThread(Context mContext, MusicplayerThread musicplayerThread,SoundpoolThread soundpoolThread) {
        this.musicplayerThread = musicplayerThread;
        this.mContext = mContext;
        this.soundpoolThread = soundpoolThread;
    }

    public BluetoothThread(Context mContext, MusicplayerThread musicplayerThread) {
        this.musicplayerThread = musicplayerThread;
        this.mContext = mContext;
    }

    public BluetoothThread(Context mContext, SoundpoolThread soundpoolThread) {
        this.soundpoolThread = soundpoolThread;
        this.mContext = mContext;
    }

    private final ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {


            mBluetoothLeService = ((BluetoothLeService.LocalBinder) service).getService();

            if (!mBluetoothLeService.initialize()) {
                Log.e(TAG, "Unable to initialize Bluetooth");
            }
            // Automatically connects to the device upon successful start-up initialization.

            mBluetoothLeService.connect(mDeviceAddress);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mBluetoothLeService = null;
        }
    };
    // Handles various events fired by the Service.
    // ACTION_GATT_CONNECTED: connected to a GATT server.
    // ACTION_GATT_DISCONNECTED: disconnected from a GATT server.
    // ACTION_GATT_SERVICES_DISCOVERED: discovered GATT services.
    // ACTION_DATA_AVAILABLE: received data from the device.  This can be a result of read
    //                        or notification operations.
    private final BroadcastReceiver mGattUpdateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            if (BluetoothLeService.ACTION_GATT_CONNECTED.equals(action)) {
                mConnected = true;
            } else if (BluetoothLeService.ACTION_GATT_DISCONNECTED.equals(action)) {
                mConnected = false;
            } else if (BluetoothLeService.ACTION_GATT_SERVICES_DISCOVERED.equals(action)) {
                // Show all the supported services and characteristics on the user interface.
                Log.d("Support GattServices", mBluetoothLeService.getSupportedGattServices().toString());
                displayGattServices(mBluetoothLeService.getSupportedGattServices());

            } else if (BluetoothLeService.ACTION_DATA_AVAILABLE.equals(action)) {

                displayData(intent.getStringExtra(BluetoothLeService.EXTRA_DATA));
            }
        }
    };

    private void displayData(String data) {

        if (soundpoolThread != null && data != null) {

            for (int i = 0; i < data.length(); i++) {

                char temp_signal = data.charAt(i);

                if (temp_signal == 127) {
                    char temp_position = data.charAt(++i);

                    float temp_power = Float.parseFloat(String.valueOf(data.charAt(++i)));

                    Log.i("Read temp_position : ", String.valueOf(temp_position));

                    Log.i("Read temp_position : ", String.valueOf(temp_power));

                    soundpoolThread.play(temp_position, temp_power);
                }
            }
        }
    }

    private void displayGattServices(List<BluetoothGattService> gattServices) {
        if (gattServices == null) return;
        String uuid = null;

        mGattCharacteristics = new ArrayList<ArrayList<BluetoothGattCharacteristic>>();

        // Loops through available GATT Services.
        for (BluetoothGattService gattService : gattServices) {

            ArrayList<HashMap<String, String>> gattCharacteristicGroupData =
                    new ArrayList<HashMap<String, String>>();
            List<BluetoothGattCharacteristic> gattCharacteristics =
                    gattService.getCharacteristics();
            ArrayList<BluetoothGattCharacteristic> charas =
                    new ArrayList<BluetoothGattCharacteristic>();

            // Loops through available Characteristics.
            for (BluetoothGattCharacteristic gattCharacteristic : gattCharacteristics) {

                uuid = gattCharacteristic.getUuid().toString();

                System.out.println("====================uuid + " + uuid);

                if (uuid.equals(MY_UUID)) {

                    Log.d("process", "SAME");

                    charas.add(gattCharacteristic);
                    HashMap<String, String> currentCharaData = new HashMap<String, String>();

                    currentCharaData.put(
                            LIST_NAME, "BLUNO 1.8v");
                    currentCharaData.put(LIST_UUID, uuid);
                    gattCharacteristicGroupData.add(currentCharaData);
                    mGattCharacteristics.add(charas);
                }
            }
        }

        HashMap<String, String> currentCharaData = new HashMap<String, String>();

        BluetoothGattCharacteristic characteristic =
                mGattCharacteristics.get(0).get(0);

        final int charaProp = characteristic.getProperties();

        if ((charaProp | BluetoothGattCharacteristic.PROPERTY_READ) > 0) {
            // If there is an active notification on a characteristic, clear
            // it first so it doesn't update the data field on the user interface.
            Log.d("Char", "Property_Read");

            if (mNotifyCharacteristic != null) {
                mBluetoothLeService.setCharacteristicNotification(
                        mNotifyCharacteristic, false);
                mNotifyCharacteristic = null;
            }
            mBluetoothLeService.readCharacteristic(characteristic);
        }
        if ((charaProp | BluetoothGattCharacteristic.PROPERTY_NOTIFY) > 0) {

            Log.d("Char", "Property_NOTIFY");

            mNotifyCharacteristic = characteristic;
            mBluetoothLeService.setCharacteristicNotification(
                    characteristic, true);
        }
    }

    private static IntentFilter makeGattUpdateIntentFilter() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BluetoothLeService.ACTION_GATT_CONNECTED);
        intentFilter.addAction(BluetoothLeService.ACTION_GATT_DISCONNECTED);
        intentFilter.addAction(BluetoothLeService.ACTION_GATT_SERVICES_DISCOVERED);
        intentFilter.addAction(BluetoothLeService.ACTION_DATA_AVAILABLE);
        return intentFilter;
    }

    public void write(byte[] data) {

        BluetoothGattCharacteristic write_characteristic =
                mGattCharacteristics.get(0).get(0);

        mBluetoothLeService.writeCharacteristic(write_characteristic, data);
    }

    public void Thread_onResume() {
        mContext.registerReceiver(mGattUpdateReceiver, makeGattUpdateIntentFilter());
        if (mBluetoothLeService != null) {
            final boolean result = mBluetoothLeService.connect(mDeviceAddress);
            Log.d(TAG, "Connect request result=" + result);
        }
    }

    public void Thread_onPause() {

        if (mGattUpdateReceiver != null)
            mContext.unregisterReceiver(mGattUpdateReceiver);

    }


    public void Thread_onDestroy() {
        mContext.unbindService(mServiceConnection);
        mBluetoothLeService = null;
    }


    public void run() {

        Intent gattServiceIntent = new Intent(mContext, BluetoothLeService.class);
        mContext.bindService(gattServiceIntent, mServiceConnection, mContext.BIND_AUTO_CREATE);

        mContext.registerReceiver(mGattUpdateReceiver, makeGattUpdateIntentFilter());

        if (mBluetoothLeService != null) {
            final boolean result = mBluetoothLeService.connect(mDeviceAddress);
            Log.d(TAG, "Connect request result=" + result);
        }
    }
}
