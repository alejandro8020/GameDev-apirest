package com.informatorio.GameDevapirest.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Component
@RequiredArgsConstructor
@Slf4j
public class BootstrapData implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        loaddesarrollador();
    }

    private void loaddesarrollador() {

    }
}
