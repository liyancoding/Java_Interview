package com.ly.basic;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 15:33 2018/9/25
 * @Modified By:
 */
public class URIExample {
    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        URI uri = new URI("https://www.qiandu.com:8080/goods/index.html?username=dgh&passwd=123#j2se");

        System.out.println("Scheme             : " + uri.getScheme());
        System.out.println("SchemeSpecificPart : " + uri.getSchemeSpecificPart());
        System.out.println("Authority          : " + uri.getAuthority());
        System.out.println("Host               : " + uri.getHost());
        System.out.println("Port               : " + uri.getPort());
        System.out.println("Path               : " + uri.getPath());
        System.out.println("Query              : " + uri.getQuery());
        System.out.println("Fragment           : " + uri.getFragment());

        System.out.println();
        URL url = new URL("https://www.qiandu.com:8080/goods/index.html?username=dgh&passwd=123#j2se");
        System.out.println("Authority          : " + url.getAuthority());
        System.out.println("Host               : " + url.getHost());
        System.out.println("Port               : " + url.getPort());
        System.out.println("Path               : " + url.getPath());
        System.out.println("Query              : " + url.getQuery());
        System.out.println("File              : " + url.getFile());
    }
}
