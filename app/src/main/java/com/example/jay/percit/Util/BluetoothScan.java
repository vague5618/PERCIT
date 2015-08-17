package com.example.jay.percit.Util;

/**
 * Created by Jay on 2015-07-31.
 */

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;

/**
 * Activity for scanning and displaying available Bluetooth LE devices.
 */
public class BluetoothScan extends Thread {

    private BluetoothThread mBluetoothThread;
    private BluetoothAdapter mBluetoothAdapter;
    private boolean mScanning;
    private Handler mHandler;

    private final String mDeviceAddress = "F4:B8:5E:CC:26:56";
    // Stops scanning after 10 seconds.
    private static final long SCAN_PERIOD = 10000;


    public BluetoothScan(BluetoothAdapter mBluetoothAdapter, Handler mHandler,BluetoothThread mBluetoothThread) {
        this.mBluetoothAdapter = mBluetoothAdapter;
        this.mHandler = mHandler;
        this.mBluetoothThread = mBluetoothThread;
    }

    @Override
    public void run() {

        Scaning();
    }

    public void Scaning() {

        if (mScanning) {
            mBluetoothAdapter.stopLeScan(mLeScanCallback);
            mScanning = false;
        }

        scanLeDevice(true);
    }

    private void scanLeDevice(final boolean enable) {

        if (enable) {
            // Stops scanning after a pre-defined scan period.
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mScanning = false;
                    mBluetoothAdapter.stopLeScan(mLeScanCallback);
                }
            }, SCAN_PERIOD);

            mScanning = true;
            mBluetoothAdapter.startLeScan(mLeScanCallback);

            System.out.println("=======================bluetooth startScan");

        } else {
            mScanning = false;
            mBluetoothAdapter.stopLeScan(mLeScanCallback);
        }
    }

    // Device scan callback.
    private BluetoothAdapter.LeScanCallback mLeScanCallback =
            new BluetoothAdapter.LeScanCallback() {

                @Override
                public void onLeScan(final BluetoothDevice device, int rssi, byte[] scanRecord) {

                    if(mDeviceAddress.equals(device.getAddress()))
                    {
                        mBluetoothAdapter.stopLeScan(mLeScanCallback);
                        mBluetoothThread.start();
                    }
                }
            };


    public void Bluetooth_onDestory()
    {
        mBluetoothThread.Thread_onDestroy();
    }

    public void Bluetooth_onPause()
    {
        mBluetoothThread.Thread_onPause();
    }
    public void Bluetooth_onResume()
    {
        mBluetoothThread.Thread_onResume();
    }

}