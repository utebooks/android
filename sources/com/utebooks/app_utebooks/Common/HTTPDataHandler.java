package com.utebooks.app_utebooks.Common;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPDataHandler {
    static String stream = null;

    public String GetHTTPData(String urlString) {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(urlString).openConnection();
            if (urlConnection.getResponseCode() == 200) {
                BufferedReader r = new BufferedReader(new InputStreamReader(new BufferedInputStream(urlConnection.getInputStream())));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = r.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                }
                stream = sb.toString();
                urlConnection.disconnect();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return stream;
    }
}
