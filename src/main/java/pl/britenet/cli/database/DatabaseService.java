package pl.britenet.cli.database;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DatabaseService {

    private final HikariDataSource dataSource;

    public DatabaseService() {
        this.dataSource = new HikariDataSource(HikariConfigFactory.prepareDevRootConfig());
    }

    public void performDML(String dml) {
        try (Connection connection = this.dataSource.getConnection() ;
             PreparedStatement statement = connection.prepareStatement(dml)) {

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public<T> Optional<T> performSQL(String sql, ResultsParser<T> parser) {
        try (Connection connection = this.dataSource.getConnection() ;
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            return Optional.ofNullable(parser.parse(resultSet));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
