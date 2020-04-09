package com.example.extremeauth.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PermissionDictionary {


    private Map<String, Boolean> permissions = new HashMap<>();

    public PermissionDictionary() {
        for (int i = 0; i < 3000; i++) {
            permissions.put("/api" + i, i % 3 == 0);
        }
    }

    public List<String> getAllowedApis(String username) {
        return permissions.entrySet().stream().filter(Map.Entry::getValue).map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
