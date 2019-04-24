package com.sid.project.libMgmtSystem.spring.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sid.project.libMgmtSystem.model.BooksDTO;

@Repository
public class BooksRepositoryImpl implements BooksRepository {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public void insertBookToDB(final BooksDTO book) {

		final String insert_sql = "insert into books(book_name, book_author, book_cost) values (?,?,?)";

		jdbctemplate.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(insert_sql);

				ps.setString(1, book.getBookName());
				ps.setString(2, book.getBookAuthor());
				ps.setFloat(3, book.getBookPrice());

				return ps;
			}
		});
	}

	public List<BooksDTO> getAllBooks() {
		return jdbctemplate.query("select * from books", new RowMapper<BooksDTO>() {

			public BooksDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BooksDTO book = new BooksDTO();

				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookAuthor(rs.getString(3));
				book.setBookPrice(rs.getFloat(4));

				return book;
			}
		});
	}

	public List<BooksDTO> getBooksByName(String bookName) {

		final String sqlQuery = "select * from books where lower(book_name) like ?";

		return jdbctemplate.query(sqlQuery, new String[] { "%" + bookName.toLowerCase().trim() + "%" },
			new RowMapper<BooksDTO>() {

				public BooksDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					BooksDTO book = new BooksDTO();

					book.setBookId(rs.getInt(1));
					book.setBookName(rs.getString(2));
					book.setBookAuthor(rs.getString(3));
					book.setBookPrice(rs.getFloat(4));

					return book;
				}

			}
		);
	}

}
