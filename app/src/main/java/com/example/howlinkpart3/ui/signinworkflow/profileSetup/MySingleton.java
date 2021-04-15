package com.example.howlinkpart3.ui.signinworkflow.profileSetup;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {
    private static MySingleton instance;
    private RequestQueue requestQueue;
    private Context ctx;

    public MySingleton(Context context){
        ctx = context;
    }
    public static synchronized MySingleton getInstance(Context context)
    {
        if(instance==null)
        {
            instance = new MySingleton(context);

        }
        return instance;

    }

    public RequestQueue getRequestQueue() {
        if(requestQueue==null) {
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToQueue(Request<T> req)
    {
        getRequestQueue().add(req);
    }
}
