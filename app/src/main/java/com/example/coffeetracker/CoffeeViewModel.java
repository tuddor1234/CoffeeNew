package com.example.coffeetracker;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CoffeeViewModel extends AndroidViewModel {

    private String TAG = this.getClass().getSimpleName();
    private CoffeeDao coffeeDao;
    private CoffeeDatabase coffeeDatabase;
    private LiveData<List<Coffee>> allCoffees;

    // not sure if needed NonNUll
    // public CoffeeViewModel(@NonNull Application application) {
    public CoffeeViewModel(Application application) {
        super(application);
        coffeeDatabase = CoffeeDatabase.getDatabase(application);
        coffeeDao = coffeeDatabase.coffeeDao();
        allCoffees = coffeeDao.getCoffeeList();
    }


    public void insert(Coffee coffee) {
        new InsertAsyncTask(coffeeDao).execute(coffee);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel Destroyed");
    }

    // not sure here
    public LiveData<List<Coffee>> getAllCoffees() {
        return allCoffees;
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
