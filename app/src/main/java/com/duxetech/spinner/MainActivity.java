package com.duxetech.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    Spinner spCountry,spState,spCity;
    ArrayAdapter<String> adapterCountry, adapterState, adapterCity;
    String coun, state, city;
    int i = 0;

    ArrayList<String> Countries = new ArrayList<>(asList("Select Country","India", "Canada","US"));

    ArrayList<String> stateIndia = new ArrayList<>(asList("Select State","TN","Andhra","Maha"));
    ArrayList<String> stateUS = new ArrayList<>(asList("Select State","Newyork","Washington","California"));
    ArrayList<String> stateCanada = new ArrayList<>(asList("Select State","Toronto","Victoria","Edmonton"));

    ArrayList<String> TNCity = new ArrayList<>(asList("Select City","Chennai", "Madurai","Trichi","Chennai", "Madurai","Thiruchi"));
    ArrayList<String> AndhraCity = new ArrayList<>(asList("Select City", "Secund","Nellore","Hyd", "Secund","Nellore"));
    ArrayList<String> MahaCity = new ArrayList<>(asList("Select City", "Pune","Mumbai", "Pune"));

    ArrayList<String> Newyork = new ArrayList<>(asList("Select City","US1", "US2","US1", "US2"));
    ArrayList<String> Washington = new ArrayList<>(asList("Select City","US1", "US2","US1", "US2"));
    ArrayList<String> California = new ArrayList<>(asList("Select City","US1", "US2","US1", "US2"));

    ArrayList<String> Toronto = new ArrayList<>(asList("Select City","Ca1", "Ca2","Ca3", "Ca4"));
    ArrayList<String> Victoria = new ArrayList<>(asList("Select City","Ca1", "Ca2","Ca3", "Ca4"));
    ArrayList<String> Edmonton = new ArrayList<>(asList("Select City","Ca1", "Ca2","Ca3", "Ca4"));

    ArrayList<ArrayList<String>> states = new ArrayList<>(asList(stateIndia,stateCanada,stateUS));

    ArrayList<ArrayList<String>> cityIndia = new ArrayList<>(asList(TNCity,AndhraCity,MahaCity));
    ArrayList<ArrayList<String>> cityUS = new ArrayList<>(asList(Newyork,Washington,California));
    ArrayList<ArrayList<String>> cityCanada = new ArrayList<>(asList(Toronto,Victoria,Edmonton));

    ArrayList<ArrayList<ArrayList<String>>> cities = new ArrayList<>(asList(cityIndia, cityCanada,cityUS));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spCountry = findViewById(R.id.spCountry);
        spState = findViewById(R.id.spState);
        spCity = findViewById(R.id.spCity);

        adapterCountry = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, Countries);
        spCountry.setAdapter(adapterCountry);

        spCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position>0){
                        loadStateSpinner(states.get(position-1));
                        i = position;
                    coun = adapterCountry.getItem(i);
                    spCity.setAdapter(null);

                } else  {
                    spState.setAdapter(null);
                    spCity.setAdapter(null);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position>0){
                    loadCitySpinner(cities.get(i-1).get(position-1));
                    state = adapterState.getItem(position);

               } else
                   spCity.setAdapter(null);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                city = adapterCity.getItem(position);

                if(position>0){
                  Toast.makeText(MainActivity.this, ""+coun+" "+state+" "+city, Toast.LENGTH_SHORT).show();}
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    void loadStateSpinner(ArrayList<String> a){
        adapterState = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, a);
        spState.setAdapter(adapterState);

    }
    void loadCitySpinner(ArrayList<String> a){
        adapterCity = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, a);
        spCity.setAdapter(adapterCity);

    }
}
