package com.app.multiitembasequickadapterdemo;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import static com.app.multiitembasequickadapterdemo.MyMultiItemEntity.FROM;
import static com.app.multiitembasequickadapterdemo.MyMultiItemEntity.SEND;

public class MainAdapter extends BaseMultiItemQuickAdapter<MyMultiItemEntity, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MainAdapter(List<MyMultiItemEntity> data) {
        super(data);
        addItemType(SEND, R.layout.chat_send_msg);
        addItemType(FROM, R.layout.chat_from_msg);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyMultiItemEntity item) {
        switch (helper.getItemViewType()){
            case SEND:
                helper.setText(R.id.tv_send_content, item.getContent());
                break;
            case FROM:
                helper.setText(R.id.tv_from_content, item.getContent());
                break;
        }
    }
}
