package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Java11Test {


    @Test
    public void strTest(){
        var a = "张三";
        a.isBlank();
        a.strip();
        a.stripTrailing();
        a.stripLeading();
        var b = a.repeat(3);
        System.out.println(b);
        b.lines().count();
    }

    @Test
    public void collectionTest(){
        var list = List.of("aa","bb");
        List copy = List.copyOf(list);

        list.add("cc");
        var list1 = new ArrayList<String>();
    }

    @Test
    public void netTest() throws IOException, InterruptedException {
        var request = HttpRequest.newBuilder().uri(URI.create("")).GET().build();
        var client = HttpClient.newHttpClient();

        //同步
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        //异步
        client.sendAsync(request,HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(System.out::println);

    }
}
