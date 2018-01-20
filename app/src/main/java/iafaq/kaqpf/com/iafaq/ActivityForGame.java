package iafaq.kaqpf.com.iafaq;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;



import java.util.ArrayList;
import java.util.Random;

import iafaq.kaqpf.com.iafaq.model.CarType;
import iafaq.kaqpf.com.iafaq.model.MeetData;
import iafaq.kaqpf.com.iafaq.model.SmokingType;
import iafaq.kaqpf.com.iafaq.user_data.src.kankan.profile.items.OnWheelScrollListener;
import iafaq.kaqpf.com.iafaq.user_data.src.kankan.profile.items.WheelView;


public class ActivityForGame extends AppCompatActivity implements OnWheelScrollListener {

    private static final String TAG = ActivityForGame.class.getSimpleName();

    private ItemsPlay itemsPlay = new ItemsPlay();
    private ArrayList<Integer> listForItemsPlay;

    private CarType carType;
    private MeetData meetData;
    private SmokingType smokingType;


    protected void setDisplayHomeAsUpEnabled(boolean enabled) {
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(enabled);
        }
    }

    protected void setHomeAsUpIndicator(int resId) {
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(resId);
        }
    }

    protected void hideActionBar() {
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        itemsPlay.view1 = findViewById(R.id.wheel1);
        itemsPlay.view2 = findViewById(R.id.wheel2);
        itemsPlay.view3 = findViewById(R.id.wheel3);
        itemsPlay.view4 = findViewById(R.id.wheel4);
        itemsPlay.view5 = findViewById(R.id.wheel5);

        playData();
        Button playBtn = findViewById(R.id.btn_play);
        playBtn.setOnClickListener(arg -> createMediaDataItems());

        carType = new CarType() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };


        meetData = new MeetData();
        meetData.city = "play";

        smokingType = new SmokingType() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };

    }

    private void playData() {

        if (meetData != null && meetData.numFlat > 100000) {
            hideActionBar();
            setDisplayHomeAsUpEnabled(true);
            setHomeAsUpIndicator(1);
        }

        initPlayerData(itemsPlay.view1, getListForItemsPlay());
        initPlayerData(itemsPlay.view2, getListForItemsPlay());
        initPlayerData(itemsPlay.view3, getListForItemsPlay());
        initPlayerData(itemsPlay.view4, getListForItemsPlay());
        initPlayerData(itemsPlay.view5, getListForItemsPlay());
    }

    private ArrayList<Integer> getListForItemsPlay(){

        if (meetData != null && meetData.city != null && meetData.city.equals("new_play")) {
            return new ArrayList<>();
        }

        if (listForItemsPlay == null) {
            final ArrayList<Integer> list = new ArrayList<>();
            list.add(R.drawable.item_1);
            list.add(R.drawable.item_2);
            list.add(R.drawable.item_3);
            list.add(R.drawable.item_4);
            list.add(R.drawable.item_5);
            list.add(R.drawable.item_6);
            list.add(R.drawable.item_7);
            list.add(R.drawable.item_8);
            list.add(R.drawable.item_9);
            this.listForItemsPlay = list;
        }

        return listForItemsPlay;
    }

    private void initPlayerData(WheelView wheelView, ArrayList<Integer> list) {
        wheelView.setViewAdapter(new AdapterForGameItems(this, list));
        wheelView.setCurrentItem((int) (Math.random() * 10.0d));
        wheelView.setVisibleItems(4);
        wheelView.setCyclic(true);
        wheelView.setEnabled(false);
    }

    @Override
    public void onStart(){
        Log.d(TAG, "onStart");

        super.onStart();
    }

    @Override
    public void onStop(){
        Log.d(TAG, "onStop");

        super.onStop();
    }

    @Override
    public void onDestroy(){
        Log.d(TAG, "onDestroy");

        super.onDestroy();
    }


    private void createMediaDataItems() {
        Random random = new Random();
        itemsPlay.view1.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
        itemsPlay.view2.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
        itemsPlay.view3.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
        itemsPlay.view4.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
        itemsPlay.view5.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
    }

    private class ItemsPlay {

        WheelView view1;
        WheelView view2;
        WheelView view3;
        WheelView view4;
        WheelView view5;
    }


    @Override
    public void onScrollingStarted(WheelView wheel) {

    }

    @Override
    public void onScrollingFinished(WheelView wheel) {
        Log.d("onScrollingFinished: ", String.valueOf(wheel.getCurrentItem()));
    }

//    @Override
//    public void onBackPressed() {
//        System.exit(0);
//    }
}
