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
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReportConverter extends AbstractHttpMessageConverter<Report> {

    public ReportConverter() {
        super(MediaType.TEXT_PLAIN);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return Report.class.isAssignableFrom(clazz);
    }

    @Override
    protected Report readInternal(Class<? extends Report> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        String requestBody = toString(inputMessage.getBody());
        int i = requestBody.indexOf("\n");
        if (i == -1) {
            throw new HttpMessageNotReadableException("No first line found");
        }
        StringTokenizer stringTokenizer = new StringTokenizer(requestBody);
        Report report = new Report();
        while (stringTokenizer.hasMoreTokens()) {
            report.getIntegerList().add(Integer.valueOf(stringTokenizer.nextToken()));
        }

        return report;
    }

    @Override
    protected void writeInternal(Report report, HttpOutputMessage outputMessage) throws HttpMessageNotWritableException, IOException {
        OutputStream outputStream = outputMessage.getBody();
        String body = report.getReportName() + "\n" +
                report.getContent();
        outputStream.write(body.getBytes());
        outputStream.close();
    }

    private static String toString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        return scanner.useDelimiter("\\A").next();
    }
}
