package es.esy.vivekrajendran.myapp.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


public class MyRecycler extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("TAG", "onCreateViewHolder: ");
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, int position) {
        Log.i("TAG", "onBindViewHolder: ");
    }

    @Override
    public int getItemCount() {
        Log.i("TAG", "getItemCount: ");
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
            Log.i("TAG", "MyViewHolder: ");
        }
    }
}
