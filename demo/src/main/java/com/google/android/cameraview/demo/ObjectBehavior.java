/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.cameraview.demo;

import static android.content.ContentValues.TAG;

import android.location.Location;
import android.util.Log;

/**
 * Created by mirzakhalov on 4/17/18.
 */

public class ObjectBehavior {

    public static Location currentLoc = new Location("");
    public static Location targetLoc = new Location("");

    // sets the current target coordinates and returns it as a Location object
    public static Location identifyTarget(){
        double lat1 = 28.05999936;
        double lon1 = -82.41508884;
        targetLoc.setLatitude(lat1);
        targetLoc.setLongitude(lon1);
        return targetLoc;

    }

    // calculates the distance between the current and target coordinates. This is called from the main and updated in the listener
    public static float CalculateDistance(){
        Log.d("CurLat", String.valueOf(currentLoc.getLatitude()));
        Log.d("CurLon", String.valueOf(currentLoc.getLongitude()));
        Log.d("TarLat", String.valueOf(identifyTarget().getLatitude()));
        Log.d("TarLon", String.valueOf(identifyTarget().getLongitude()));
        return currentLoc.distanceTo(identifyTarget());
    }

    // reference from https://stackoverflow.com/questions/6189258/

    public static float CalculateRotation(){
        return currentLoc.bearingTo(identifyTarget());
    }
}
