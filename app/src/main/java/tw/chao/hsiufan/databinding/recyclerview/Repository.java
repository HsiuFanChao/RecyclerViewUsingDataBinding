package tw.chao.hsiufan.databinding.recyclerview;

import android.os.Handler;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tw.chao.hsiufan.databinding.recyclerview.model.User;

public class Repository {

    private MutableLiveData<List<User>> usersFetchedFromNetwork;
    private Handler handler;

    public Repository() {
        handler = new Handler();
        usersFetchedFromNetwork = new MutableLiveData<>();
    }

    public void fakeServerRequest() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                usersFetchedFromNetwork.setValue(getData(100));
            }
        }, 2000);
    }

    public LiveData<List<User>> getUsers() {
        return usersFetchedFromNetwork;
    }

    private List<User> getData(int count) {
        List<User> data = new ArrayList<>();

        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i=0; i<count; i++) {
            numbers.add(i);
        }

        while (!numbers.isEmpty()) {

            int index = random.nextInt(numbers.size());
            String number = Integer.toString(numbers.remove(index));

            User user = new User();
            user.title = "Title" + number;

            data.add(user);
        }
        return data;
    }
}
