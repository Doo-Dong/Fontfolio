package com.corporation8793.fontfolio.board;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.corporation8793.fontfolio.R;

import java.util.ArrayList;

public class RecyclerBoardAdapter extends RecyclerView.Adapter<RecyclerBoardAdapter.ViewHolder> {
    private ArrayList<BoardItem> mData = null ;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    RecyclerBoardAdapter(ArrayList<BoardItem> list) {
        mData = list ;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public RecyclerBoardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.save_board_item, parent, false) ;
        RecyclerBoardAdapter.ViewHolder vh = new RecyclerBoardAdapter.ViewHolder(view) ;

        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(RecyclerBoardAdapter.ViewHolder holder, int position) {

        BoardItem item = mData.get(position) ;

        holder.icon.setBackgroundResource(item.getBoard_image()); ;
        holder.title.setText(item.getBoard_name()) ;


        holder.itemView.getLayoutParams().height = 75;
        holder.itemView.requestLayout();



    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon ;
        TextView title ;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            icon = itemView.findViewById(R.id.icon) ;
            title = itemView.findViewById(R.id.title) ;
        }
    }
}