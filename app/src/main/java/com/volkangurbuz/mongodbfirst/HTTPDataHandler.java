package com.volkangurbuz.mongodbfirst;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by VolkanGurbuz on 2/22/2018.
 */

public class HTTPDataHandler {

    static String stream = null;

    public HTTPDataHandler() {
    }


    public String getHTTPData(String urlString) {

        try {

            URL url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //check connection status
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream in = new BufferedInputStream(httpURLConnection.getInputStream());
                BufferedReader r = new BufferedReader(new InputStreamReader(in));

                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = r.readLine()) != null) {
                    sb.append(line);
                    stream = sb.toString();
                    httpURLConnection.disconnect();

                }


            } else {


            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stream;
    }

    public void PostHTTPData(String url, String json) {

        try {
            URL urlLink = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlLink.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);


            byte[] out = json.getBytes(StandardCharsets.UTF_8);
            int length = out.length;
            httpURLConnection.setFixedLengthStreamingMode(length);
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset-UTF-8");
            httpURLConnection.connect();

            try (OutputStream os = httpURLConnection.getOutputStream()) {

                os.write(out);

            }

            InputStream response = httpURLConnection.getInputStream();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void PutHTTPData(String url, String newValue) {

        try {
            URL urlLink = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlLink.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);


            byte[] out = newValue.getBytes(StandardCharsets.UTF_8);
            int length = out.length;
            httpURLConnection.setFixedLengthStreamingMode(length);
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset-UTF-8");
            httpURLConnection.connect();

            try (OutputStream os = httpURLConnection.getOutputStream()) {

                os.write(out);

            }

            InputStream response = httpURLConnection.getInputStream();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void DeleteHTTPData(String url, String json) {

        try {
            URL urlLink = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlLink.openConnection();
            httpURLConnection.setRequestMethod("DELETE");
            httpURLConnection.setDoOutput(true);


            byte[] out = json.getBytes(StandardCharsets.UTF_8);
            int length = out.length;
            httpURLConnection.setFixedLengthStreamingMode(length);
            httpURLConnection.setRequestProperty("Content-Type", "application/json; charset-UTF-8");
            httpURLConnection.connect();

            try (OutputStream os = httpURLConnection.getOutputStream()) {

                os.write(out);

            }

            InputStream response = httpURLConnection.getInputStream();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
