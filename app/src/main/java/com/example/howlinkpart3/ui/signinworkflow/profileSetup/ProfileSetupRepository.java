package com.example.howlinkpart3.ui.signinworkflow.profileSetup;

import android.app.Application;
import android.content.Context;
import android.media.AsyncPlayer;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProfileSetupRepository {
    private ArrayList<String> data = new ArrayList<>();
    private String pincode;
    private Context context;

    public ProfileSetupRepository(String pincode, Application application) {
        this.context = application;
        this.pincode = pincode;
    }

    public ArrayList<String> getData() {
        fetchData(pincode);
        return data;
    }

    private void fetchData(String pincode) {
        String uri = "https://api.postalpincode.in/pincode/";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, uri + pincode, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject object = response.getJSONObject("PostOffice");
                            data.add(object.getString("Circle"));
                            data.add(object.getString("District"));
                            data.add(object.getString("State"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MySingleton.getInstance(context).addToQueue(jsonObjectRequest);

    }
}