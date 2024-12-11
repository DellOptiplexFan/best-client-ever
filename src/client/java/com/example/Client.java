package com.example;

import com.example.utils.MCInst;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.fabricmc.api.ClientModInitializer;

@Slf4j
public class Client implements ClientModInitializer, MCInst {
    @Getter public static final Client INSTANCE = new Client();

    @Override
    public void onInitializeClient() {}
}