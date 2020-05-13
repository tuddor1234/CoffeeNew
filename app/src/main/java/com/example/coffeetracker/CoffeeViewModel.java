package com.example.coffeetracker;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.coffeetracker.components.utils.CoffeeViewModelUTILS;

import java.util.List;

public class CoffeeViewModel extends AndroidViewModel {

    private CoffeeViewModelUTILS utils = new CoffeeViewModelUTILS();
    private String TAG = this.getClass().getSimpleName();
    private CoffeeDao coffeeDao;
    private CoffeeDatabase coffeeDatabase;
    private LiveData<List<Coffee>> allCoffees;
    private LiveData<Integer> coffeeNrToday;
    private LiveData<Integer> caffeineToday;
    private LiveData<Integer> coffeeNrThisWeek;
    private LiveData<Integer> caffeineThisWeek;



    public CoffeeViewModel(Application application) {
        super(application);
        coffeeDatabase = CoffeeDatabase.getDatabase(application);
        coffeeDao = coffeeDatabase.coffeeDao();
        allCoffees = coffeeDao.getCoffeeList();
        coffeeNrToday = coffeeDao.getCoffeeNr(utils.getTodayBegin(), utils.getTodayEnd());
        caffeineToday = coffeeDao.getCaffeine(utils.getTodayBegin(), utils.getTodayEnd());
        coffeeNrThisWeek = coffeeDao.getCoffeeNr(utils.getWeekBegin(), utils.getWeekEnd());
        caffeineThisWeek = coffeeDao.getCaffeine(utils.getWeekBegin(), utils.getWeekEnd());
    }


    public void insert(Coffee coffee) {
        new InsertAsyncTask(coffeeDao).execute(coffee);
    }

    public LiveData<Integer> getCoffeeNrToday() {
        return coffeeNrToday;
    }

    public LiveData<Integer> getCaffeine() {
        return caffeineToday;
    }

    public LiveData<Integer> getCaffeineThisWeek() {
        return caffeineThisWeek;
    }

    public LiveData<Integer> getCoffeeNrThisWeek() {
        return coffeeNrThisWeek;
    }

    // not sure here
    public LiveData<List<Coffee>> getAllCoffees() {
        return allCoffees;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel Destroyed");
    }

    // This class is used to serve for implementation of all of the CRUD operations
    private class OperationsAsyncTask extends AsyncTask<Coffee, Void, Void> {

        CoffeeDao mAsyncTaskDao;

        OperationsAsyncTask(CoffeeDao dao) {
            this.mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Coffee... coffees) {
            return null;
        }
    }

    private class InsertAsyncTask extends OperationsAsyncTask {

        InsertAsyncTask(CoffeeDao mCoffeeDao) {
            super(mCoffeeDao);
        }

        @Override
        protected Void doInBackground(Coffee... coffees) {

            mAsyncTaskDao.insert(coffees[0]);

            return null;
        }
    }
}
