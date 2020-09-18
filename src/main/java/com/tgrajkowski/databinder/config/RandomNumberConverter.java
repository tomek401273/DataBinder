package com.tgrajkowski.databinder.config;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RandomNumberConverter extends AbstractHttpMessageConverter<RandomNumer> {

    public RandomNumberConverter() {
        super(MediaType.TEXT_PLAIN);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return RandomNumer.class.isAssignableFrom(clazz);
    }

    @Override
    protected RandomNumer readInternal(Class<? extends RandomNumer> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        String requestBody = toString(inputMessage.getBody());
        int i = requestBody.indexOf("\n");
        if (i == -1) {
            throw new HttpMessageNotReadableException("No first line found");
        }
        StringTokenizer stringTokenizer = new StringTokenizer(requestBody);

        List<Integer> integerList = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            integerList.add(Integer.valueOf(stringTokenizer.nextToken()));
        }
        return new RandomNumer(integerList);
    }

    @Override
    protected void writeInternal(RandomNumer randomNumer, HttpOutputMessage outputMessage) throws HttpMessageNotWritableException, IOException {
        OutputStream outputStream = outputMessage.getBody();
        String body = randomNumer.getIntegerList().toString();
        outputStream.write(body.getBytes());
        outputStream.close();
    }

    private static String toString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        return scanner.useDelimiter("\\A").next();
    }
}
