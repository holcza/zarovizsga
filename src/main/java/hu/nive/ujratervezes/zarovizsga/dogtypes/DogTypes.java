package hu.nive.ujratervezes.zarovizsga.dogtypes;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DogTypes {

    private MariaDbDataSource dataSource;
    public DogTypes(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country){
        List<String>dogtypesByCountry = new ArrayList<>();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select name from dog_types where country = ?");
        ) {
            country = country.toUpperCase();
            stmt.setString(1, country);

            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    dogtypesByCountry.add(name.toLowerCase());
                }
                dogtypesByCountry.sort(Collator.getInstance(new Locale("hu","HU")));
                return dogtypesByCountry;
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by select", sqle);
        }

    }
}
