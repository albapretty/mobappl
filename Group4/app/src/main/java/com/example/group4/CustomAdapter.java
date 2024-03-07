package com.example.group4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<String> implements Filterable {

    private List<String> originalList;
    private List<String> filteredList;
    private Context context;

    public CustomAdapter(Context context, int resource, List<String> originalList) {
        super(context, resource, originalList);
        this.originalList = originalList;
        this.filteredList = new ArrayList<>();
        this.filteredList.addAll(originalList);
        this.context = context;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String searchText = charSequence.toString().toLowerCase();
                filteredList.clear();

                if (searchText.isEmpty()) {
                    filteredList.addAll(originalList);
                } else {
                    for (String item : originalList) {
                        if (item.toLowerCase().contains(searchText)) {
                            filteredList.add(item);
                        }
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                clear();
                addAll((List<String>) filterResults.values);
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getCount() {
        return filteredList.size(); // Return the size of the filtered list
    }

    @Override
    public String getItem(int position) {
        return filteredList.get(position); // Return the item from the filtered list
    }

    @Override
    public long getItemId(int position) {
        return position; // Return the position as the item ID

    }
}
