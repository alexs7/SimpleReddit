package com.aristech.simplereddit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.aristech.simplereddit.pojo.ChildrenItem;

public class RedditItemAdapter extends PagedListAdapter<ChildrenItem, RedditItemAdapter.ItemViewHolder> {

  private Context mCtx;

  protected RedditItemAdapter(Context ctx) {
	super(DIFF_CALLBACK);
	this.mCtx = ctx;
  }

  @NonNull
  @Override
  public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
	View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerviewitem, viewGroup, false);
	return new ItemViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
	ChildrenItem item = getItem(position);

	if(item != null){
	  holder.textView.setText(item.getData().getTitle());
	}else{
	  Toast.makeText(mCtx, "Item is Null", Toast.LENGTH_SHORT).show();
	}
  }

  private static DiffUtil.ItemCallback<ChildrenItem> DIFF_CALLBACK =
		  new DiffUtil.ItemCallback<ChildrenItem>() {
			// old(..Item) / new (t1) here parameters
			@Override
			public boolean areItemsTheSame(@NonNull ChildrenItem childrenItem, @NonNull ChildrenItem t1) {
			  return childrenItem.getData().getId().equals(t1.getData().getId());
			}

			@Override
			public boolean areContentsTheSame(@NonNull ChildrenItem childrenItem, @NonNull ChildrenItem t1) {
			  return childrenItem.equals(t1); //ignore error
			}
		  };

  class ItemViewHolder extends RecyclerView.ViewHolder{

	TextView textView;

	public ItemViewHolder(@NonNull View itemView) {
	  super(itemView);

	  textView = itemView.findViewById(R.id.textViewTitle);
	}
  }

}
