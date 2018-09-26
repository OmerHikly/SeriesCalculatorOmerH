package com.example.omer4.seriescalculatoromerh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CalculatingActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    TextView tv1;
    TextView tv2;
    ListView lv;
    Boolean bo;
    double Fnum;
    double Formu;
    double SN;
    double []Series=new double[20];
    String[] st=new String[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculating);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv1=(TextView) findViewById(R.id.tv1);
        tv2=(TextView) findViewById(R.id.tv2);
        lv=(ListView) findViewById(R.id.lv);
        Intent gi=getIntent();
        Fnum=gi.getDoubleExtra("key",0);
        Formu=gi.getDoubleExtra("keykey",0);
        bo=gi.getBooleanExtra("keykey dylm",false);
        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        Series[0]=Fnum;
        if(bo==false){
            for (int i=1;i<20;i++){
                Series[i]=Series[i-1]+Formu;
            }
    }
        else{
            for (int i=1;i<20;i++) {
                Series[i] = Series[i - 1] * Formu;

            }
        }
        for(int j=0;j<20;j++) {
            st[j] = String.valueOf(Series[j]);
        }
        ArrayAdapter<String> adp;
        adp = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,st);
        lv.setAdapter(adp);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int location, long l) {
         location=location+1;
        tv1.setText("location:"+location);
        if (bo==false){
            SN=location*(2*Fnum+Formu*(location-1))/2;
        }
        else{
            SN=Fnum*(Math.pow(Formu,(location))-1)/(Formu-1);
        }
        tv2.setText("Sn="+SN);

    }
}
