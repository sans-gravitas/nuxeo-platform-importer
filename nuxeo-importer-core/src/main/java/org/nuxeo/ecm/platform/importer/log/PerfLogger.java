package org.nuxeo.ecm.platform.importer.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.nuxeo.common.utils.Path;
import org.nuxeo.runtime.api.Framework;

public class PerfLogger {

    protected String[] headers;

    protected File logFile;

    protected Writer logWriter;

    protected static final String SEP = ";";

    public PerfLogger(String[] headers) throws IOException {
        this.headers = headers;
        File home = Framework.getRuntime().getHome();
        String logPath = new Path(home.getAbsolutePath()).append(
                "perfLog_" + System.currentTimeMillis() + ".csv").toString();
        logFile = new File(logPath);
        logWriter = new FileWriter(logFile);
        log(headers);
    }

    public void log(String[] data) throws IOException {
        StringBuffer sb = new StringBuffer();
        sb.append(System.currentTimeMillis());
        for (String s : data) {
            sb.append(SEP);
            sb.append("\"");
            sb.append(s);
            sb.append("\"");
        }
        sb.append("\n");
        logWriter.write(sb.toString());
    }

    public void log(Double[] data) throws IOException {
        StringBuffer sb = new StringBuffer();
        sb.append(System.currentTimeMillis());
        for (Double d : data) {
            sb.append(SEP);
            sb.append(d.toString());
        }
        sb.append("\n");
        logWriter.write(sb.toString());
        logWriter.flush();
    }

    public void release() throws IOException {
        if (logWriter != null) {
            logWriter.flush();
            logWriter.close();
            logWriter = null;
        }
    }
}
