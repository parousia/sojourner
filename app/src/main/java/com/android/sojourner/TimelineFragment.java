package com.android.sojourner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
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

    private List<Scene> mScenes;

    public static TimelineFragment newInstance() {

        Bundle args = new Bundle();

        TimelineFragment fragment = new TimelineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize Scene list
        mScenes = SceneLab.get(getActivity()).getScenes();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_timeline, container, false);

        /* Set up RecyclerView */
        mRecyclerView = (RecyclerView) v.findViewById(R.id.fragment_timeline_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new TimelineAdapter(mScenes);
        mRecyclerView.setAdapter(mAdapter);

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
            holder.bindViewHolder(scene, position);
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
        private View mUpDottedLine;
        private View mDownDottedLine;

        public TimelineHolder(View itemView) {
            super(itemView);

            mTitleTextView = (TextView) itemView.findViewById(R.id.timeline_item_title_textView);
            mSubtitleTextView = (TextView) itemView.findViewById(R.id.timeline_item_subtitle_textView);
            mCircleImageView = (CircleImageView) itemView.findViewById(R.id.timeline_item_iconView);
            mUpDottedLine = (View) itemView.findViewById(R.id.timeline_item_dot_1);
            mDownDottedLine = (View) itemView.findViewById(R.id.timeline_item_dot_2);
        }

        public void bindViewHolder(Scene scene, int position) {
            mTitleTextView.setText(scene.getSceneName());
            mSubtitleTextView.setText("Subtitle text");

            // Set timeline icon view
            int timelineResId, borderColorId;
            int upLineColorId, downLineColorId;
            if (scene.isUnlocked()) {
                timelineResId = R.drawable.ic_timeline_unlocked;
                borderColorId = R.color.colorPrimaryLight;
                upLineColorId = R.color.colorPrimary;
                downLineColorId = R.color.colorPrimary;
            } else {
                timelineResId = R.drawable.ic_timeline_locked;
                borderColorId = R.color.red;
                upLineColorId = android.R.color.transparent;
                downLineColorId = android.R.color.transparent;
            }
            mCircleImageView.setImageResource(timelineResId);
            mCircleImageView.setBorderColor(ContextCompat.getColor(getActivity(), borderColorId));

            // Set connecting links color
            if (position == 0) {
                upLineColorId = android.R.color.transparent;
            } else if (position == 3) {
                downLineColorId = android.R.color.transparent;
            }
            // Set the Views
            mUpDottedLine.setBackgroundColor(
                    ContextCompat.getColor(getActivity(), upLineColorId));
            mDownDottedLine.setBackgroundColor(
                    ContextCompat.getColor(getActivity(), downLineColorId));
        }

        public void showUpDottedLine(boolean isVisible) {
            if (isVisible) {
                // Show the dotted line
                mUpDottedLine.setBackgroundColor(
                        ContextCompat.getColor(getActivity(), R.color.colorPrimary));
            } else {
                // Clear the imageview
                mUpDottedLine.setBackgroundColor(
                        ContextCompat.getColor(getActivity(), android.R.color.transparent));
            }
        }

        public void showDownDottedLine(boolean isVisible) {
            if (isVisible) {
                // Show the dotted line
                mDownDottedLine.setBackgroundColor(
                        ContextCompat.getColor(getActivity(), R.color.colorPrimary));
            } else {
                // Clear the imageview
                mDownDottedLine.setBackgroundColor(
                        ContextCompat.getColor(getActivity(), android.R.color.transparent));
            }
        }
    }

}
