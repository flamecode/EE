package EE_2015.App02_PostgreSQL;

import java.sql.*;

/**
 * Игорь
 * 22.02.2017.
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");  // Закидываем в classpath

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","5238538"); // Устанавливаем соединение
        System.out.println(connection.getClass().getCanonicalName()); // Смотрим какой класс он вернул через Рефлекшн
        // Параметризированный запрос
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM \"Univer\"  WHERE \"Age\" = ?");
        preparedStatement.setInt(1,297);        // Колонка одна, найти в ней возраст 297 лет

        ResultSet resultSet = preparedStatement.executeQuery();  //Выполнить запрос
        while(resultSet.next()){
            System.out.println("Age: " + resultSet.getInt("Age") + " Name: " + resultSet.getString("Name"));
        }


        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
