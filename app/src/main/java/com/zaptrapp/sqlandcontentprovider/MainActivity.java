package com.zaptrapp.sqlandcontentprovider;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.zaptrapp.sqlandcontentprovider.Adapter.RecyclerAdapter;

public class MainActivity extends AppCompatActivity {

    private EditText nameET;
    private EditText amountET;
    private EditText shortDescET;
    private RecyclerView recyclerView;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        adapter = new RecyclerAdapter(this);

        recyclerView.setAdapter(adapter);
        Log.d(TAG, "onCreate: "+DbHelperProvider.AMOUNTDATABASE_URI.getAuthority());;

    }

    private void initView() {
        nameET = (EditText) findViewById(R.id.nameET);
        amountET = (EditText) findViewById(R.id.amountET);
        shortDescET = (EditText) findViewById(R.id.shortDescET);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    public static final String TAG = "MainActivity";

    public void addItemsToDatabase(View view) {
        if (nameET.getText().toString().isEmpty() && amountET.getText().toString().isEmpty() && shortDescET.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter All Values", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Adding to database", Toast.LENGTH_SHORT).show();
            DbHelperProviderClient.addAmountDatabase(nameET.getText().toString(), Integer.parseInt(amountET.getText().toString()), shortDescET.getText().toString(), getApplicationContext());
        }

    }
}
