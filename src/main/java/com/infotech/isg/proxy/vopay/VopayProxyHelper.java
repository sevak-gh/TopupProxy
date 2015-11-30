package com.infotech.isg.proxy.vopay;

import com.infotech.isg.proxy.ProxyAccessException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.StringReader;
import javax.xml.transform.stream.StreamSource;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.util.Map;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * helper for vopay to make connection, sends request and receives response
 *
 * throws ProxyAccessException (unchecked) for failure in connection/send/receive/parse
 * throws RuntimeException for other failures

 * @author Sevak Gharibian
 */
public class VopayProxyHelper {

    private static final Logger LOG = LoggerFactory.getLogger(VopayProxyHelper.class);

    public static <T> T call(String request, String address, Class<T> responseType) {
        HttpURLConnection cnn = null;
        BufferedReader reader = null;
        DataOutputStream writer = null;
        try {
            URL url = new URL(address);
            cnn = (HttpURLConnection)url.openConnection();
            cnn.setRequestMethod("POST");
            cnn.setDoOutput(true);
            byte[] data = request.getBytes();
            cnn.connect();
            if (LOG.isDebugEnabled()) {
                StringBuilder sb = new StringBuilder();
                sb.append("POST\n");
                sb.append("Content-Type: application/x-www-form-urlencoded\n");
                sb.append(String.format("Content-Length: %d\n", data.length));
                sb.append(request);
                LOG.debug("sending to [{}]:{}", url.toString(), sb.toString());
            }
            writer = new DataOutputStream(cnn.getOutputStream());
            writer.write(data, 0, data.length);
            writer.flush();
            writer.close();
            reader = new BufferedReader(new InputStreamReader(cnn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            if (LOG.isDebugEnabled()) {
                StringBuilder sb = new StringBuilder();
                Map<String, List<String>> map = cnn.getHeaderFields();
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    sb.append(String.format("%s: %s\n", entry.getKey(), entry.getValue()));
                }
                sb.append(response.toString());
                LOG.debug("received from [{}]:{}", url.toString(), sb.toString());
            }
            return readJson(response.toString(), responseType);
        } catch (MalformedURLException e) {
            throw new RuntimeException("malformed URL", e);
        } catch (IOException e) {
            throw new ProxyAccessException("vopay operator connection/send/receive error", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    LOG.error("error while closing reader in vopap connection", e);
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    LOG.error("error while closing writer in vopap connection", e);
                }
            }
            if (cnn != null) {
                cnn.disconnect();
            }
        }
    }

    private static <T> T readJson(String content, Class<T> type) {
        T obj = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            obj = type.cast(mapper.readValue(content, type));
        } catch (IOException e) {
            throw new ProxyAccessException("error while parsing json response from vopay", e);
        }
        return obj;
    }
}
