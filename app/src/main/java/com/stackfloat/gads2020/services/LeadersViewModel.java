package com.stackfloat.gads2020.services;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeadersViewModel extends AndroidViewModel {

  public MutableLiveData<List<LearnerLeader>> mListLearnerLeaders = new MutableLiveData<>();
    public MutableLiveData<List<IQLeader>> mListIQLeaders = new MutableLiveData<>();

    private  final String TAG = LeadersViewModel.class.getSimpleName();
    private  final LeadersService buildService = LeadersServiceBuilder.buildService(LeadersService.class);

    public LeadersViewModel(@NonNull Application application) {
        super(application);
    }


    public void loadLearnersLeaders() {
        Call<List<LearnerLeader>> learnerLeaders = buildService.getLearnerLeaders();
        learnerLeaders.enqueue(new Callback<List<LearnerLeader>>() {
            @Override
            public void onResponse(Call<List<LearnerLeader>> call,
                                   Response<List<LearnerLeader>> response) {
                List<LearnerLeader> body = response.body();
                if (body != null) {
                    mListLearnerLeaders.setValue(body);
                }
            }

            @Override
            public void onFailure(Call<List<LearnerLeader>> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t.fillInStackTrace());
            }
        });
    }
    public void loadIQLeaders() {
        Call<List<IQLeader>> iqLeaders = buildService.getIQLeaders();
        iqLeaders.enqueue(new Callback<List<IQLeader>>() {
            @Override
            public void onResponse(Call<List<IQLeader>> call, Response<List<IQLeader>> response) {
                List<IQLeader> body = response.body();
                if (body != null) {
                   mListIQLeaders.setValue(body);
                }
            }

            @Override
            public void onFailure(Call<List<IQLeader>> call, Throwable t) {

            }
        });
    }
}
