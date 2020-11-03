import java.util.List;

public class Start {

    public static void main(String[] args) {
        PublisherDao publisherDao = new PublisherDao();
        List<Publisher> publisherList = publisherDao.findAll();
        publisherList.forEach(System.out::println);

//        try(Connection connection = DriverManager.getConnection(
//                Props.get("url") + Props.get("database") + "?" + "serverTimezone=" + Props.get("serverTimezone"), Props.get("username"), Props.get("password"));
//            Statement statement = connection.createStatement()) {
//            // 1
////
//            // 2
//
////                "jdbc:mysql://localhost:3306/pubs?serverTimezone=UTC", "root", "rootroot");
//
//            // 3
//            ;
//
//            // 4
//            ResultSet resultSet = statement.executeQuery("select pub_id, pub_name, city, state from publishers");
//
//            // 5
//            while (resultSet.next()) {
//                String pub_id = resultSet.getString(1);
//                String pub_name = resultSet.getString(2);
//
//                System.out.println(pub_id + ", " + pub_name);
//            }
//
//            //3
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO publishers VALUES (?,?,?,?,?)");
//            preparedStatement.setString(1, "8888");
//            preparedStatement.setString(2, "Laren");
//            preparedStatement.setString(3, "NLD");
//            preparedStatement.setString(4, "YowYow");
//            preparedStatement.setString(5, "GL");
//            PreparedStatement preparedStatement2 = connection.prepareStatement("INSERT INTO publishers VALUES (?,?,?,?,?)");
//            preparedStatement2.setString(1, "8889");
//            preparedStatement2.setString(2, "Laren");
//            preparedStatement2.setString(3, "NLD");
//            preparedStatement2.setString(4, "YowYow");
//            preparedStatement2.setString(5, "GL");
//
//            connection.setAutoCommit(false);
//            preparedStatement.execute();
//            preparedStatement2.execute();
//            connection.commit();
//
//            // 6
//
//
//        } catch (SQLException e) {
//            System.err.println("Er gaat iets mis met SQL..." + e.getMessage());
//            e.printStackTrace();
//        }
    }

}