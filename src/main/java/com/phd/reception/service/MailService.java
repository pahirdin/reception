package com.phd.reception.service;

import java.util.Map;

/**
 * @author pahaied@asiainfo.com
 * @date 2020-05-09
 */
public interface MailService {
    void sendSimpleMailMessge(String to, String subject, String content);

    void sendMimeMessge(String to, String subject, String content);

    void sendMimeMessge(String to, String subject, String content, String filePath);

    void sendMimeMessge(String to, String subject, String content, Map<String, String> rscIdMap);
}
