package SuiteReader;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties" // mention the property file name
})
public interface Environment extends Config {

    String url();

    String username();

    String password();

    String servername();

    @Config.Key("db.hostname")
    String getDBHostname();

    @Key("db.port")
    int getDBPort();

    @Key("db.username")
    String getDBUsername();

    @Key("db.password")
    String getDBPassword();

}