package com.wockito.codescanner;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.SparseArray;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;

/**
 * Created by mr1holmes on 11/28/16.
 */
public class DetectorProcessor implements Detector.Processor<Barcode> {
    private Context mContext;

    DetectorProcessor(Context context) {

        mContext = context;
    }

    @Override
    public void release() {

    }

    @Override
    public void receiveDetections(Detector.Detections<Barcode> detections) {
        SparseArray<Barcode> items = detections.getDetectedItems();

        if (items.size() > 0) {
            Barcode item = items.valueAt(0);
            if (item != null && item.rawValue != null) {
                Log.d("Processor", "BarCode detected! " + item.rawValue);
                Intent intent = new Intent(mContext, ResultActivity.class);
                intent.putExtra(mContext.getResources().getString(R.string.qr_result), item.rawValue);
                mContext.startActivity(intent);
            }
        }

    }

}

