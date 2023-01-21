package com.example.tiktok_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.tiktok_clone.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
 ActivityMainBinding binding;
 ArrayList<Model> arrayList=new ArrayList<>();
 Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //to remove title bar wo battery icon wala

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//upto this
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // to hide the action bar i.e. app name wala
        getSupportActionBar().hide();//upto here
        //we apply this theme to show video on full screen
        this.getTheme().applyStyle(R.style.Fullscreen,false);//up to here
        // Declearing the array of module one module is one view
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.v_one,R.drawable.jester,"mr.one"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.v_two,R.drawable.jester,"mr.two"));
        arrayList.add(new Model("android.resource://" + getPackageName() + "/" + R.raw.v_three,R.drawable.jester,"mr.three"));
        adapter=new Adapter(MainActivity.this,arrayList);
        binding.vpg2.setAdapter(adapter);

    }
}