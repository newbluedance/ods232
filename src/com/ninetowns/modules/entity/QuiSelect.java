package com.ninetowns.modules.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 2014/10/10.
 */
public class QuiSelect {
    private String key;
    private String value;

    public QuiSelect() {
    }

    public QuiSelect(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
