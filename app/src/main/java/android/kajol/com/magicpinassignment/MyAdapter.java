package android.kajol.com.magicpinassignment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.RequestManager;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;

import static android.kajol.com.magicpinassignment.R.attr.title;
import static android.kajol.com.magicpinassignment.R.id.parent;

/**
 * Created by kajol sharma on 27-02-2019.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    MainActivity activity;
    Context context;

    MyAdapter(MainActivity activity, Context context){

        this.activity = activity;
        this.context = context;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_player_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyAdapter.MyViewHolder holder, int position) {
        activity.initializePlayer(holder.playerView);
        Log.d("qwerty", "onBindViewHolder: \n"+position);
        holder.ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.ib.setVisibility(View.GONE);
                Toast.makeText(context , "here" ,Toast.LENGTH_SHORT).show();
                activity.releasePlayer();
                activity.initializePlayer(holder.playerView);
                //adaed
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        SimpleExoPlayerView playerView;
        FrameLayout fl;
        ImageButton ib;

        public MyViewHolder(View itemView) {
            super(itemView);
            playerView = (SimpleExoPlayerView)itemView.findViewById(R.id.video_view);
            fl = (FrameLayout)itemView.findViewById(R.id.fl);
            ib  = (ImageButton)itemView.findViewById(R.id.ib);
        }
    }

}