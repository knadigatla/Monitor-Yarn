# Monitor-Yarn

### How to run the code

create a properties file in local example file is present in src/main/resources/test.properties which contains the details like RM host and email related details.

#### sample properties file contents:
    rmhost=172.16.5.249
    rmport=8088
    username=hdfs
    alert_type=FAILED
    email_to=user1@gmail.com;user2@gmail.com
    email_from=JobAlert@localhost
    smtp_host=localhost
    protocol=http
    email_subject=Alert - JOBS FAILED Today

#### building the jar with maven

mvn clean:package

### Running the job
java -cp &lt;path to the jar file with dependencies&gt; org.monitor.yarn.MonitorYarn &lt;path to the properties file&gt;


##### eg:
java -cp yarn-1.0-SNAPSHOT-jar-with-dependencies.jar org.monitor.yarn.MonitorYarn /Users/kiran/Documents/github/Monitor-Yarn/src/main/resources/test.properties
