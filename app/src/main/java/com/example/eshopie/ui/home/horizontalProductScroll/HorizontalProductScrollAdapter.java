package com.example.eshopie.ui.home.horizontalProductScroll;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.eshopie.R;
import com.example.eshopie.model.HorizontalProductScrollModal;
import com.example.eshopie.ui.product.ProductDetails;


import java.util.List;

public class HorizontalProductScrollAdapter extends RecyclerView.Adapter<HorizontalProductScrollAdapter.ViewHolder> {

    private List<HorizontalProductScrollModal> horizontalProductScrollModalsList;

    public HorizontalProductScrollAdapter(List<HorizontalProductScrollModal> horizontalProductScrollModalsList) {
        this.horizontalProductScrollModalsList = horizontalProductScrollModalsList;
    }

    @NonNull
    @Override
    public HorizontalProductScrollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalProductScrollAdapter.ViewHolder holder, int position) {

        String resource = horizontalProductScrollModalsList.get(position).getProductImage();
        String title = horizontalProductScrollModalsList.get(position).getProductTitle();
        String description = horizontalProductScrollModalsList.get(position).getProductDescription();
        String price = horizontalProductScrollModalsList.get(position).getProductPrice();
        String proId = horizontalProductScrollModalsList.get(position).getProductId();

        holder.setProductData(proId, resource, title, description, price);
    }

    @Override
    public int getItemCount() {

        if (horizontalProductScrollModalsList.size() > 8) {
            return 8;
        } else {
            return horizontalProductScrollModalsList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productTitle;
        private TextView productDescription;
        private TextView productPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.hs_product_image);
            productTitle = itemView.findViewById(R.id.hs_product_title);
            productDescription = itemView.findViewById(R.id.hs_product_description);
            productPrice = itemView.findViewById(R.id.hs__product_price);

            productImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }

        private void setProductData(String proId, String resource, String title, String description, String price) {
            //Glide
            Glide.with(itemView.getContext()).load(resource).apply(new RequestOptions().placeholder(R.drawable.default_img)).into(productImage);
            productTitle.setText(title);
            productDescription.setText(description);
            productPrice.setText("Rs." + price);

            if (!title.equals("")) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent productDetailIntent = new Intent(itemView.getContext(), ProductDetails.class);
                        productDetailIntent.putExtra("pro_id", proId);
                        itemView.getContext().startActivity(productDetailIntent);
                    }
                });
            }
        }
    }
}
