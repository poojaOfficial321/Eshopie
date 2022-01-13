package com.example.eshopie.ui.cart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eshopie.R;
import com.example.eshopie.model.CartItemModel;
import com.example.eshopie.ui.cart.adapter.CartAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyCartFragment extends Fragment {

    public MyCartFragment() {
        // Required empty public constructor
    }

    private RecyclerView cartItemsRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);

        cartItemsRecyclerView = view.findViewById(R.id.cart_items_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemsRecyclerView.setLayoutManager(linearLayoutManager);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.phone,"iphone",2,"Rs.6999/-","RS.8999/-",1,0,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.phone,"iphone",0,"Rs.6999/-","RS.8999/-",1,1,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.phone,"iphone",2,"Rs.6999/-","RS.8999/-",1,2,0));
        cartItemModelList.add(new CartItemModel(1,"price(3 items","Rs/6999/-","Free","Rs.70000/-","Rs.999/-"));

        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        cartItemsRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();
        return view;
    }
}