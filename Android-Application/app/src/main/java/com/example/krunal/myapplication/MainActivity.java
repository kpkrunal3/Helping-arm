package com.example.krunal.myapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends Activity {
    DatabaseHelper myDb;

    private static final String SERVICE_URL = "http://192.168.1.103:8080/BEproject/rest/person";

    private static final String TAG = "AndroidRESTClientActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // boolean flag=false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // myDb= new DatabaseHelper(this);
       // if(flag==false)
       // flag=myDb.search();
    }

    public void retrieveSampleData(View vw) {

        String sampleURL = SERVICE_URL + "/sample";

        WebServiceTask wst = new WebServiceTask(WebServiceTask.GET_TASK, this, "GETting data...");

        wst.execute(new String[]{sampleURL});

    }

    public void clearControls(View vw) {

        EditText edFirstName = (EditText) findViewById(R.id.efname);
        EditText edLastName = (EditText) findViewById(R.id.elname);
        EditText edEmail = (EditText) findViewById(R.id.euname);
        EditText edpassword = (EditText) findViewById(R.id.epass);
        EditText edmobileNumber = (EditText) findViewById(R.id.emobno);

        edFirstName.setText("");
        edLastName.setText("");
        edEmail.setText("");
        edpassword.setText("");
        edmobileNumber.setText("");

    }

    public void postData(View vw) {

        EditText edFirstName = (EditText) findViewById(R.id.efname);
        EditText edLastName = (EditText) findViewById(R.id.elname);
        EditText edEmail = (EditText) findViewById(R.id.euname);
        EditText edpassword = (EditText) findViewById(R.id.epass);
        EditText edmobileNumber = (EditText) findViewById(R.id.emobno);


        String firstName = edFirstName.getText().toString();
        String lastName = edLastName.getText().toString();
        String email = edEmail.getText().toString();
        String password = edpassword.getText().toString();
        String mobileNumber = edmobileNumber.getText().toString();



        if (firstName.equals("") || lastName.equals("") || email.equals("") || password.equals("") || mobileNumber.equals("")) {
            Toast.makeText(this, "Please enter in all required fields.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        WebServiceTask wst = new WebServiceTask(WebServiceTask.POST_TASK, this, "Posting data...");

        wst.addNameValuePair("firstName", firstName);
        wst.addNameValuePair("lastName", lastName);
        wst.addNameValuePair("email", email);
        wst.addNameValuePair("password", password);
        wst.addNameValuePair("mobileNumber", mobileNumber);

        // the passed String is the URL we will POST to
        wst.execute(new String[]{SERVICE_URL});
       // insert();
        Intent intent = new Intent(this, AndroidGPSTrackingActivity.class);
        startActivity(intent);
    }
    public void insert(){
        EditText edFirstName = (EditText) findViewById(R.id.efname);
        EditText edLastName = (EditText) findViewById(R.id.elname);
        EditText edEmail = (EditText) findViewById(R.id.euname);
        EditText edpassword = (EditText) findViewById(R.id.epass);
        EditText edmobileNumber = (EditText) findViewById(R.id.emobno);


        String firstName = edFirstName.getText().toString();
        String lastName = edLastName.getText().toString();
        String email = edEmail.getText().toString();
        String password = edpassword.getText().toString();
        String mobileNumber = edmobileNumber.getText().toString();

        boolean isinserted= myDb.insertData(firstName,lastName,email,password,mobileNumber);
        if(isinserted =true){
            Toast.makeText(MainActivity.this,"DATA INSERTED",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity.this,"DATA NOT INSERTED",Toast.LENGTH_LONG).show();
        }
    }

   /* public void handleResponse(String response) {

        EditText edFirstName = (EditText) findViewById(R.id.efname);
        EditText edLastName = (EditText) findViewById(R.id.elname);
        EditText edEmail = (EditText) findViewById(R.id.euname);
        EditText dpassword = (EditText) findViewById(R.id.epass);
        EditText dmobileNumber = (EditText) findViewById(R.id.emobno);

        edFirstName.setText("");
        edLastName.setText("");
        edEmail.setText("");
        dpassword.setText("");
        dmobileNumber.setText("");
        try {

            JSONObject jso = new JSONObject(response);

            String firstName = jso.getString("firstName");
            String lastName = jso.getString("lastName");
            String email = jso.getString("email");
            String password=jso.getString("password");
            String mobileNumber=jso.getString("mobileNumber");

            edFirstName.setText(firstName);
            edLastName.setText(lastName);
            edEmail.setText(email);
            dmobileNumber.setText(mobileNumber);
            dpassword.setText(password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }*/

    private void hideKeyboard() {

        InputMethodManager inputManager = (InputMethodManager) MainActivity.this
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(
                MainActivity.this.getCurrentFocus()
                        .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private class WebServiceTask extends AsyncTask<String, Integer, String> {

        public static final int POST_TASK = 1;
        public static final int GET_TASK = 2;

        private static final String TAG = "WebServiceTask";

        // connection timeout, in milliseconds (waiting to connect)
        private static final int CONN_TIMEOUT = 3000;

        // socket timeout, in milliseconds (waiting for data)
        private static final int SOCKET_TIMEOUT = 5000;

        private int taskType = GET_TASK;
        private Context mContext = null;
        private String processMessage = "Processing...";

        private ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();

        private ProgressDialog pDlg = null;

        public WebServiceTask(int taskType, Context mContext, String processMessage) {

            this.taskType = taskType;
            this.mContext = mContext;
            this.processMessage = processMessage;
        }

        public void addNameValuePair(String name, String value) {

            params.add(new BasicNameValuePair(name, value));
        }

        private void showProgressDialog() {

            pDlg = new ProgressDialog(mContext);
            pDlg.setMessage(processMessage);
            pDlg.setProgressDrawable(mContext.getWallpaper());
            pDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDlg.setCancelable(false);
            pDlg.show();

        }

        @Override
        protected void onPreExecute() {
            hideKeyboard();
            showProgressDialog();

        }

        protected String doInBackground(String... urls) {

            String url = urls[0];
            String result = "";

            HttpResponse response = doResponse(url);

            if (response == null) {
                return result;
            } else {

                try {

                    result = inputStreamToString(response.getEntity().getContent());

                } catch (IllegalStateException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);
                } catch (IOException e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);
                }

            }

            return result;
        }

       /* @Override
        protected void onPostExecute(String response) {

            handleResponse(response);
            pDlg.dismiss();

        }*/

        // Establish connection and socket (data retrieval) timeouts
        private HttpParams getHttpParams() {

            HttpParams htpp = new BasicHttpParams();

            HttpConnectionParams.setConnectionTimeout(htpp, CONN_TIMEOUT);
            HttpConnectionParams.setSoTimeout(htpp, SOCKET_TIMEOUT);
            return htpp;
        }

        private HttpResponse doResponse(String url) {

            // Use our connection and data timeouts as parameters for our
            // DefaultHttpClient
            HttpClient httpclient = new DefaultHttpClient(getHttpParams());

            HttpResponse response = null;
            try {
                switch (taskType) {

                    case POST_TASK:
                        HttpPost httppost = new HttpPost(url);
                        // Add parameters
                        httppost.setEntity(new UrlEncodedFormEntity(params));

                        response = httpclient.execute(httppost);
                        break;
                    case GET_TASK:
                        HttpGet httpget = new HttpGet(url);
                        response = httpclient.execute(httpget);
                        break;
                }
            } catch (Exception e) {

                Log.e(TAG, e.getLocalizedMessage(), e);

            }
            return response;
        }

        private String inputStreamToString(InputStream is) {

            String line = "";
            StringBuilder total = new StringBuilder();

            // Wrap a BufferedReader around the InputStream
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));

            try {
                // Read response until the end
                while ((line = rd.readLine()) != null) {
                    total.append(line);
                }
            } catch (IOException e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
            }
// Return full string
            return total.toString();
        }


    }
}


