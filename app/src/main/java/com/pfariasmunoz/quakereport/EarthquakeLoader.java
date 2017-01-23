package com.pfariasmunoz.quakereport;

import android.content.Context;
import android.content.AsyncTaskLoader;

import java.util.List;

/**
 * Loads a list of earthquakes by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>>{
    /** Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /** Query URL */
    String mUrl;

    /**
     * Constructs a new {@link EarthquakeLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public EarthquakeLoader(Context context, String url) {
        super(context);
        this.mUrl = url;
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Earthquake> loadInBackground() {
        // Don't perform the request if there are no URLs, or the first URL is null.
        if (mUrl == null) {
            return null;
        }

        List<Earthquake> earthquakes = QueryUtils.extractEarthquakes(mUrl);
        return earthquakes;
    }

    /**
     * method to call forceLoad() which is a required step to actually
     * trigger the loadInBackground() method to execute.
     */
    @Override
    protected void onStartLoading() {
        forceLoad();
    }

}
