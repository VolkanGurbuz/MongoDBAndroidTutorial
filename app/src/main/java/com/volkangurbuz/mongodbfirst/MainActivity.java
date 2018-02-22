package com.volkangurbuz.mongodbfirst;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.volkangurbuz.mongodbfirst.Class.User;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstView;
    Button btnAdd, btnEdit, btnDelete;
    EditText edtUser;
    User userSelected = null;
    List<User> users = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstView = findViewById(R.id.lstView);
        btnAdd = findViewById(R.id.btnAdd);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);

        edtUser = findViewById(R.id.edtUserNmae);

        //load data

        new GetData().execute(Common.getAdressAPI());


        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //set text to edittext
                userSelected = users.get(position);
                edtUser.setText(userSelected.getUser());
            }
        });

        //add button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PostData(edtUser.getText().toString()).execute(Common.getAdressAPI());
            }
        });


        //edit button
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PutData(edtUser.getText().toString()).execute(Common.getAdressSingle(userSelected));
            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DeleteData(userSelected).execute(Common.getAdressSingle(userSelected));


            }
        });


    }

    //function process data
    class GetData extends AsyncTask<String, Void, String> {

        ProgressDialog pd = new ProgressDialog(MainActivity.this);


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //pre process
            pd.setTitle("please wait...");
            pd.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String stream = null;
            String urlString = strings[0];

            HTTPDataHandler http = new HTTPDataHandler();
            stream = http.getHTTPData(urlString);
            return stream;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //done process
            //using gson to parse json
            Gson gson = new Gson();
            Type listType = new TypeToken<List<User>>() {
            }.getType();
            users = gson.fromJson(s, listType); //poarse to list
            CustomAdapter adapter = new CustomAdapter(getApplicationContext(), users); //create adapter
            lstView.setAdapter(adapter);
            pd.dismiss();


            pd.dismiss();
        }


    }

    //function to add new user
    class PostData extends AsyncTask<String, String, String> {
        ProgressDialog pd = new ProgressDialog(MainActivity.this);
        String userName;

        public PostData(String userName) {
            this.userName = userName;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd.setTitle("please wait");
            pd.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            new GetData().execute(Common.getAdressAPI());

            pd.dismiss();

        }

        @Override
        protected String doInBackground(String... strings) {
            String urlString = strings[0];

            HTTPDataHandler hd = new HTTPDataHandler();
            String json = "{\"user\":\"" + userName + "\"}";
            hd.PostHTTPData(urlString, json);
            return "";

        }
    }

    //function to edit the user
    class PutData extends AsyncTask<String, String, String> {
        ProgressDialog pd = new ProgressDialog(MainActivity.this);
        String userName;

        public PutData(String userName) {
            this.userName = userName;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd.setTitle("please wait");
            pd.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            new GetData().execute(Common.getAdressAPI());

            pd.dismiss();

        }

        @Override
        protected String doInBackground(String... strings) {
            String urlString = strings[0];

            HTTPDataHandler hd = new HTTPDataHandler();
            String json = "{\"user\":\"" + userName + "\"}";
            hd.PutHTTPData(urlString, json);
            return "";

        }
    }


    //function to delete the user
    class DeleteData extends AsyncTask<String, String, String> {
        ProgressDialog pd = new ProgressDialog(MainActivity.this);
        User user;

        public DeleteData(User user) {
            this.user = user;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd.setTitle("please wait");
            pd.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            new GetData().execute(Common.getAdressAPI());

            pd.dismiss();

        }

        @Override
        protected String doInBackground(String... strings) {
            String urlString = strings[0];

            HTTPDataHandler hd = new HTTPDataHandler();
            String json = "{\"user\":\"" + user.getUser() + "\"}";
            hd.DeleteHTTPData(urlString, json);
            return "";

        }
    }


}
