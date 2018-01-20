package iafaq.kaqpf.com.iafaq;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import java.util.ArrayList;

import iafaq.kaqpf.com.iafaq.user_data.src.kankan.profile.items.adapters.AbstractWheelAdapter;


public class AdapterForGameItems extends AbstractWheelAdapter {
    private static final String TAG = AdapterForGameItems.class.getSimpleName();

    private int maxCountValues;
    private LayoutInflater layoutInflater;
    private  ArrayList<Integer> list;
    private Context mContext;

    @Override
    public View getEmptyItem(View convertView, ViewGroup parent) {
        return super.getEmptyItem(convertView, parent);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        super.unregisterDataSetObserver(observer);
    }

    @Override
    protected void notifyDataChangedEvent() {
        super.notifyDataChangedEvent();
    }

    @Override
    protected void notifyDataInvalidatedEvent() {
        super.notifyDataInvalidatedEvent();
    }

    public static int onOptionsItemSelected(Integer item) {
        Log.d(TAG, "onOptionsItemSelected");
        if (item != null) return item.intValue();
        else return -1;
    }

    @SuppressLint("WrongConstant")
    public AdapterForGameItems(Context mContext, ArrayList<Integer> list) {

        onOptionsItemSelected(new Integer(12));

        this.mContext = mContext;
        this.list = list;
        this.layoutInflater = (LayoutInflater) mContext.getSystemService("layout_inflater");
        this.maxCountValues = list.size();
    }

    public int getItemsCount() {
        return this.maxCountValues;
    }

    public View getItem(int index, View convertView, ViewGroup parent) {
        View view = this.layoutInflater.inflate(R.layout.item_list, parent, false);
        ((ImageView) view.findViewById(R.id.image)).setImageDrawable(ContextCompat.getDrawable(this.mContext, ((Integer) this.list.get(index)).intValue()));
        return view;
    }
}
