package com.gatheringhallstudios.mhworlddatabase.common.models;

/**
 * Model for a SectionHeader. Insert these in RecyclerView adapters datasets to display headers
 * within the RecyclerView.
 */
public class SectionHeader {
    public String text;

    public SectionHeader(String text) {
        this.text = text;
    }
}
