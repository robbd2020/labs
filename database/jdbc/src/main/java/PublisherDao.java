
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static util.Props.get;

public class PublisherDao {

//    private final Logger log = LoggerFactory.getLogger(PublisherDao.class);

    public List<Publisher> findAll() {
        try (Connection connection = DriverManager.getConnection(
                get("url") + get("database") + "?" + "serverTimezone=" + get("serverTimezone"), get("username"), get("password"));
             Statement statement = connection.createStatement()) {
            List<Publisher> publishers = new ArrayList<>();

            ResultSet resultSet = statement.executeQuery("select pub_id, pub_name, city, state from publishers");

            while (resultSet.next()) {
                String pub_id = resultSet.getString(1);
                String pub_name = resultSet.getString(2);
                String city = resultSet.getString("city");

                Publisher p = new Publisher(pub_id, pub_name, city);
                publishers.add(p);
            }

            return publishers;
        } catch (SQLException e) {
//            log.error("", e);
            return null;
        }

    }
}