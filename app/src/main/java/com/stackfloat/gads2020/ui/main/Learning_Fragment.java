package com.stackfloat.gads2020.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.stackfloat.gads2020.R;
import com.stackfloat.gads2020.services.LeadersViewModel;
import com.stackfloat.gads2020.services.LearnerLeader;

import java.util.List;


public class Learning_Fragment extends Fragment {

    private LearnersRecyclerAdapter mLearnersRecyclerAdapter;
    private RecyclerView mRecyclerView;
    private LeadersViewModel mLeadersViewModel;
    private TextView err;
    private ProgressBar mProgressBar;

    public static Learning_Fragment newInstance() {
        return new Learning_Fragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLeadersViewModel = new ViewModelProvider(this).get(LeadersViewModel.class);
        Observer<List<LearnerLeader>> observer = learnerLeaders -> {
            if (learnerLeaders.size() != 0) {
                mLearnersRecyclerAdapter.setLeaders(learnerLeaders);
                mRecyclerView.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.INVISIBLE);
                err.setVisibility(View.INVISIBLE);
            } else {
                mProgressBar.setVisibility(View.INVISIBLE);
                err.setText(R.string.timeout);
                err.setVisibility(View.VISIBLE);
            }
        };
        mLeadersViewModel.mListLearnerLeaders.observe(this , observer);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.learning_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLearnersRecyclerAdapter = new LearnersRecyclerAdapter(view.getContext());
        mRecyclerView = view.findViewById(R.id.rv_learners);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mLearnersRecyclerAdapter);
        mLeadersViewModel.loadLearnersLeaders();
        mProgressBar = view.findViewById(R.id.progressBar);
        err = view.findViewById(R.id.txt_error);
    }
}
