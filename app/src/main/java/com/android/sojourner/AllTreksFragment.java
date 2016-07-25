package com.android.sojourner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Joseph on 7/22/16.
 */

public class AllTreksFragment extends Fragment {

    RecyclerView mRecyclerView;
    TrekAdapter mAdapter;
    List<Trek> mTrekList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get TrekList
        mTrekList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            mTrekList.add(new Trek());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_all_treks, container, false);

        // Initialize RecyclerView
        mRecyclerView = (RecyclerView) v.findViewById(R.id.fragment_all_treks_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new TrekAdapter(mTrekList);
        mRecyclerView.setAdapter(mAdapter);

        return v;
    }

    /******
     * RecyclerView Classes
     ******/
    private class TrekAdapter extends RecyclerView.Adapter<TrekHolder> {
        private List<Trek> mTreks;

        public TrekAdapter(List<Trek> treks) {
            super();
            mTreks = treks;
        }

        @Override
        public TrekHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(getActivity())
                    .inflate(R.layout.list_item_trek, parent, false);
            return new TrekHolder(itemView);
        }

        @Override
        public void onBindViewHolder(TrekHolder holder, int position) {
            holder.bindViewHolder(mTreks.get(position));
        }

        @Override
        public int getItemCount() {
            return mTreks.size();
        }
    }

    private class TrekHolder extends RecyclerView.ViewHolder {
        public TrekHolder(View itemView) {
            super(itemView);
        }

        public void bindViewHolder(Trek trek) {

        }
    }

}
