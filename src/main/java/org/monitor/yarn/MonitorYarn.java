package org.monitor.yarn;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by kiran on 3/2/16.
 */
public class MonitorYarn {

        public void test(){
            InputStream in = null;

            try {
//            in = new URL( "http://172.16.5.249:8088/ws/v1/cluster/apps" ).openStream();
                in = new URL( "file:///Users/kiran/Desktop/test.json" ).openStream();
                JSONObject jobj = new JSONObject(IOUtils.toString( in ));
                List<Application> listAppl = new ArrayList<Application>();

                System.out.println("test");

                JSONArray newobjArray = (jobj.getJSONObject("apps")).getJSONArray("app");

                for (int i=0; i < newobjArray.length(); i++) {

                    Application app = new Application();
                    app.setId(newobjArray.getJSONObject(i).getString("id"));
                    app.setUser(newobjArray.getJSONObject(i).getString("user"));
                    app.setName(newobjArray.getJSONObject(i).getString("name"));
                    app.setQueue(newobjArray.getJSONObject(i).getString("queue"));
                    app.setState(newobjArray.getJSONObject(i).getString("state"));
                    app.setFinalStatus(newobjArray.getJSONObject(i).getString("finalStatus"));
                    app.setProgress(newobjArray.getJSONObject(i).getDouble("progress"));
                    app.setStartedTime(new Timestamp(newobjArray.getJSONObject(i).getLong("startedTime")));
                    app.setFinishedTime(new Timestamp(newobjArray.getJSONObject(i).getLong("finishedTime")));
                    app.setElapsedTime(newobjArray.getJSONObject(i).getLong("elapsedTime")/1000.0);

                    listAppl.add(app);
                }

                System.out.println(listAppl.size());

            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                IOUtils.closeQuietly(in);
            }
        }


        public static List<Application> listApplications(String url) {

            InputStream in = null;
            List<Application> listAppl = null;

            try {
                in = new URL(url).openStream();

                JSONObject jobj = new JSONObject(IOUtils.toString( in ));
                listAppl = new ArrayList<Application>();
                JSONArray jsonAppArray = (jobj.getJSONObject("apps")).getJSONArray("app");

                for (int i=0; i < jsonAppArray.length(); i++) {

                    Application app = new Application();
                    app.setId(jsonAppArray.getJSONObject(i).getString("id"));
                    app.setUser(jsonAppArray.getJSONObject(i).getString("user"));
                    app.setName(jsonAppArray.getJSONObject(i).getString("name"));
                    app.setQueue(jsonAppArray.getJSONObject(i).getString("queue"));
                    app.setState(jsonAppArray.getJSONObject(i).getString("state"));
                    app.setFinalStatus(jsonAppArray.getJSONObject(i).getString("finalStatus"));
                    app.setProgress(jsonAppArray.getJSONObject(i).getDouble("progress"));
                    app.setStartedTime(new Timestamp(jsonAppArray.getJSONObject(i).getLong("startedTime")));
                    app.setFinishedTime(new Timestamp(jsonAppArray.getJSONObject(i).getLong("finishedTime")));
                    app.setElapsedTime(jsonAppArray.getJSONObject(i).getLong("elapsedTime")/1000.0);

                    listAppl.add(app);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                IOUtils.closeQuietly(in);
            }
            return listAppl;
        }

        public static List<Application> listApplicationsWithJson(String json) {

            List<Application> listAppl = null;

            JSONObject jobj = new JSONObject(json);
            listAppl = new ArrayList<Application>();
            JSONArray jsonAppArray = (jobj.getJSONObject("apps")).getJSONArray("app");

            for (int i=0; i < jsonAppArray.length(); i++) {

                Application app = new Application();
                app.setId(jsonAppArray.getJSONObject(i).getString("id"));
                app.setUser(jsonAppArray.getJSONObject(i).getString("user"));
                app.setName(jsonAppArray.getJSONObject(i).getString("name"));
                app.setQueue(jsonAppArray.getJSONObject(i).getString("queue"));
                app.setState(jsonAppArray.getJSONObject(i).getString("state"));
                app.setFinalStatus(jsonAppArray.getJSONObject(i).getString("finalStatus"));
                app.setProgress(jsonAppArray.getJSONObject(i).getDouble("progress"));
                app.setStartedTime(new Timestamp(jsonAppArray.getJSONObject(i).getLong("startedTime")));
                app.setFinishedTime(new Timestamp(jsonAppArray.getJSONObject(i).getLong("finishedTime")));
                app.setElapsedTime(jsonAppArray.getJSONObject(i).getLong("elapsedTime")/1000.0);

                listAppl.add(app);
            }


            return listAppl;
        }

        public static List<Application> failedApplications(String url) {

            InputStream in = null;
            List<Application> listAppl = null;

            try {
                in = new URL(url+"?finalStatus=FAILED").openStream();

                JSONObject jobj = new JSONObject(IOUtils.toString( in ));
                listAppl = new ArrayList<Application>();
                JSONArray jsonAppArray = (jobj.getJSONObject("apps")).getJSONArray("app");

                for (int i=0; i < jsonAppArray.length(); i++) {

                    Application app = new Application();
                    app.setId(jsonAppArray.getJSONObject(i).getString("id"));
                    app.setUser(jsonAppArray.getJSONObject(i).getString("user"));
                    app.setName(jsonAppArray.getJSONObject(i).getString("name"));
                    app.setQueue(jsonAppArray.getJSONObject(i).getString("queue"));
                    app.setState(jsonAppArray.getJSONObject(i).getString("state"));
                    app.setFinalStatus(jsonAppArray.getJSONObject(i).getString("finalStatus"));
                    app.setProgress(jsonAppArray.getJSONObject(i).getDouble("progress"));
                    app.setStartedTime(new Timestamp(jsonAppArray.getJSONObject(i).getLong("startedTime")));
                    app.setFinishedTime(new Timestamp(jsonAppArray.getJSONObject(i).getLong("finishedTime")));
                    app.setElapsedTime(jsonAppArray.getJSONObject(i).getLong("elapsedTime")/1000.0);

                    listAppl.add(app);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                IOUtils.closeQuietly(in);
            }
            return listAppl;
        }

        public static boolean sendEmail(String content) {

            // Recipient's email ID needs to be mentioned.
            String to = "knadigatla@gmail.com";
            String to1 = "vchimmani@gmail.com";

            // Sender's email ID needs to be mentioned
            String from = "test-java@gmail.com";

            // Assuming you are sending email from localhost
            String host = "localhost";

            // Get system properties
            Properties properties = System.getProperties();

            // Setup mail server
            properties.setProperty("mail.smtp.host", host);

            // Get the default Session object.
            Session session = Session.getDefaultInstance(properties);

            try{
                // Create a default MimeMessage object.
                MimeMessage message = new MimeMessage(session);

                // Set From: header field of the header.
                message.setFrom(new InternetAddress(from));

                // Set To: header field of the header.
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to1));


                // Set Subject: header field
                message.setSubject("This is the Subject Line!");

                // Send the actual HTML message, as big as you like
                message.setContent(content, "text/html" );

                // Send message
                Transport.send(message);
                System.out.println("Sent message successfully....");
                return true;

            }catch (MessagingException mex) {
                mex.printStackTrace();
            }
            return false;
        }

        public static void main(String[] args) {

            if(args.length != 1){
                System.out.println("Invalid number of arguments.\n " +
                        "Usage -> java -jar <jar file name>.jar -classpath org.monitor.yarn.MonitorYarn <path to properties file>");
                System.exit(1);
            }
            File fd = new File(args[0]);

            if(!fd.isFile()) {
                System.out.println("Invalid Properties file path, make sure you have file available");
            }else {

                PropertyFetcher pfetch = new PropertyFetcher(fd);

                StringBuilder sb_url = new StringBuilder();

                sb_url.append(pfetch.getProperty("protocol"));
                sb_url.append("://");
                sb_url.append(pfetch.getProperty("rmhost"));
                sb_url.append(":"+pfetch.getProperty("rmport"));
                sb_url.append("/ws/v1/cluster/apps");

                List<Application> listApps = failedApplications(sb_url.toString());
//                List<Application> listApps = failedApplications("file:///Users/kiran/Desktop/test.json");

                StringBuilder sb = new StringBuilder();

                sb.append("<html>");
                sb.append("<body>");

                sb.append("<table border=\"1\" style=\"width:100%\">");
                sb.append("<tr>");
                sb.append("<th>Application ID</th>");
                sb.append("<th>Job Status</th>");
                sb.append("<th>Job Finished At</th>");
                sb.append("<th>Elapsed Time in Seconds</th>");
                sb.append("</tr>");

                for (Application x : listApps) {

                    sb.append("<tr>");
                    sb.append("<td>" + x.getId() + "</td>");
                    sb.append("<td>" + x.getFinalStatus() + "</td>");
                    sb.append("<td>" + x.getFinishedTime() + "</td>");
                    sb.append("<td>" + x.getElapsedTime() + "</td>");

                    sb.append("</tr>");

//                System.out.println(x.getId());

                }

                sb.append("</table>");
                sb.append("</body>");
                sb.append("</html>");

                sendEmail(sb.toString());
            }

        }



}
