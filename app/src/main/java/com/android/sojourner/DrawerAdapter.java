package com.android.sojourner;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jlian on 7/19/2016.
 */
public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.DrawerViewHolder>{
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_MENU = 1;

    ArrayList<DrawerItem> mItemList;

    private OnItemSelectListener mListener;

    public DrawerAdapter(ArrayList<DrawerItem> itemList) {
        mItemList = itemList;
    }

    @Override
    public DrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_HEADER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_header_drawer, parent, false);
        }
        else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_drawer, parent, false);
        }
        DrawerViewHolder holder = new DrawerViewHolder(view, viewType);
        return holder;
    }

    @Override
    public void onBindViewHolder(DrawerViewHolder holder, int position) {
        if(position == 0) {
            holder.mHeaderText.setText("Sojourner Menu");
        }
        else {
            DrawerItem drawerItem = mItemList.get(position - 1);
            holder.mItemName.setText(drawerItem.getmTitle());
            holder.mIconImage.setImageResource(drawerItem.getmIcon());
        }
    }

    @Override
    public int getItemCount() {
        return mItemList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }
        return TYPE_MENU;
    }

    protected class DrawerViewHolder extends RecyclerView.ViewHolder {
        TextView mItemName;
        TextView mHeaderText;
        ImageView mIconImage;

        public DrawerViewHolder(View itemView, int viewType) {
            super(itemView);

            if (viewType == 0) {
                mHeaderText = (TextView) itemView.findViewById(R.id.headerText);
            }
            else {
                mItemName = (TextView) itemView.findViewById(R.id.title);
                mIconImage = (ImageView) itemView.findViewById(R.id.icon);
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemSelected(v, getAdapterPosition());
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemSelectListener mListener) {
        this.mListener = mListener;
    }

    public interface OnItemSelectListener {
        public void onItemSelected(View v, int position);
    }
}
