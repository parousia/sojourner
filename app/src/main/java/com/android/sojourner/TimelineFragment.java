package com.android.sojourner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Joseph on 7/15/16.
 */

public class TimelineFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    public static TimelineFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TimelineFragment fragment = new TimelineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_timeline, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.fragment_timeline_recyclerView);
        return v;
    }

    /**
     * RecyclerView Classes
     **/
    private class TimelineAdapter extends RecyclerView.Adapter<TimelineHolder> {
        private List<Scene> mScenes;

        public TimelineAdapter(List<Scene> scenes) {
            super();
            mScenes = scenes;
        }

        @Override
        public TimelineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View v = inflater.inflate(R.layout.list_item_timeline, parent, false);
            return new TimelineHolder(v);
        }

        @Override
        public void onBindViewHolder(TimelineHolder holder, int position) {
            Scene scene = mScenes.get(position);
            holder.bindViewHolder(scene);
        }

        @Override
        public int getItemCount() {
            return mScenes.size();
        }
    }

    private class TimelineHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;
        private TextView mSubtitleTextView;
        private CircleImageView mCircleImageView;
        private ImageView mUpDottedLine;
        private ImageView mDownDottedLine;

        public TimelineHolder(View itemView) {
            super(itemView);

            mTitleTextView = (TextView) itemView.findViewById(R.id.timeline_item_title_textView);
            mSubtitleTextView = (TextView) itemView.findViewById(R.id.timeline_item_subtitle_textView);
            mCircleImageView = (CircleImageView) itemView.findViewById(R.id.timeline_item_iconView);
            mUpDottedLine = (ImageView) itemView.findViewById(R.id.timeline_item_dot_1);
            mDownDottedLine = (ImageView) itemView.findViewById(R.id.timeline_item_dot_2);
        }

        public void bindViewHolder(Scene scene) {

        }

        public void showUpDottedLine(boolean isVisible) {
            if (isVisible) {
                // Show the dotted line
            } else {
                // Clear the imageview
                mUpDottedLine.setImageResource(android.R.color.transparent);
            }
        }

        public void showDownDottedLine(boolean isVisible) {
            if (isVisible) {
                // Show the dotted line
            } else {
                // Clear the imageview
                mDownDottedLine.setImageResource(android.R.color.transparent);
            }
        }
    }

}
