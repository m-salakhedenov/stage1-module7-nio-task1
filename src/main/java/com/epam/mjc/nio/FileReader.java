package com.epam.mjc.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String rawData = getRawData(file);

        return null;
    }

    private String getRawData(File file) {
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                FileChannel channel = fileInputStream.getChannel()
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(48);
            StringBuilder rawData = new StringBuilder();

            while (channel.read(buffer) > 0) {
                buffer.flip();
                for (int i = 0; i < buffer.limit(); i++) {
                    rawData.append((char) buffer.get(i));
                }
                buffer.clear();
            }

            return rawData.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
