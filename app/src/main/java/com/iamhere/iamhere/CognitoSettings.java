package com.iamhere.iamhere;

import android.content.Context;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.regions.Regions;

public class CognitoSettings {

    private String userPoolId = "eu-central-1_ZbYscmLDz";
    private String clientId = "4ke6u7jmupb1bgr7vcbofmkrbp";
    private String clientSecret = "1m8qc05bhsgmr8jjsif4ecm10pnmtls21hhtvo4jolkh5r153uf0";
    private Regions region = Regions.EU_CENTRAL_1;

    private Context context;


    public CognitoSettings(Context context){
        this.context = context;
    }

    public String getUserPoolId() {
        return userPoolId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public Regions getRegion() {
        return region;
    }

    public CognitoUserPool getUserPool(){
        return new CognitoUserPool(context, userPoolId, clientId, clientSecret, region);
    }

}
