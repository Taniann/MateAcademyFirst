package ua.mateacademy.tania.lesson13.soap;

import javax.xml.ws.Endpoint;

/**
 * Created by Tania Nebesna on 29.01.2019.
 */
public class MainMateGroupServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/mate", new MateGroupServiceImpl());
    }
}
