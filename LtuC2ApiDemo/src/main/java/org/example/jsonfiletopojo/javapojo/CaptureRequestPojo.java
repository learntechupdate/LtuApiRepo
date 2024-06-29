package org.example.jsonfiletopojo.javapojo;

import lombok.Data;

import java.util.ArrayList;

/**
 * CaptureRequestPojp class
 *
 * @author touheed.aslam#Realme
 * @version 4.8
 * @updated 29-Jun-24
 * @since 4.8
 */

@Data
public class CaptureRequestPojo {

    private String intent;
    private ArrayList<PurchaseUnit> purchase_units;
    private ApplicationContext application_context;
}


