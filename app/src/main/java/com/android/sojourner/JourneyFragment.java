package com.android.sojourner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Joseph on 7/15/16.
 */

public class JourneyFragment extends Fragment {

    public static JourneyFragment newInstance() {
        Bundle args = new Bundle();
        JourneyFragment fragment = new JourneyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private CardView mChallengeCard;
    private TextView mChallengeTitleView;
    private TextView mChallengeContentView;
    private CardView mStoryCard;

    private Scene mCurrentScene;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the current scene
        mCurrentScene = SharedPrefs.getCurrentScene(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_journey, container, false);

        // Set up ChallengeCard
        mChallengeCard = (CardView) v.findViewById(R.id.journey_challenge_cardview);
        mChallengeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mChallengeTitleView = (TextView) v.findViewById(R.id.journey_challenge_title_textView);

        mChallengeContentView = (TextView) v.findViewById(R.id.journey_challenge_textView);
        mChallengeContentView.setText(mCurrentScene.getChallenge());

        // Set up story card
        mStoryCard = (CardView) v.findViewById(R.id.journey_story_cardview);
        mStoryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return v;
    }
}
