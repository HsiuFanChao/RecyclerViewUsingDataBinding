package tw.chao.hsiufan.databinding.recyclerview;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class BindingAdapters {

    @BindingAdapter("app:data")
    public static <Data> void setRecyclerViewDataSource(RecyclerView recyclerView, Data dataSource) {

        if (recyclerView == null || dataSource == null) {
            return;
        }

        RecyclerView.Adapter adapter = recyclerView.getAdapter();

        if (adapter instanceof BindableRecyclerViewAdapter) {
            BindableRecyclerViewAdapter bindableAdapter = (BindableRecyclerViewAdapter) recyclerView.getAdapter();
            bindableAdapter.setData(dataSource);
        }
    }
}
