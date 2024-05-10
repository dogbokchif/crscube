package com.example.highschool.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccessPoint {
    private final Map<String, List<String>> path = new HashMap<>();

    public void add(String path, List<String> access) {
        this.path.put(path, access);
    }
    public boolean permissionsCheck(String path, String access) {
        List<String> accessList = this.path.get(path);

        if (accessList == null) return true;
        if (access == null && !accessList.isEmpty()) return false;
        return accessList.contains(access);
    }
}
