package BD;

public class Configuration {
	private String driver;
    /**
     * jdbc url
     */
    private String url;

    /**
     * user
     */
    private String user;

    /**
     * mdp
     */
    private String pwd;

    /**
     * db name
     */
    private String usingDB;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsingDB() {
        return usingDB;
    }

    public void setUsingDB(String usingDB) {
        this.usingDB = usingDB;
    }

    public  String getDriver() {
        return driver;
    }

    public  void setDriver(String driver) {
       this.driver = driver;
    }

    public Configuration(String driver,String url, String user, String pwd, String usingDB) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pwd = pwd;
        this.usingDB = usingDB;
    }

    

    public Configuration() {
        super();
    }
}
