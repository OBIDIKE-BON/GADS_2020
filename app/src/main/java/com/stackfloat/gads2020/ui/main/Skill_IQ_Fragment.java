package com.stackfloat.gads2020.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import com.stackfloat.gads2020.services.IQLeader;
import com.stackfloat.gads2020.services.LeadersViewModel;

import java.util.List;

public class Skill_IQ_Fragment extends Fragment {

    private static final String TAG = Skill_IQ_Fragment.class.getSimpleName();
    private IQRecyclerAdapter mIQRecyclerAdapter;
    private RecyclerView mRecyclerView;
    private LeadersViewModel mLeadersViewModel;
    private TextView err;
    private ProgressBar mProgressBar;

    public static Skill_IQ_Fragment newInstance() {
        return new Skill_IQ_Fragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLeadersViewModel = new ViewModelProvider(this).get(LeadersViewModel.class);
        Observer<List<IQLeader>> observer = iqLeaders -> {
            Log.d(TAG, "onChanged: ");
            if (iqLeaders.size() != 0) {
                mIQRecyclerAdapter.setLeaders(iqLeaders);
                mRecyclerView.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.INVISIBLE);
                err.setVisibility(View.INVISIBLE);
            } else {
                mProgressBar.setVisibility(View.INVISIBLE);
                err.setText(R.string.timeout);
                err.setVisibility(View.VISIBLE);
            }
        };
        mLeadersViewModel.mListIQLeaders.observe(this, observer);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.skill_iq_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Context context = view.getContext();
        mIQRecyclerAdapter = new IQRecyclerAdapter(context);
        mRecyclerView = view.findViewById(R.id.rv_iq_leaders);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(mIQRecyclerAdapter);
        mLeadersViewModel.loadIQLeaders();
        mProgressBar = view.findViewById(R.id.progressBar);
        err = view.findViewById(R.id.txt_error);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mQuizzesViewModel =new ViewModelProvider(this).get(QuizzesViewModel.class);
        // TODO: Use the ViewModel
    }

}
