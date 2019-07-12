package com.app.multiitembasequickadapterdemo;
public class MyMultiItemEntity implements com.chad.library.adapter.base.entity.MultiItemEntity {
    public static final int SEND = 0;
    public static final int FROM = 1;
    private int itemType;
    private String content;

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
