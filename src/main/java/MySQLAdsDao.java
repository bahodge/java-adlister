import com.mysql.cj.api.mysqla.result.Resultset;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;

    public MySQLAdsDao(Config config){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads_db.ads");
            while (rs.next()){
                Ad ad = new Ad(rs.getLong("id"), rs.getString("title"), rs.getString("description"));
                ads.add(ad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }



    @Override
    public Long insert(Ad ad) {
        try {
            String query = "INSERT INTO ads_db.ads(title, description) VALUES (" + ad.getTitle() + ", " + ad.getDescription() + ")";
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                System.out.println("Inserted a new ad");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ad.getId();
    }

}
