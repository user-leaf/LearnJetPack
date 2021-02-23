package com.sesame.learnjetpack.chapter04_ViewModel;

import androidx.lifecycle.ViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TimerViewModel extends ViewModel {

    private OnTimeChange onTimeChange;
    private int currentSecond = 0;
    private int isFirst = 0;

    public void startTimer() {
        if (isFirst > 0) {
            return;
        }
        isFirst++;
        Observable.interval(1000, TimeUnit.MILLISECONDS)
                .observeOn(Schedulers.io())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        onTimeChange.timeChange(currentSecond++);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    protected void onCleared() {
        super.onCleared();

    }

    public void setOnTimeChange(OnTimeChange onTimeChange) {
        this.onTimeChange = onTimeChange;
    }

    public interface OnTimeChange {
        void timeChange(int second);
    }
}
