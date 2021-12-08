package com.example.toshiba.enlistcart;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Toshiba on 06-Dec-21.
 */

/*public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImage = new ArrayList<>();
    private Context mcontext;

    public RecyclerViewAdapter (Context context, ArrayList<String> m_image, ArrayList<String> m_name) {
        mNames = m_name;
        mImage = m_image;
        mcontext = context;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_recycler, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
      holder.category_name.setText(mNames.get(position));
        //holder.category_image
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView category_image;
        TextView category_name;

        public viewHolder(View itemView) {
            super(itemView);
            category_image = itemView.findViewById(R.id.image);
            category_name = itemView.findViewById(R.id.txt_categoty);
        }
    }
}*/
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private Context mcontext;

    public RecyclerViewAdapter(Context context, ArrayList<String> mimageUrls, ArrayList<String> names) {
        mNames = names;
        mImageUrls = mimageUrls;
        mcontext = context;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewholder: called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_recycler, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, final int position) {
        Log.d(TAG, "onBindViewholder: called.");
       /* Glide.with(mcontext)
                .asBitmap()
                .load(mImageUrls.get(position))
                .into(holder.image);*/
        holder.name.setText(mNames.get(position));
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on an image :"+mNames.get(position));
                Toast.makeText(mcontext, mNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;

        public viewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.txt_categoty);
        }
    }
}
