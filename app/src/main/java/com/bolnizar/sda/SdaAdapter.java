package com.bolnizar.sda;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by Paul on 5/28/2016.
 */
public class SdaAdapter extends RecyclerView.Adapter<SdaAdapter.SdaHolder>{

    @Override
    public SdaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(SdaHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SdaHolder extends RecyclerView.ViewHolder {

        public SdaHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));
        }
    }
}
