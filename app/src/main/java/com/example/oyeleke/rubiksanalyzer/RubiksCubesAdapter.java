package com.example.oyeleke.rubiksanalyzer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oyeleke on 2/23/18.
 */

public class RubiksCubesAdapter extends RecyclerView.Adapter<RubiksCubesAdapter.MyViewHolder> {

    private List<Integer>cubeList = new ArrayList<>();

    public RubiksCubesAdapter(List<Integer> cubeList) {
        this.cubeList = cubeList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.smaller_rubiks_cube,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(cubeList.get(position));
    }

    @Override
    public int getItemCount() {
        return cubeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mSmallerRubiksCubesTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mSmallerRubiksCubesTextView = itemView.findViewById(R.id.tv_smaller_rubiks_cube);
        }

        public void bind(int n){
            String cubesValue = String.valueOf(n);
            mSmallerRubiksCubesTextView.setText(cubesValue+"x"+cubesValue+"x"+cubesValue);
        }
    }
}
