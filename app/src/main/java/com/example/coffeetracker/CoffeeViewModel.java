package com.example.coffeetracker;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CoffeeViewModel extends AndroidViewModel {

    private CoffeeDao coffeeDao;
    private CoffeeDatabase coffeeDatabase;

    private LiveData<List<Coffee>> allCoffees;




    public CoffeeViewModel(@NonNull Application application) {
        super(application);

        coffeeDatabase = CoffeeDatabase.getInstance(application);
        coffeeDao = coffeeDatabase.coffeeDao();

        allCoffees = coffeeDao.getCoffeeList();
    }


    public void insert(Coffee coffee)
    {

        new InsertAsyncTask(coffeeDao).execute(coffee);
    }

    public LiveData<List<Coffee>> getAllCoffees()
    {
        return allCoffees;
    }

    private class InsertAsyncTask extends AsyncTask<Coffee,Void,Void> {

        CoffeeDao mCoffeeDao;

        public InsertAsyncTask(CoffeeDao mCoffeeDao)
        {
            this.mCoffeeDao = mCoffeeDao;
        }


        @Override
        protected Void doInBackground(Coffee... coffees) {

            if(coffees[0] != null) {
                mCoffeeDao.insert(coffees[0]);
            }
            return null;
        }
    }
}
