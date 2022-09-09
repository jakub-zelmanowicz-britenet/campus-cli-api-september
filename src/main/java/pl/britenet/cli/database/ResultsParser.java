package pl.britenet.cli.database;

import java.sql.ResultSet;

public interface ResultsParser<T> {

    T parse(ResultSet resultSet);

}
