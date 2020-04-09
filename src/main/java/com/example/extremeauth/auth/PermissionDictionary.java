package com.example.extremeauth.auth;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
public class PermissionDictionary {


    private Map<String, Boolean> permissions = new HashMap<>();
    private ArrayList<String> apiDictionary = new ArrayList<>();

    public PermissionDictionary() {
        for (int i = 0; i < 4000; i++) {
            permissions.put("/api" + i, i % 4 == 0);
            apiDictionary.add("/api" + i);
        }
    }

    public String getAllowedApis(String username) {
        byte[] apiPermissions = new byte[apiDictionary.size() / 8];
        for (int i = 0; i < apiDictionary.size(); i += 8) {
            int value = 0;
            for (int j = i; j < i + 8; j++) {
                value *= 2;
                if (permissions.get("/api" + j)) {
                    value += 1;
                }
            }
            apiPermissions[i / 8] = (byte) value;
        }
        return Base64.getEncoder().encodeToString(apiPermissions);
    }

    public int getBit(byte byteValue, int position) {
        return (byteValue >> position) & 1;
    }
}
