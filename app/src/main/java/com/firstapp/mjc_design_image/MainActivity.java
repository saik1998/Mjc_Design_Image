package com.firstapp.mjc_design_image;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.integration.android.IntentIntegrator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Context context;
    List<ModelClass> modelClassList = new ArrayList<>();
    ModelClass modelClass;
    AdapterClass adapterClass;
    RecyclerView recyclerView;
    AppCompatButton apply;
    AlertDialog alertDialog;
    ImageView qrcodeScanner;
    Spinner spinner1,spinner2;

    private static final int CAMERA_PERMISSION_CODE = 101;



    FloatingActionButton floatingActionButton;

    ImageView downarrow1, downarrow2;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.statusbar));

//        spinner1=findViewById(R.id.Spinner1);
//        ArrayAdapter<String> myAdapter1=new ArrayAdapter<String>(MainActivity.this,
//                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
//                getResources().getStringArray(R.array.filter1));
//
//        myAdapter1.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
//        spinner1.setAdapter(myAdapter1);

//        spinner2=findViewById(R.id.Spinner2);
//        ArrayAdapter<String> myAdapter2=new ArrayAdapter<String>(MainActivity.this,
//                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
//                getResources().getStringArray(R.array.filter2));
//
//        myAdapter2.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
//        spinner2.setAdapter(myAdapter2);




        qrcodeScanner=findViewById(R.id.Qr_CodeScanner);
        qrcodeScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (checkPermission(Manifest.permission.CAMERA)) {
                        openScanner();

                    } else {
                        requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
                    }
                } else
                {
                    openScanner();
                }


            }
        });

        floatingActionButton=findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                View root=getLayoutInflater().inflate(R.layout.floating_action,null);

                builder.setView(root);
                builder.setCancelable(true);

                alertDialog = builder.create();
                alertDialog.show();



        }
        });



//        downarrow1 = findViewById(R.id.down_arrow1);
//        downarrow1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                ArrayList<String> list = new ArrayList<>();
//                list.add("filter1");
//                list.add("filter2");
//                list.add("filter3");
//                list.add("filter4");
//
//                ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list);
//        downarrow1.setAdapter(adapter);
//        downarrow2.setAdapter(adapter);
//
//            }
//        });
//
//        downarrow2 = findViewById(R.id.down_arrow2);
//        downarrow2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        textView1 = findViewById(R.id.filter1);


        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        adapterClass = new AdapterClass(this, modelClassList);
        recyclerView.setAdapter(adapterClass);


//
//        count.setText(""+adapterClass.mode.size());


        loadData();


    }

    private void openScanner() {
        new IntentIntegrator(MainActivity.this).initiateScan();

    }
    private boolean checkPermission(String camera) {
        int result = ContextCompat.checkSelfPermission(MainActivity.this, camera);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;

        } else {
            return false;
        }
    }

    private void requestPermission(String permision, int code) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, permision)) {

        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{permision}, code);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CAMERA_PERMISSION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openScanner();
                }
        }
    }

    private void loadData() {
        modelClass = new ModelClass("9988776655", "Hyderabad", "533700", "NW8 8QN", "27-10-22 10:00 Am", "28-10-22 10:00 pm"
                , "the capital and largest city of the Indian state of Telangana.");

        modelClassList.add(modelClass);


        modelClass = new ModelClass("8899977755", "Bengaluru", "529009", "NW8 8QN", "28-11-22 11:00 Am", "28-10-22 09:30 pm"
                , "the capital and largest city of the Indian state of Karnataka.");

        modelClassList.add(modelClass);


        modelClass = new ModelClass("9888877722", "Vizag", "533444", "NW8 8QN", "30-10-22 10:00 Am", "08-10-22 10:00 pm",
                "Visakhapatnam also known as Vizag is the largest and most populous");

        modelClassList.add(modelClass);


        modelClass = new ModelClass("9000222330", "Rajamundry", "533432", "NW8 8QN", "17-10-22 10:00 Am", "18-10-22 10:00 pm"
                , "a city in the Indian state of Andhra Pradesh and District");

        modelClassList.add(modelClass);

        modelClass = new ModelClass("9090909090", "Kakinada", "533431", "NW8 8QN", "07-10-22 10:00 Am", "06-10-22 10:00 pm"
                , "Kakinada (formerly called Kakinada,Coringa,and Cocanada;listen");

        modelClassList.add(modelClass);

        modelClass = new ModelClass("8080808080", "Vijayawada", "533420", "NW8 8QN", "17-10-22 10:00 Am", "18-10-22 10:00 pm"
                , "the second largest city in the Indian state of Andhra Pradesh");

        modelClassList.add(modelClass);


        modelClass = new ModelClass("8899977755", "Bengaluru", "529009", "NW8 8QN", "28-11-22 11:00 Am", "28-10-22 09:30 pm"
                , "the capital and largest city of the Indian state of Karnataka.");

        modelClassList.add(modelClass);


        modelClass = new ModelClass("9888877722", "Vizag", "533444", "NW8 8QN", "30-10-22 10:00 Am", "08-10-22 10:00 pm",
                "Visakhapatnam also known as Vizag is the largest and most populous");

        modelClassList.add(modelClass);


        modelClass = new ModelClass("9000222330", "Rajamundry", "533432", "NW8 8QN", "17-10-22 10:00 Am", "18-10-22 10:00 pm"
                , "a city in the Indian state of Andhra Pradesh and District");

        modelClassList.add(modelClass);

    }
}

