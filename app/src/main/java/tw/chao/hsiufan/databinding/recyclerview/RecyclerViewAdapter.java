package tw.chao.hsiufan.databinding.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tw.chao.hsiufan.databinding.recyclerview.databinding.ItemUserBinding;
import tw.chao.hsiufan.databinding.recyclerview.model.User;

public class RecyclerViewAdapter extends RecyclerView.Adapter implements BindableRecyclerViewAdapter<List<User>> {

    private List<User> data = new ArrayList<>();

    public RecyclerViewAdapter() {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemUserBinding binding = UserViewHolder.inflate(parent);
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((UserViewHolder) holder).updateUi(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public void setData(List<User> users) {
        data.clear();
        data.addAll(users);
        notifyDataSetChanged();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        private ItemUserBinding binding;

        public UserViewHolder(ItemUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        static ItemUserBinding inflate(ViewGroup parent) {
            return DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_user, parent, false);
        }

        void updateUi(User user) {
            //binding.setData(data);
            //binding.setViewholder(this);
            binding.setVariable(BR.data, user);
            binding.setVariable(BR.viewholder, this);
            binding.executePendingBindings();
        }

        public void onClick() {
            Toast.makeText(itemView.getContext(), "OnClick", Toast.LENGTH_SHORT).show();
        }
    }
}
