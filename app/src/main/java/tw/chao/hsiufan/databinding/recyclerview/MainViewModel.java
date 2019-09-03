package tw.chao.hsiufan.databinding.recyclerview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import tw.chao.hsiufan.databinding.recyclerview.model.User;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<User>> users;
    private Repository repository;
    private Observer<List<User>> observer;

    public MainViewModel() {

        users = new MutableLiveData<>();
        users.setValue(new ArrayList<User>());

        observer = new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> userList) {
                users.setValue(userList);
            }
        };
    }

    public void setRepository(Repository repo) {
        repository = repo;
        repository.getUsers().observeForever(observer);
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public void requestServerData() {
        if (repository != null) {
            repository.fakeServerRequest();
        }
    }

    @Override
    protected void onCleared() {
        repository.getUsers().removeObserver(observer);
    }
}
