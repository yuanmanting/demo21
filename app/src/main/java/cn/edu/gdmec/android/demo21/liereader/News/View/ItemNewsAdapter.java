package cn.edu.gdmec.android.demo21.liereader.News.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cn.edu.gdmec.android.demo21.R;
import cn.edu.gdmec.android.demo21.liereader.Bean.NewBean;
import cn.edu.gdmec.android.demo21.liereader.Video.ADetailActivity;

/**
 * Created by apple on 18/5/29.
 */

public class ItemNewsAdapter extends RecyclerView.Adapter<ItemNewsAdapter.ItemNewsHolder> {

    private List<NewBean.Bean> objects = new ArrayList<NewBean.Bean>();

    private Context context;

    public ItemNewsAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<NewBean.Bean> objects) {
        this.objects = objects;
    }

    @Override
    public ItemNewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        return new ItemNewsHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemNewsHolder holder, int position) {
        NewBean.Bean bean = objects.get(position);
        if (bean == null) {
            return;
        }
        Glide.with(context)
                .load(bean.getImgsrc())
                .into(holder.ivNewsImg);
        if (position == 0) {
            holder.tvNewsDigest.setVisibility(View.GONE);
            holder.tvNewsTitle.setText("图片：" + bean.getTitle());
        } else {
            holder.tvNewsTitle.setText(bean.getTitle());
            holder.tvNewsDigest.setText(bean.getMtime() + " : " + bean.getDigest());
        }
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    protected class ItemNewsHolder extends RecyclerView.ViewHolder {
        private ImageView ivNewsImg;
        private TextView tvNewsTitle;
        private TextView tvNewsDigest;

        public ItemNewsHolder(View view) {
            super(view);
            ivNewsImg = (ImageView) view.findViewById(R.id.iv_news_img);
            tvNewsTitle = (TextView) view.findViewById(R.id.tv_news_title);
            tvNewsDigest = (TextView) view.findViewById(R.id.tv_news_digest);
        }
    }
}
