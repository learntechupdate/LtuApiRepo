package org.example.chtr;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * splittest class
 *
 * @author touheed.aslam#Realme
 * @version 4.8
 * @updated 29-Jun-24
 * @since 4.8
 */
/*public class splittest {

    public static void main(String[] args) {

        Map<String ,String> attribueUpdate=new TreeMap<>();
        attribueUpdate.put("serviceId","bescom");
        attribueUpdate.put("requestType","hana");
        attribueUpdate.put("zipCode","560043");
        attribueUpdate.put("deviceId:Array#0:type","IMEI2New");
        attribueUpdate.put("feature:Array#1:type","HeyFeature");

//        System.out.println(attribueUpdate);

        for(String key:attribueUpdate.keySet()){
//            System.out.println(key);
            if(key.contains("Array")){
//                System.out.println(key);
                String keyInput = key.split(":")[0];
                System.out.println("keyInput : "+keyInput);
                String ArrayIndex = key.split(":")[1].toString().split("#")[1];
                System.out.println("ArrayIndex : "+ArrayIndex);
                String keyValueInput = key.split(":")[2];
                System.out.println("keyValueInput : "+keyValueInput);
                attribueUpdate.put(keyInput,keyValueInput);
            }
        }

        System.out.println(attribueUpdate);


    }
}*/

public class splittest {

    public static void main(String[] args) {

        Map<String, String> attribueUpdate = new TreeMap<>();
        attribueUpdate.put("serviceId", "bescom");
        attribueUpdate.put("requestType", "hana");
        attribueUpdate.put("zipCode", "560043");
        attribueUpdate.put("deviceId:Array#0:type", "IMEI2New");
        attribueUpdate.put("feature:Array#1:type", "HeyFeature");

        System.out.println("Before updates:");
        System.out.println(attribueUpdate);

        // Collect updates in a separate map to avoid ConcurrentModificationException
        Map<String, String> updates = new HashMap<>();

        for (String key : attribueUpdate.keySet()) {
            if (key.contains("Array")) {
                String[] parts = key.split(":");
                String keyInput = parts[0];
                String ArrayIndex = parts[1].split("#")[1];
                String keyValueInput = parts[2];
                // Construct the updated key and value
                String updatedKey = keyInput;
                String updatedValue = keyValueInput;
                // Put the update into the updates map
                updates.put(updatedKey, attribueUpdate.get(key));
            }
        }

        // Apply updates to the original map
        for (Map.Entry<String, String> entry : updates.entrySet()) {
            attribueUpdate.put(entry.getKey(), entry.getValue());
        }

        System.out.println("After updates:");
        System.out.println(attribueUpdate);
    }
}
