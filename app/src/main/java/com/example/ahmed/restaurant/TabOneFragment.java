package com.example.ahmed.restaurant;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabOneFragment extends Fragment implements AdapterView.OnItemClickListener{


    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tab_one, container, false);
        listView=(ListView)view.findViewById(R.id.list);
        ArrayList<Restaurant> restList=new ArrayList<Restaurant>();
        listView.setAdapter(new RestaurantAdapter(restList));
        listView.setOnItemClickListener(this);
        return view;
        
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent(getActivity(), .class);
//        intent.putExtra( , position);
//        startActivity(intent);
    }

    class RestaurantAdapter extends ArrayAdapter<Restaurant> {
        public RestaurantAdapter(ArrayList<Restaurant> Restaurants) {
            super(getActivity(), 0, Restaurants);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.layout_restaurant_list_item, null);
            }
            Restaurant restaurant = getItem(position);

             return convertView;
        }
    }


}
