package com.example.jay.percit.Util;

import android.app.Service;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jay on 2015-08-07.
 */
public class BluetoothConnectService extends Service {

    private final static String TAG = "BluetoothThread";

    private final String MY_UUID = "0000dfb1-0000-1000-8000-00805f9b34fb";

    private final String LIST_NAME = "NAME";
    private final String LIST_UUID = "UUID";
    private final String mDeviceAddress = "D0:39:72:C5:3B:26";

    private MusicHandler mHandler;
    private Context mContext;
    private BluetoothLeService mBluetoothLeService;
    private ArrayList<ArrayList<BluetoothGattCharacteristic>> mGattCharacteristics =
            new ArrayList<ArrayList<BluetoothGattCharacteristic>>();
    private boolean mConnected = false;
    private BluetoothGattCharacteristic mNotifyCharacteristic;


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


    public final BroadcastReceiver gGattUpdateReceiver = new BroadcastReceiver() {
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


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        this.mHandler = MusicStageActivity.gMusicHandler;
        Log.d("process","ok1");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("process", "ok2");
        Intent gattServiceIntent = new Intent(this , BluetoothLeService.class);

        bindService(gattServiceIntent, mServiceConnection, BIND_AUTO_CREATE);

     //   mContext.bindService(gattServiceIntent, mServiceConnection, mContext.BIND_AUTO_CREATE);

        Log.d("process", "ok3");

        this.registerReceiver(gGattUpdateReceiver,makeGattUpdateIntentFilter());


 //       mContext.registerReceiver(gGattUpdateReceiver, makeGattUpdateIntentFilter());
//        if (mBluetoothLeService != null) {
//            final boolean result = mBluetoothLeService.connect(mDeviceAddress);
//            Log.d(TAG, "Connect request result=" + result);
//
//        }
        return 0;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbindService(mServiceConnection);
        mBluetoothLeService = null;
    }

    public void Service_onResume() {
        mContext.registerReceiver(gGattUpdateReceiver, makeGattUpdateIntentFilter());
        if (mBluetoothLeService != null) {
            final boolean result = mBluetoothLeService.connect(mDeviceAddress);
            Log.d(TAG, "Connect request result=" + result);
        }
    }

    private void displayData(String data) {

        if (data != null) {

            for (int i = 0; i < data.length(); i++) {
                char temp_signal = data.charAt(i);

                if (temp_signal == 127) {
                    char temp_position = data.charAt(++i);

                    char temp_power = data.charAt(++i);

                    System.out.println("Read temp_position : " + temp_position);

                    System.out.println("Read temp_power : " + temp_power);

                    mHandler.sendEmptyMessage(temp_power);
                    mHandler.sendEmptyMessage(temp_position);
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

                if (uuid.equals(MY_UUID)) {

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
}


