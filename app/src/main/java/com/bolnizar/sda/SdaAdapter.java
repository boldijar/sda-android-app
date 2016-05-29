package com.bolnizar.sda;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 5/28/2016.
 */
public class SdaAdapter extends RecyclerView.Adapter<SdaAdapter.SdaHolder> {

    private Dictionary mDictionary;
    private List<Node> mNodes;

    /* called when the node list must be updated */
    public void updateNodes() {
        mNodes.clear();
        mDictionary.createIterator();
        Iterator iterator = mDictionary.getIterator();
        iterator.initialize();
        while (iterator.valid()) {
            mNodes.add(iterator.current());
            iterator.next();
        }
        notifyDataSetChanged();
    }

    public SdaAdapter() {
        mDictionary = new Dictionary();
        mDictionary.create(Dictionary.Order.ASCENDING);
        mNodes = new ArrayList<>();

        mDictionary.add("Cetatuie", "http://www.clipedecluj.ro/wp-content/uploads/2011/05/cetatuia-panorama1.jpg");
        mDictionary.add("Pac Babes", "http://fiisportiv.ro/wp-content/uploads/2014/06/parcul-babes-iuliu-hateganu-698x340.jpg");
        mDictionary.add("Kids park", "http://www.ovidiublag.ro/wp-content/uploads/2010/11/parc1.jpg");
        mDictionary.add("Feleac", "http://www.skytrip.ro/images/obiective/judet/Cluj/bigs/Partia-Schi-Arena-Feleac-20110225130418.jpg");
        mDictionary.add("Buscat Ski Resort", "http://www.presalocala.com/wp-content/uploads/2012/01/buscat_resort.jpg");
        mDictionary.add("Piata Unirii Cluj", "http://actualdecluj.ro/wp-content/uploads/2015/06/piata-unirii-2.jpg");
        mDictionary.add("Observator astronomic", "http://1.bp.blogspot.com/-WtayLhmgYOM/UM8vRVGA8uI/AAAAAAAACpo/gzaLUgVa5Qk/s1600/observator+astronomic+cluj.jpg");
        mDictionary.add("Gradina Botanica", "http://invacante.ro/wp-content/uploads/2013/01/gradina-botanica-cluj.jpg");
        updateNodes();
    }

    @Override
    public SdaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SdaHolder(parent);
    }

    @Override
    public void onBindViewHolder(SdaHolder holder, int position) {
        Glide.with(holder.image.getContext()).load(mNodes.get(position).value).into(holder.image);
        holder.text.setText(mNodes.get(position).key);
    }

    @Override
    public int getItemCount() {
        return mNodes.size();
    }

    public void add(String name, String url) {
        mDictionary.add(name, url);
        updateNodes();
    }

    public class SdaHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView text;

        public SdaHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));
            image = (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
