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

    // Interface for item clicks
    public interface OnItemSelectListener {
        void onItemSelected(View v, int position);
    }

    public void setOnItemClickListener(OnItemSelectListener listener) {
        mListener = listener;
    }

    // Constructor
    public DrawerAdapter() {
        mItemList = makeDrawerList();
    }

    @Override
    public DrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_HEADER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_header_drawer, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_drawer, parent, false);
        }

        DrawerViewHolder holder = new DrawerViewHolder(view, viewType);
        return holder;
    }

    @Override
    public void onBindViewHolder(DrawerViewHolder holder, int position) {
        holder.bindViewHolder(position);
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }
        return TYPE_MENU;
    }

    // Initialize the drawer list
    private ArrayList<DrawerItem> makeDrawerList() {
        //dummy data
        ArrayList<DrawerItem> itemList = new ArrayList<>();
        DrawerItem item = new DrawerItem();
        item.setmIcon(R.drawable.ic_drawer_all_treks);
        item.setmTitle("All Treks");
        itemList.add(item);

        DrawerItem item1 = new DrawerItem();
        item1.setmIcon(R.drawable.ic_drawer_share);
        item1.setmTitle("Share");
        itemList.add(item1);

        DrawerItem item2 = new DrawerItem();
        item2.setmIcon(R.drawable.ic_drawer_settings);
        item2.setmTitle("Settings");
        itemList.add(item2);

        DrawerItem item3 = new DrawerItem();
        item3.setmIcon(R.drawable.ic_drawer_about);
        item3.setmTitle("About");
        itemList.add(item3);

        return itemList;
    }

    /** Private ViewHolder Class **/
    protected class DrawerViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        TextView mItemName;
        TextView mHeaderText;
        ImageView mIconImage;

        public DrawerViewHolder(View itemView, int viewType) {
            super(itemView);

            // Find the inflated views
            if (viewType == 0) {
                mHeaderText = (TextView) itemView.findViewById(R.id.headerText);
            }
            else {
                mItemName = (TextView) itemView.findViewById(R.id.title);
                mIconImage = (ImageView) itemView.findViewById(R.id.icon);
            }

            // Set the itemClickListener
            itemView.setOnClickListener(this);
        }

        public void bindViewHolder(int position) {
            if(position == 0) {
                mHeaderText.setText("Sojourner Menu");
            } else {
                DrawerItem drawerItem = mItemList.get(position);
                mItemName.setText(drawerItem.getmTitle());
                mIconImage.setImageResource(drawerItem.getmIcon());
            }
        }

        @Override
        public void onClick(View view) {
            mListener.onItemSelected(view, getAdapterPosition());
        }
    }
}
