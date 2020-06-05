package com.Fujairah.convertgeneration.activities;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.Fujairah.convertgeneration.AttendanceModel.Root;
import com.Fujairah.convertgeneration.repositiories.RetrofitRepository;
import com.wang.avi.AVLoadingIndicatorView;

public class AttendanceViewModel extends ViewModel {
    private MutableLiveData<Root> arrayListMutableLiveData;

    public void initAttendanceByRange(AVLoadingIndicatorView progressBar, String from, String to, String UserId){
        progressBar.setVisibility(View.VISIBLE);
        arrayListMutableLiveData = RetrofitRepository.getAttendanceByRange(progressBar,from,to,UserId);
    }
    public LiveData<Root> getLiveAttendanceByRange(){return arrayListMutableLiveData;}
}
