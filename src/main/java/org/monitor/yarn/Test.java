package org.monitor.yarn;

import java.io.File;

/**
 * Created by kiran on 3/3/16.
 */
public class Test {

    public static void main(String[] args) {

        File fd = new File(args[0]);

        PropertyFetcher pfetch = new PropertyFetcher(fd);

        StringBuilder sb_url = new StringBuilder();

        sb_url.append(pfetch.getProperty("protocol"));
        sb_url.append("://");
        sb_url.append(pfetch.getProperty("rmhost"));
        sb_url.append(":"+pfetch.getProperty("rmport"));
        sb_url.append("/ws/v1/cluster/apps");

        System.out.println(sb_url.toString());
    }
}
