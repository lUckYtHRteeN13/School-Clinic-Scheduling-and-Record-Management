/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ProjectUtilities;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 *
 * @author netha
 */
public class DataPollerThread<T> extends Thread {
    private final Supplier<List<T>> fetchFunction;
    private final Consumer<List<T>> onDataReceived;
    private final int intervalSeconds;
    private volatile boolean running = true;

    public DataPollerThread(Supplier<List<T>> fetchFunction, Consumer<List<T>> onDataReceived, int intervalSeconds) {
        this.fetchFunction = fetchFunction;
        this.onDataReceived = onDataReceived;
        this.intervalSeconds = intervalSeconds;
        setDaemon(true); // Optional
    }

    @Override
    public void run() {
        while (running) {
            try {
                List<T> data = fetchFunction.get();
                
                SwingUtilities.invokeLater(() -> onDataReceived.accept(data));
                Thread.sleep(intervalSeconds * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stopPolling() {
        running = false;
    }
}
