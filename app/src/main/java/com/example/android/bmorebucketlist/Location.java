package com.example.android.bmorebucketlist;

/**
 * Created by sal on 2/21/17.
 */

public class Location {

    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * Default translation for the word
     */
    private String mTitleDescription;
    /**
     * Miwok translation for the word
     */
    private String mAddressLocation;
    private String mDescription;
    private int mImageResourceID = NO_IMAGE_PROVIDED;


    /**
     * Create a new Word object.
     *
     * @param titleDescription is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param addressLocation   is the word in the Miwok language
     */

    public Location(String titleDescription, String addressLocation, String description) {
        mTitleDescription = titleDescription;
        mAddressLocation = addressLocation;
        mDescription = description;
    }


    public Location(String titleDescription, String addressLocation, String description, int imageResourceID) {
        mTitleDescription = titleDescription;
        mAddressLocation = addressLocation;
        mDescription = description;
        mImageResourceID = imageResourceID;
    }

    /**
     * Get the default translation of the word.
     */
    public String getTitleDescription() {
        return mTitleDescription;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getAddressLocation() {
        return mAddressLocation;
    }


    public int getImageResourceID() {
        return mImageResourceID;
    }

    public boolean hasImage() {
        return mImageResourceID != NO_IMAGE_PROVIDED;

    }

    public String getDescription() {
        return mDescription;
    }

}
